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
    private String foodName;
    private Double foodPrice;
    private String foodSize;
    @Enumerated(EnumType.STRING)
    private FoodType foodType;
}
