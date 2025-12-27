package com.example.tripease.transformer;

import com.example.tripease.dto.request.CustomerRequest;
import com.example.tripease.dto.response.CustomerResponse;
import com.example.tripease.model.Customer;

public  class CustomerTransformer {
    public static Customer customerRequestToCustomer(CustomerRequest customerRequest){


        return Customer.builder().
                name(customerRequest.getName())
                .age(customerRequest.getAge())
                .email_id(customerRequest.getEmail_id())
                .gender(customerRequest.getGender())
                .build();
    }

    public static CustomerResponse customerToCustomerResponse(Customer customer){


        return CustomerResponse.builder()
                .name(customer.getName())
                .age(customer.getAge())
                .email_id(customer.getEmail_id())
                .build();

    }
}
