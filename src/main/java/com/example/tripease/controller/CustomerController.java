package com.example.tripease.controller;


import com.example.tripease.Enum.Gender;
import com.example.tripease.dto.request.CustomerRequest;
import com.example.tripease.dto.response.CustomerResponse;
import com.example.tripease.service.CustomerService;
import com.example.tripease.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {


    @Autowired
    CustomerService customerService;

    @PostMapping("/add")
    public CustomerResponse addCustomer(@RequestBody CustomerRequest customerRequest){
            return customerService.addCustomer(customerRequest);
    }

    @GetMapping("/get/customer-id/{id}")
    public CustomerResponse getCustomer(@PathVariable("id") int customer_id){
        return customerService.getCustomer(customer_id);
    }


    @GetMapping("/get/gender/{gender}")
    public List<CustomerResponse> getAllByGender(@PathVariable("gender")Gender gender){
        return customerService.getAllByGender(gender);
    }


    @GetMapping("/getByGA")
    public List<CustomerResponse> getByGenderAndAge(@RequestParam("gender") Gender gender,
                                                    @RequestParam("age") int age){
        return customerService.getByGenderAndAge(gender,age);
    }

    @GetMapping("/getByGTA")
    public List<CustomerResponse> getByGenderAndAgeGreater(@RequestParam("gender") Gender gender,
                                                    @RequestParam("age") int age){
        return customerService.getByGenderAndAgeGreater(gender,age);
    }


}
