package com.delivery.backend.controller;

import com.delivery.backend.entity.Restaurant;
import com.delivery.backend.service.implementation.RestaurantServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/restaurant")
public class RestaurantController {
    private final RestaurantServiceImpl restaurantService;

    @PostMapping("/createRestaurant")
    public boolean createRestaurant(@RequestBody Restaurant restaurant){
        return restaurantService.createRestaurant(restaurant);
    }

    @GetMapping("/getRestaurantById/{id}")
    public Optional<Restaurant> getRestaurantById(@PathVariable("id")Long id){
        return restaurantService.findRestaurantById(id);
    }

    @GetMapping("/getRestaurantsByCity/{city}")
    public List<Restaurant> getRestaurantsByCity(@PathVariable("city") String city){
        return restaurantService.showAllRestaurantsInCity(city);
    }
}
