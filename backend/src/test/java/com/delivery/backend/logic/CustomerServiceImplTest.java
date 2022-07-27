package com.delivery.backend.logic;

import com.delivery.backend.entity.Customer;
import com.delivery.backend.repository.CustomerRepository;
import com.delivery.backend.service.CustomerService;
import com.delivery.backend.service.implementation.CustomerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    CustomerServiceImpl customerService;


    @Mock
    CustomerRepository repository;

    @BeforeEach
    void setUp() {
        customerService = new CustomerServiceImpl(repository);
    }

    @Test
    @DisplayName("Register New Customer")
    void registerCustomer() {
       Customer customer = new Customer(
                1L,
                "testName",
                "testLastName",
                "testEmail",
                15,
                "123456789",
                "biala",
                "12",
                "gdynia",
                "81-164"
        );
       customerService.registerCustomer(customer);

        ArgumentCaptor<Customer> argumentCaptor =
                ArgumentCaptor.forClass(Customer.class);
        Mockito.verify(repository)
                .save(argumentCaptor.capture());
        Customer capturedCustomer = argumentCaptor.getValue();
        assertEquals(capturedCustomer, customer);
    }

    @Test
    @Disabled
    void listCustomers() {
       Customer customer = new Customer(
                1L,
                "testName",
                "testLastName",
                "testEmail",
                15,
                "123456789",
                "biala",
                "12",
                "gdynia",
                "81-164"
        );
       customerService.registerCustomer(customer);

      int listSize =  customerService.listCustomers().size();
      assertEquals(listSize, 1);
    }

    @Test
    void findCustomer() {
    }

    @Test
    void changeCustomerInformations() {
    }
}