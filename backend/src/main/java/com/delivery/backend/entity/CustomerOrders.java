package com.delivery.backend.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerOrders {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDate orderedAtDate;
    private LocalTime orderedAtTime;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId", referencedColumnName = "id")
    private Customer customer;
}
