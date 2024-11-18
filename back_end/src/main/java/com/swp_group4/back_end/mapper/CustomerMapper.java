package com.swp_group4.back_end.mapper;

import com.swp_group4.back_end.entities.Customer;
import com.swp_group4.back_end.requests.ConstructionContactRequest;
import com.swp_group4.back_end.requests.CreateAccountRequest;
import com.swp_group4.back_end.requests.ServiceRequest;
import com.swp_group4.back_end.requests.UpdateInfoRequest;
import com.swp_group4.back_end.responses.*;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CustomerMapper {


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    MaintenanceOrderDetailForManagerResponse toMaintenanceDetailForManager(Customer customer, @MappingTarget MaintenanceOrderDetailForManagerResponse detail);

    Customer constructionContactRequestToCustomer(ConstructionContactRequest request, @MappingTarget Customer customer);
    ConstructionContactResponse customerToConstructionContactResponse(Customer customer, @MappingTarget ConstructionContactResponse response);
    Customer createAccountRequestToCustomer(CreateAccountRequest request, @MappingTarget Customer customer);
    CustomerResponse customerToCustomerResponse(Customer customer, @MappingTarget CustomerResponse response);
    RequestsOverviewResponse customerToRequestsOverviewResponse(Customer customer, @MappingTarget RequestsOverviewResponse response);
}
