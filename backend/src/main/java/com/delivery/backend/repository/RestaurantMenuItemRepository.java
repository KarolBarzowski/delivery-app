package com.delivery.backend.repository;

import com.delivery.backend.entity.RestaurantMenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantMenuItemRepository extends JpaRepository<RestaurantMenuItem, Long> {
}
