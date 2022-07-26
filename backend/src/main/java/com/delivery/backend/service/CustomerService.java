package com.delivery.backend.service;

import com.delivery.backend.entity.Customer;

import java.util.List;

public interface CustomerService {
    boolean registerCustomer(Customer customer);
    List<Customer> listCustomers();
    Customer findCustomer(Long id);
}
