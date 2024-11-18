package com.swp_group4.back_end.services;

import com.swp_group4.back_end.entities.*;
import com.swp_group4.back_end.enums.DesignStatus;
import com.swp_group4.back_end.repositories.*;
import com.swp_group4.back_end.responses.OverviewOwnedTasksResponse;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Service
@Slf4j
public class DesignService {

    @Autowired
    StaffRepository staffRepository;
    @Autowired
    ConstructOrderRepository constructOrderRepository;

    public List<OverviewOwnedTasksResponse<DesignStatus>> listOwnedTasks(String accountId) {
        Staff designer = staffRepository.findByAccount_AccountId(accountId);
        List<ConstructionOrder> orders = constructOrderRepository.findByDesigner_StaffId(designer.getStaffId());
        List<OverviewOwnedTasksResponse<DesignStatus>> responses = new ArrayList<>();
        for (ConstructionOrder order : orders) {
            OverviewOwnedTasksResponse<DesignStatus> response = OverviewOwnedTasksResponse.<DesignStatus>builder()
                    .constructionOrderId(order.getConstructionOrderId())
                    .id(order.getQuotation().getQuotationId())
                    .postedDate(order.getQuotation().getPostedDate())
                    .customerName(order.getCustomer().getFirstName() + " " + order.getCustomer().getLastName())
                    .status(order.getDesign().getDesignStatus())
                    .build();
            responses.add(response);
        }
        responses.sort(Comparator.comparing(
                OverviewOwnedTasksResponse<DesignStatus>::getPostedDate,
                Comparator.nullsLast(Comparator.naturalOrder())
        ).reversed());
        return responses;
    }
}
