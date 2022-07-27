package com.delivery.backend.repository;

import com.delivery.backend.entity.Response.MenuItemForRestaurantResponse;
import com.delivery.backend.entity.Restaurant;
import com.delivery.backend.entity.RestaurantMenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantMenuItemRepository extends JpaRepository<RestaurantMenuItem, Long> {
    List<RestaurantMenuItem> findRestaurantMenuItemsByRestaurant(Restaurant restaurant);
}
