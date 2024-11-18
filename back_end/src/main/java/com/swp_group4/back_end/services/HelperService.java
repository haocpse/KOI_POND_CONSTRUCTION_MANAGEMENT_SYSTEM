package com.swp_group4.back_end.services;

import com.swp_group4.back_end.entities.Customer;
import com.swp_group4.back_end.repositories.CustomerRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class HelperService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer identify(){
        var context = SecurityContextHolder.getContext();
        String accountId = context.getAuthentication().getName();
        return customerRepository.findByAccount_AccountId(accountId).orElse(null);
    }

}
