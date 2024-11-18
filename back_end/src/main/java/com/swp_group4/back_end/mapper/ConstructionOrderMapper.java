package com.swp_group4.back_end.mapper;

import com.swp_group4.back_end.entities.ConstructionOrder;
import com.swp_group4.back_end.entities.Design;
import com.swp_group4.back_end.requests.StaffAssignedRequest;
import com.swp_group4.back_end.responses.*;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ConstructionOrderMapper {

    @Mapping(source = "constructionStartDate", target = "startDate")
    @Mapping(source = "constructionEndDate", target = "endDate")
    ProgressReviewResponse toProgressReviewResponse(ConstructionOrder order, @MappingTarget ProgressReviewResponse response);

    @Mapping(source = "total", target = "totalPrice")
    ConstructOrderDetailForManagerResponse constructionOrderToConstructOrderDetailForManagerResponse(ConstructionOrder order, @MappingTarget ConstructOrderDetailForManagerResponse response);

}
