package com.delivery.backend.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

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
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
    private String phoneNumber;

    private String streetName;
    private String houseNumber;
    private String city;
    private String postalCode;
}
