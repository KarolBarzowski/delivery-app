package com.delivery.backend.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Restaurant {
    @Id
    @GeneratedValue
    private Long id;
    private String restaurantName;
    private String street;
    private String houseNumber;
    private String postalCode;
    private String city;

}
