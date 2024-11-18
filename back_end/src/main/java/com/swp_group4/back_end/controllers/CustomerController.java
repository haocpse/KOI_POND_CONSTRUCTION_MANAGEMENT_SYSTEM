package com.swp_group4.back_end.controllers;

import com.swp_group4.back_end.enums.ConstructionOrderStatus;
import com.swp_group4.back_end.enums.DesignStatus;
import com.swp_group4.back_end.enums.QuotationStatus;
import com.swp_group4.back_end.requests.*;
import com.swp_group4.back_end.responses.*;
import com.swp_group4.back_end.services.CustomerService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class CustomerController {

    @Autowired
    CustomerService customerService;


    @PostMapping("/contact")
    public ApiResponse<ConstructionContactResponse> contactUs(@RequestBody ConstructionContactRequest request) {
        return ApiResponse.<ConstructionContactResponse>builder()
                .data(customerService.contact(request))
                .build();
    }

    @GetMapping("/customer-info")
    public ApiResponse<CustomerResponse> getOwnedInfo(@RequestParam String accountId) {
        return ApiResponse.<CustomerResponse>builder()
                .data(customerService.getOwnedInfo(accountId))
                .build();
    }

}
