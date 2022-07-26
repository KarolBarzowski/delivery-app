package com.delivery.backend.controller;

import com.delivery.backend.entity.Customer;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.delivery.backend.service.implementation.CustomerServiceImpl;

@RestController
@AllArgsConstructor
public class CustomerController {

    private final CustomerServiceImpl customerService;

    @PostMapping("/register")
    public boolean registerUser(@RequestBody Customer customer){
        return customerService.registerCustomer(customer);
    }
}
