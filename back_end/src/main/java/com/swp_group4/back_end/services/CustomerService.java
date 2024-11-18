package com.swp_group4.back_end.services;

import com.swp_group4.back_end.entities.*;
import com.swp_group4.back_end.enums.*;
import com.swp_group4.back_end.mapper.ConstructionOrderMapper;
import com.swp_group4.back_end.mapper.CustomerMapper;
import com.swp_group4.back_end.mapper.DesignMapper;
import com.swp_group4.back_end.mapper.QuotationMapper;
import com.swp_group4.back_end.repositories.*;
import com.swp_group4.back_end.requests.*;
import com.swp_group4.back_end.responses.*;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerService {

    @Autowired
    HelperService helperService;
    @Autowired
    CustomerMapper customerMapper;
    @Autowired
    ConstructOrderRepository constructOrderRepository;
    @Autowired
    CustomerRepository customerRepository;

    public ConstructionContactResponse contact(ConstructionContactRequest request) {
        Customer customer = helperService.identify();
        if (customer == null) {
            throw new RuntimeException("Customer not found"); //Change
        }
        customerRepository.save(customerMapper.constructionContactRequestToCustomer(request, customer));
        ConstructionOrder newOrder = ConstructionOrder.builder()
                .customer(customer)
                .customerRequest(request.getCustomerRequest())
                .startDate(LocalDateTime.now())
                .status(ConstructionOrderStatus.REQUESTED)
                .build();
        constructOrderRepository.save(newOrder);
        ConstructionContactResponse response = ConstructionContactResponse.builder()
                .constructionOrderId(newOrder.getConstructionOrderId())
                .customerName(customer.getFirstName() + " " + customer.getLastName())
                .build();
        return customerMapper.customerToConstructionContactResponse(customer, response);
    }

    public CustomerResponse getOwnedInfo(String accountId) {
        Customer customer = customerRepository.findByAccount_AccountId(accountId).orElse(null);
        if (customer == null) {
            throw new RuntimeException("Customer not found"); //Change
        }
        CustomerResponse response = new CustomerResponse();
        return customerMapper.customerToCustomerResponse(customer, response);
    }
}
