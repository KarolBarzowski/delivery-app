package com.delivery.backend.service.implementation;

import com.delivery.backend.entity.Customer;
import com.delivery.backend.repository.CustomerRepository;
import com.delivery.backend.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public boolean registerCustomer(Customer customer) {
        Customer.builder()
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .age(customer.getAge())
                .phoneNumber(customer.getPhoneNumber())
                .streetName(customer.getStreetName())
                .houseNumber(customer.getHouseNumber())
                .city(customer.getCity())
                .postalCode(customer.getPostalCode())
                .build();
        if(checkIfAllIsFilledUp(customer)) {
            customerRepository.save(customer);
            return checkIfAllIsFilledUp(customer);
        }
        else {
            return false;
        }
    }

  //  @PostConstruct
    public void addUser(){
        Customer customer = new Customer();
        Customer.builder().firstName("Tomasz").streetName("biala").age(16).build();
        customerRepository.save(customer);
    }

    @Override
    public List<Customer> listCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findCustomer(Long id) {
        return null;
    }

    private boolean checkIfAllIsFilledUp(Customer customer){
        return checkIfEmailIsNotEmpty(customer.getEmail());
    }

    private boolean checkIfEmailIsNotEmpty(String email){
        Optional.of(email).orElseThrow(NullPointerException::new);
        return true;
    }
}
