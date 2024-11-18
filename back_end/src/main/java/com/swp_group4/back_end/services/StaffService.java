package com.swp_group4.back_end.services;

import com.swp_group4.back_end.entities.*;
import com.swp_group4.back_end.enums.*;
import com.swp_group4.back_end.mapper.CustomerMapper;
import com.swp_group4.back_end.repositories.*;
import com.swp_group4.back_end.responses.*;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StaffService {

    @Autowired
    StaffRepository staffRepository;
    @Autowired
    ConstructOrderRepository constructOrderRepository;
    @Autowired
    CustomerMapper customerMapper;
    @Autowired
    QuotationRepository quotationRepository;
    @Autowired
    DesignRepository designRepository;

    public List<RequestsOverviewResponse> getTasksForRole(String role) {
        List<RequestsOverviewResponse> responses = new ArrayList<>();
        switch (role) {
            case "CONSULTANT": {
                List<ConstructionOrder> orders = constructOrderRepository.findByStatus(ConstructionOrderStatus.REQUESTED);
                for (ConstructionOrder order : orders) {
                    responses.add(buildRequestOverviewResponse(order));
                }
                break;
            }
            case "DESIGNER": {
                List<ConstructionOrder> orders = constructOrderRepository.findByStatus(ConstructionOrderStatus.CONSULTED);
                for (ConstructionOrder order : orders) {
                    responses.add(buildRequestOverviewResponse(order));
                }
                break;
            }
            default: {
                break;
            }
        }
        responses.sort(Comparator.comparing(
                RequestsOverviewResponse::getSentDate,
                Comparator.nullsLast(Comparator.naturalOrder())
        ).reversed());
        return responses;
    }

    public RequestsOverviewResponse takeTasks(String constructionOrderId, String accountId) {
        ConstructionOrder order = constructOrderRepository.findById(constructionOrderId)
                .orElseThrow(() -> new RuntimeException("ConstructionOrder not found for order: " + constructionOrderId));
        Staff staff = staffRepository.findByAccount_AccountId(accountId);
        switch (staff.getAccount().getRole()){
            case Role.CONSULTANT: {
                Quotation quotation = Quotation.builder()
                        .quotationStatus(QuotationStatus.PROCESSING)
                        .build();
                order.setQuotation(quotationRepository.save(quotation));
                order.setConsultant(staff);
                order.setStatus(ConstructionOrderStatus.CONSULTING);
                break;
            }
            case Role.DESIGNER: {
                Design design = Design.builder()
                        .designStatus(DesignStatus.PROCESSING)
                        .build();
                order.setDesign(designRepository.save(design));
                order.setDesigner(staff);
                order.setStatus(ConstructionOrderStatus.DESIGNING);
                break;
            }
            default: {
                break;
            }
        }
        constructOrderRepository.save(order);
        return buildRequestOverviewResponse(order);
    }

    private RequestsOverviewResponse buildRequestOverviewResponse(ConstructionOrder order) {
        Customer customer = order.getCustomer();
        RequestsOverviewResponse response = RequestsOverviewResponse.builder()
                .constructionOrderId(order.getConstructionOrderId())
                .customerName(order.getCustomer().getFirstName() + " " + order.getCustomer().getLastName())
                .sentDate(order.getStartDate())
                .status(order.getStatus())
                .build();
        return customerMapper.customerToRequestsOverviewResponse(customer, response);
    }

}