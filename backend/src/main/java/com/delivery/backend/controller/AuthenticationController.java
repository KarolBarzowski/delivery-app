package com.delivery.backend.controller;

import com.delivery.backend.entity.Customer;
import com.delivery.backend.service.implementation.CustomerServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
@CrossOrigin("http://localhost:3000")
public class AuthenticationController {

    private final CustomerServiceImpl customerService;


    @PostMapping("/register")
    public boolean registerUser(@RequestBody Customer customer){
        return customerService.registerCustomer(customer);
    }

    @GetMapping("/activation/{UUID}")
    public boolean activateAccount(@PathVariable("UUID")String UUID){
        customerService.enableCustomerAccount(UUID);
        return true;
    }

}
