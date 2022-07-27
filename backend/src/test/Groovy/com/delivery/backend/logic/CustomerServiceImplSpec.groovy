package com.delivery.backend.logic

import com.delivery.backend.entity.Customer
import com.delivery.backend.repository.CustomerRepository
import com.delivery.backend.service.implementation.CustomerServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import spock.lang.Specification
@DataJpaTest
class CustomerServiceImplSpec extends Specification {

     CustomerRepository customerRepository = Mock(CustomerRepository.class);
    CustomerServiceImpl service;

    def setup(){
        service = new CustomerServiceImpl(customerRepository)

    }


    /*
     def customer = new Customer(
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
        )
     */
}
