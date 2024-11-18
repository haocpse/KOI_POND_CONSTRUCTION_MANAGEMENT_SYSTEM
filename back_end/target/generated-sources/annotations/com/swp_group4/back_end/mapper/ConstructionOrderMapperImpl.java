package com.swp_group4.back_end.mapper;

import com.swp_group4.back_end.entities.ConstructionOrder;
import com.swp_group4.back_end.responses.ConstructOrderDetailForManagerResponse;
import com.swp_group4.back_end.responses.ProgressReviewResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
@Component
public class ConstructionOrderMapperImpl implements ConstructionOrderMapper {

    @Override
    public ProgressReviewResponse toProgressReviewResponse(ConstructionOrder order, ProgressReviewResponse response) {
        if ( order == null ) {
            return response;
        }

        response.setStartDate( order.getConstructionStartDate() );
        response.setEndDate( order.getConstructionEndDate() );
        response.setConstructionOrderId( order.getConstructionOrderId() );
        response.setStatus( order.getStatus() );

        return response;
    }

    @Override
    public ConstructOrderDetailForManagerResponse constructionOrderToConstructOrderDetailForManagerResponse(ConstructionOrder order, ConstructOrderDetailForManagerResponse response) {
        if ( order == null ) {
            return response;
        }

        response.setTotalPrice( order.getTotal() );
        response.setConstructionOrderId( order.getConstructionOrderId() );
        response.setStartDate( order.getStartDate() );
        response.setEndDate( order.getEndDate() );
        response.setStatus( order.getStatus() );

        return response;
    }
}
