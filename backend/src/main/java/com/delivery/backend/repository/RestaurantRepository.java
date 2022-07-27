package com.delivery.backend.repository;

import com.delivery.backend.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    List<Restaurant> findRestaurantsByCity(String city);
}
