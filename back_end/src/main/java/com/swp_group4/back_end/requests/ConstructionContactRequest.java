package com.swp_group4.back_end.requests;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ConstructionContactRequest {

    String constructionOrderId;
    String firstName;
    String lastName;
    String phone;
    String email;
    String address;
    String customerRequest;

}
