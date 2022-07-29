package com.delivery.backend.logic;

import com.delivery.backend.entity.Customer;
import com.delivery.backend.repository.CustomerRepository;
import com.delivery.backend.service.implementation.CustomerServiceImpl;
import com.delivery.backend.service.implementation.ExampleData.UserExampleData;
import com.delivery.backend.service.implementation.exception.CustomerIsUnder18YO;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
        Customer customer = UserExampleData.exampleCustomer();
       customerService.registerCustomer(customer);

        ArgumentCaptor<Customer> argumentCaptor =
                ArgumentCaptor.forClass(Customer.class);
        Mockito.verify(repository)
                .save(argumentCaptor.capture());
        Customer capturedCustomer = argumentCaptor.getValue();
        assertEquals(capturedCustomer, customer);
    }

    @Test
    @DisplayName("Will throw NullPointerException On New Customer")
    void willThrowNullPointerExceptionOnRegister(){
        Customer customer = UserExampleData.exampleCustomerWithoutEmail();
        assertThatThrownBy(() -> customerService.registerCustomer(customer))
                .isInstanceOf(NullPointerException.class);

    }

    @Test
    @DisplayName("Will throw CustomerIsUnder18YO On New Customer")
    void willThrowCustomerIsUnder18YOOnRegister(){
        Customer customer = UserExampleData.exampleCustomerUnder18YO();
        assertThatThrownBy(() -> customerService.registerCustomer(customer))
                .isInstanceOf(CustomerIsUnder18YO.class);

    }

    @Test
    void listCustomers() {
        customerService.listCustomers();
        verify(repository).findAll();
    }

    @Test
    void findCustomer() {
        customerService.findCustomer(1L);
        verify(repository).findById(1L);
    }

    @Test
    void changeCustomerInformations() {
    }
}