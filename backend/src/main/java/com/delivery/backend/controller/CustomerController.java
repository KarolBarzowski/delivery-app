package com.delivery.backend.controller;

import com.delivery.backend.entity.Customer;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.delivery.backend.service.implementation.CustomerServiceImpl;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerServiceImpl customerService;

    @PostMapping("/register")
    public boolean registerUser(@RequestBody Customer customer){
        return customerService.registerCustomer(customer);
    }

    @GetMapping("/test")
    public List<Customer> getCustomers(){
        return customerService.listCustomers();
    }
}
