package com.swp_group4.back_end.mapper;

import com.swp_group4.back_end.entities.ConstructionTasks;
import com.swp_group4.back_end.responses.ConstructTaskStatusResponse;
import com.swp_group4.back_end.responses.DeadlineConstructionResponse;
import com.swp_group4.back_end.responses.ListConstructProgressResponse;
import java.time.ZoneOffset;
import java.util.Date;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
@Component
public class ConstructionTasksMapperImpl implements ConstructionTasksMapper {

    @Override
    public DeadlineConstructionResponse mapDeadlineConstructionResponse(ConstructionTasks deadlineConstructionRequest) {
        if ( deadlineConstructionRequest == null ) {
            return null;
        }

        DeadlineConstructionResponse.DeadlineConstructionResponseBuilder deadlineConstructionResponse = DeadlineConstructionResponse.builder();

        deadlineConstructionResponse.taskId( deadlineConstructionRequest.getTaskId() );
        if ( deadlineConstructionRequest.getStartDate() != null ) {
            deadlineConstructionResponse.startDate( Date.from( deadlineConstructionRequest.getStartDate().toInstant( ZoneOffset.UTC ) ) );
        }
        if ( deadlineConstructionRequest.getEndDate() != null ) {
            deadlineConstructionResponse.endDate( Date.from( deadlineConstructionRequest.getEndDate().toInstant( ZoneOffset.UTC ) ) );
        }

        return deadlineConstructionResponse.build();
    }

    @Override
    public ConstructTaskStatusResponse toConstructTaskStatusResponse(ConstructionTasks constructionTasks, ConstructTaskStatusResponse constructTaskStatusResponse) {
        if ( constructionTasks == null ) {
            return constructTaskStatusResponse;
        }

        constructTaskStatusResponse.setTaskId( constructionTasks.getTaskId() );
        if ( constructionTasks.getStartDate() != null ) {
            constructTaskStatusResponse.setStartDate( Date.from( constructionTasks.getStartDate().toInstant( ZoneOffset.UTC ) ) );
        }
        else {
            constructTaskStatusResponse.setStartDate( null );
        }
        if ( constructionTasks.getEndDate() != null ) {
            constructTaskStatusResponse.setEndDate( Date.from( constructionTasks.getEndDate().toInstant( ZoneOffset.UTC ) ) );
        }
        else {
            constructTaskStatusResponse.setEndDate( null );
        }
        constructTaskStatusResponse.setStatus( constructionTasks.getStatus() );

        return constructTaskStatusResponse;
    }

    @Override
    public ListConstructProgressResponse toListConstructProgressResponse(ConstructionTasks constructionTasks, ListConstructProgressResponse listConstructProgressResponse) {
        if ( constructionTasks == null ) {
            return listConstructProgressResponse;
        }

        listConstructProgressResponse.setTaskId( constructionTasks.getTaskId() );
        if ( constructionTasks.getStartDate() != null ) {
            listConstructProgressResponse.setStartDate( Date.from( constructionTasks.getStartDate().toInstant( ZoneOffset.UTC ) ) );
        }
        else {
            listConstructProgressResponse.setStartDate( null );
        }
        if ( constructionTasks.getEndDate() != null ) {
            listConstructProgressResponse.setEndDate( Date.from( constructionTasks.getEndDate().toInstant( ZoneOffset.UTC ) ) );
        }
        else {
            listConstructProgressResponse.setEndDate( null );
        }
        listConstructProgressResponse.setStatus( constructionTasks.getStatus() );

        return listConstructProgressResponse;
    }
}
