package com.swp_group4.back_end.services;

import com.swp_group4.back_end.entities.*;
import com.swp_group4.back_end.enums.ConstructStatus;
import com.swp_group4.back_end.enums.ConstructionOrderStatus;
import com.swp_group4.back_end.enums.DesignStatus;
import com.swp_group4.back_end.enums.QuotationStatus;
import com.swp_group4.back_end.mapper.*;
import com.swp_group4.back_end.repositories.*;
import com.swp_group4.back_end.requests.*;
import com.swp_group4.back_end.responses.*;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class ManageConstructionOrderService {

    @Autowired
    ConstructOrderRepository constructOrderRepository;
    @Autowired
    ConstructionOrderMapper constructionOrderMapper;

    public List<ConstructOrderDetailForManagerResponse> listAllConstructOrders(String status) {
        List<ConstructOrderDetailForManagerResponse> responses = new ArrayList<>();
        List<ConstructionOrder> orders = new ArrayList<>();
        switch (status) {
            case "all": {
                orders = constructOrderRepository.findAll();
                break;
            }
            case "consulting": {
                orders = constructOrderRepository.findByStatus(ConstructionOrderStatus.CONSULTING);
                break;
            }
            case "designing" : {
                orders = constructOrderRepository.findByStatus(ConstructionOrderStatus.DESIGNING);
                break;
            }
            default: {
                break;
            }
        }
        for (ConstructionOrder constructionOrder : orders) {
            Customer customer = constructionOrder.getCustomer();
            ConstructOrderDetailForManagerResponse response = ConstructOrderDetailForManagerResponse.builder()
                    .customerName(customer.getFirstName() + " " + customer.getLastName())
                    .phone(customer.getPhone())
                    .address(customer.getAddress())
                    .consultantName((constructionOrder.getConsultant() != null) ? constructionOrder.getConsultant().getStaffName() : "")
                    .designerName((constructionOrder.getDesigner() != null) ? constructionOrder.getDesigner().getStaffName() : "")
                    .constructorLeaderName((constructionOrder.getConstructorLeader() != null) ? constructionOrder.getConstructorLeader().getStaffName() : "")
                    .packageType((constructionOrder.getQuotation() != null && constructionOrder.getQuotation().getPackages() != null) ?
                            constructionOrder.getQuotation().getPackages().getPackageType() : "")
                    .quotationStatus((constructionOrder.getQuotation() != null) ? constructionOrder.getQuotation().getQuotationStatus() : QuotationStatus.NOT_YET)
                    .designStatus((constructionOrder.getDesign() != null) ? constructionOrder.getDesign().getDesignStatus() : DesignStatus.NOT_YET)
                    .build();
            responses.add(constructionOrderMapper.constructionOrderToConstructOrderDetailForManagerResponse(constructionOrder,response));
        }
        responses.sort(Comparator.comparing(
                ConstructOrderDetailForManagerResponse::getStartDate,
                Comparator.nullsLast(Comparator.naturalOrder())
        ).reversed());
        return responses;
    }

}
