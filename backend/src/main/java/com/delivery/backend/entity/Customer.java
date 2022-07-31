package com.delivery.backend.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    //@NotNull
    private String firstName;
    //@NotNull
    private String lastName;
    @Email
    //@NotNull
    private String email;
    private Integer age;
    //@NotNull
    private String phoneNumber;
    //@NotNull
    private String streetName;
    //@NotNull
    private String houseNumber;
    //@NotNull
    private String city;
    //@NotNull
    private String postalCode;
    private boolean enabled;
}
