package com.delivery.backend.service.implementation;

import com.delivery.backend.entity.Customer;
import com.delivery.backend.entity.Request.ChangeCustomerAddressInformations;
import com.delivery.backend.repository.CustomerRepository;
import com.delivery.backend.service.CustomerService;
import com.delivery.backend.service.implementation.ExampleData.UserExampleData;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
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
            log.info("Customer {} was created!", customer);
            return checkIfAllIsFilledUp(customer);
        }
        else {
            return false;
        }
    }

    //TODO ZMIANA ADRESU, PRZY BRAKU NOWEJ WARTOŚCI TWORZY SIĘ NULL
    @Override
    @Transactional
    public boolean changeCustomerAddress(Long id, ChangeCustomerAddressInformations customerAddressInformations) {
        Customer customer = customerRepository.findById(id).orElse(null);
        customer.setStreetName(customerAddressInformations.getStreetName());
        customer.setCity(customerAddressInformations.getCity());
        customer.setPostalCode(customerAddressInformations.getPostalCode());
        customer.setHouseNumber(customerAddressInformations.getHouseNumber());
        customerRepository.save(customer);
        return true;
    }


    @PostConstruct
    public void addUser(){
        Customer customer = UserExampleData.exampleCustomer();
        customerRepository.save(customer);
    }

    @Override
    public List<Customer> listCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findCustomer(Long id) {
        return Optional.ofNullable(customerRepository.findById(id).orElse(null));
    }


    private boolean checkIfAllIsFilledUp(Customer customer){
        return checkIfEmailIsNotEmpty(customer.getEmail());
    }

    private boolean checkIfEmailIsNotEmpty(String email){
        Optional.of(email).orElseThrow(NullPointerException::new);
        return true;
    }
}
