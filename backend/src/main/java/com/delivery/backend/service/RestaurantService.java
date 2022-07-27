package com.delivery.backend.service;

import com.delivery.backend.entity.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantService {
    boolean createRestaurant(Restaurant restaurant);
    Optional<Restaurant> findRestaurantById(Long id);
    List<Restaurant> showAllRestaurantsInCity(String city);
}
