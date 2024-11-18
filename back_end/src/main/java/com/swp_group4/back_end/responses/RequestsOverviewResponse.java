package com.swp_group4.back_end.responses;

import com.swp_group4.back_end.enums.ConstructionOrderStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class RequestsOverviewResponse {

    String constructionOrderId;
    String customerName;
    String phone;
    String address;
    LocalDateTime sentDate;
    ConstructionOrderStatus status;

}
