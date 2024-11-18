package com.swp_group4.back_end.services;

import com.swp_group4.back_end.entities.ConstructionOrder;
import com.swp_group4.back_end.entities.Staff;
import com.swp_group4.back_end.enums.QuotationStatus;
import com.swp_group4.back_end.repositories.ConstructOrderRepository;
import com.swp_group4.back_end.repositories.StaffRepository;
import com.swp_group4.back_end.responses.OverviewOwnedTasksResponse;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class QuotationService {

    @Autowired
    ConstructOrderRepository constructOrderRepository;
    @Autowired
    StaffRepository staffRepository;

    public List<OverviewOwnedTasksResponse<QuotationStatus>> listOwnedTasks(String accountId) {
        Staff consultant = staffRepository.findByAccount_AccountId(accountId);
        List<ConstructionOrder> orders = constructOrderRepository.findByConsultant_StaffId(consultant.getStaffId());
        List<OverviewOwnedTasksResponse<QuotationStatus>> responses = new ArrayList<>();
        for (ConstructionOrder order : orders) {
            OverviewOwnedTasksResponse<QuotationStatus> response = OverviewOwnedTasksResponse.<QuotationStatus>builder()
                    .constructionOrderId(order.getConstructionOrderId())
                    .id(order.getQuotation().getQuotationId())
                    .postedDate(order.getQuotation().getPostedDate())
                    .customerName(order.getCustomer().getFirstName() + " " + order.getCustomer().getLastName())
                    .status(order.getQuotation().getQuotationStatus())
                    .build();
            responses.add(response);
        }
        responses.sort(Comparator.comparing(
                OverviewOwnedTasksResponse<QuotationStatus>::getPostedDate,
                Comparator.nullsLast(Comparator.naturalOrder())
        ).reversed());
        return responses;
    }
}
