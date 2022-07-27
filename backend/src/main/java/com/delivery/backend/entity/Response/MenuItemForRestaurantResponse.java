package com.delivery.backend.entity.Response;

import com.delivery.backend.entity.enums.FoodType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
public class MenuItemForRestaurantResponse {
    private Long id;
    private String foodName;
    @Enumerated(EnumType.STRING)
    private FoodType foodType;
    private Double foodPrice;
    private String foodSize;

}
