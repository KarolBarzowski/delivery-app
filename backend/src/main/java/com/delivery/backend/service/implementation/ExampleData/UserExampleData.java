package com.delivery.backend.service.implementation.ExampleData;

import com.delivery.backend.entity.Customer;

public class UserExampleData {

    public static Customer exampleCustomer(){
        return Customer.builder()
                .firstName("Tom")
                .lastName("Soyer")
                .email("tom@wp.pl")
                .phoneNumber("123455768")
                .age(19)
                .streetName("Biala")
                .postalCode("18-53")
                .city("gdynia")
                .houseNumber("124")
                .build();
    }


    public static Customer exampleCustomerWithoutEmail(){
        return Customer.builder()
                .firstName("Tom")
                .lastName("Soyer")
                .phoneNumber("123455768")
                .age(19)
                .streetName("Biala")
                .postalCode("18-53")
                .city("gdynia")
                .houseNumber("124")
                .build();
    }
}
