package com.swp_group4.back_end.responses;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class PackageTypesResponse {

    String packageId;
    String packageType;
    List<PackageTypesPriceResponse> priceResponseList;
    List<PackageTypesConstructionContentResponse> constructionContentResponses;

}
