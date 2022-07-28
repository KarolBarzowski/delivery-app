package com.delivery.backend.service;

import com.delivery.backend.entity.Customer;
import com.delivery.backend.entity.Request.ChangeCustomerAddressInformations;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface CustomerService {
    boolean registerCustomer(Customer customer);



    @Transactional
    boolean changeCustomerAddress(Long id, ChangeCustomerAddressInformations customerAddressInformations);

    List<Customer> listCustomers();
    Optional<Customer> findCustomer(Long id);

}
