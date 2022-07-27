package com.delivery.backend.entity;

import com.delivery.backend.entity.enums.FoodType;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RestaurantMenuItem {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "restaurantId", nullable = false)
    private Restaurant restaurant;
    private String name;
    private Double price;
    private String size;
    @Enumerated(EnumType.STRING)
    private FoodType type;
}
