package com.swp_group4.back_end.controllers;

import com.swp_group4.back_end.enums.QuotationStatus;
import com.swp_group4.back_end.responses.*;
import com.swp_group4.back_end.services.StaffService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class StaffController {

    @Autowired
    StaffService staffService;

    @GetMapping("/tasks")
    public ApiResponse<List<RequestsOverviewResponse>> tasks( @RequestParam String role){
        return ApiResponse.<List<RequestsOverviewResponse>>builder()
                .data(staffService.getTasksForRole(role))
                .build();
    }

    @PutMapping("/tasks")
    public ApiResponse<RequestsOverviewResponse> takeAction(@RequestParam String constructionOrderId, @RequestParam String accountId){
        return ApiResponse.<RequestsOverviewResponse>builder()
                .data(staffService.takeTasks(constructionOrderId, accountId))
                .build();
    }

}
