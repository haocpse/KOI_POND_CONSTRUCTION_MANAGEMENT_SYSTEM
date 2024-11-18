package com.swp_group4.back_end.responses;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class OverviewOwnedTasksResponse<T> {

    String constructionOrderId;
    String id;
    String customerName;
    LocalDateTime postedDate;
    T status;

}
