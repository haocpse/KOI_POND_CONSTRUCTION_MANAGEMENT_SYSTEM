package com.swp_group4.back_end.mapper;

import com.swp_group4.back_end.entities.Customer;
import com.swp_group4.back_end.requests.ConstructionContactRequest;
import com.swp_group4.back_end.requests.CreateAccountRequest;
import com.swp_group4.back_end.responses.ConstructionContactResponse;
import com.swp_group4.back_end.responses.CustomerResponse;
import com.swp_group4.back_end.responses.MaintenanceOrderDetailForManagerResponse;
import com.swp_group4.back_end.responses.RequestsOverviewResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public MaintenanceOrderDetailForManagerResponse toMaintenanceDetailForManager(Customer customer, MaintenanceOrderDetailForManagerResponse detail) {
        if ( customer == null ) {
            return detail;
        }

        if ( customer.getPhone() != null ) {
            detail.setPhone( customer.getPhone() );
        }
        if ( customer.getAddress() != null ) {
            detail.setAddress( customer.getAddress() );
        }

        return detail;
    }

    @Override
    public Customer constructionContactRequestToCustomer(ConstructionContactRequest request, Customer customer) {
        if ( request == null ) {
            return customer;
        }

        customer.setFirstName( request.getFirstName() );
        customer.setLastName( request.getLastName() );
        customer.setPhone( request.getPhone() );
        customer.setEmail( request.getEmail() );
        customer.setAddress( request.getAddress() );

        return customer;
    }

    @Override
    public ConstructionContactResponse customerToConstructionContactResponse(Customer customer, ConstructionContactResponse response) {
        if ( customer == null ) {
            return response;
        }

        response.setPhone( customer.getPhone() );
        response.setEmail( customer.getEmail() );
        response.setAddress( customer.getAddress() );

        return response;
    }

    @Override
    public Customer createAccountRequestToCustomer(CreateAccountRequest request, Customer customer) {
        if ( request == null ) {
            return customer;
        }

        customer.setFirstName( request.getFirstName() );
        customer.setLastName( request.getLastName() );
        customer.setPhone( request.getPhone() );

        return customer;
    }

    @Override
    public CustomerResponse customerToCustomerResponse(Customer customer, CustomerResponse response) {
        if ( customer == null ) {
            return response;
        }

        response.setFirstName( customer.getFirstName() );
        response.setLastName( customer.getLastName() );
        response.setPhone( customer.getPhone() );
        response.setAddress( customer.getAddress() );
        response.setEmail( customer.getEmail() );

        return response;
    }

    @Override
    public RequestsOverviewResponse customerToRequestsOverviewResponse(Customer customer, RequestsOverviewResponse response) {
        if ( customer == null ) {
            return response;
        }

        response.setPhone( customer.getPhone() );
        response.setAddress( customer.getAddress() );

        return response;
    }
}
