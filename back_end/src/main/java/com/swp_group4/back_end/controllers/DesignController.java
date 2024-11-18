package com.swp_group4.back_end.controllers;

import com.swp_group4.back_end.enums.DesignStatus;
import com.swp_group4.back_end.responses.ApiResponse;
import com.swp_group4.back_end.responses.OverviewOwnedTasksResponse;
import com.swp_group4.back_end.services.DesignService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DesignController {

    @Autowired
    DesignService designService;

    @GetMapping("/owned-tasks/design")
    public ApiResponse<List<OverviewOwnedTasksResponse<DesignStatus>>> listDesign(@RequestParam String accountId) {
        return ApiResponse.<List<OverviewOwnedTasksResponse<DesignStatus>>>builder()
                .data(designService.listOwnedTasks(accountId))
                .build();
    }
//
//    @PostMapping("/constructionOrders/{constructionOrderId}/design")
//    public ApiResponse<Design> uploadDesign(@PathVariable String constructionOrderId,
//                                            @RequestParam("image2D") MultipartFile image2D,
//                                            @RequestParam("image3D") MultipartFile image3D,
//                                            @RequestParam("frontView") MultipartFile frontView ) {
//        return ApiResponse.<Design>builder()
//                .data(designService.saveDesign(constructionOrderId,image2D, image3D, frontView))
//                .build();
//    }
//
//    @GetMapping("/staffs/{accountId}/rejectedDesigns/{designId}")
//    public ApiResponse<ViewRejectedDesignResponse> detailRejectedDesign(@PathVariable String designId, @PathVariable String accountId) {
//        return ApiResponse.<ViewRejectedDesignResponse>builder()
//                .data(designService.viewRejectedDesign(designId))
//                .build();
//    }
//
//    @PutMapping("/staffs/{accountId}/rejectedDesigns/{designId}")
//    public ApiResponse<Design> detailRejectedDesign(@PathVariable String designId,
//                                                    @RequestParam(value = "image2D", required = false) MultipartFile image2D,
//                                                    @RequestParam(value = "image3D", required = false) MultipartFile image3D,
//                                                    @RequestParam(value = "frontView", required = false) MultipartFile frontView, @PathVariable String accountId) {
//        return ApiResponse.<Design>builder()
//                .data(designService.updateDesign(designId,image2D, image3D, frontView))
//                .build();
//    }
//
//
//
//
}
