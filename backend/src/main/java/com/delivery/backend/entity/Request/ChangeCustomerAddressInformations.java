package com.delivery.backend.entity.Request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangeCustomerAddressInformations {
    private String streetName;
    private String houseNumber;
    private String city;
    private String postalCode;
}
