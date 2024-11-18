package com.swp_group4.back_end.responses;

import com.swp_group4.back_end.entities.Staff;
import com.swp_group4.back_end.enums.ConstructionOrderStatus;
import com.swp_group4.back_end.enums.DesignStatus;
import com.swp_group4.back_end.enums.QuotationStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ConstructOrderDetailForManagerResponse {

    String constructionOrderId;
    String customerName;
    String phone;
    String address;
    double totalPrice;
    String packageType;
    LocalDateTime startDate;
    LocalDateTime endDate;
    String consultantName;
    String designerName;
    String constructorLeaderName;
    ConstructionOrderStatus status;
    QuotationStatus quotationStatus;
    DesignStatus designStatus;

}
