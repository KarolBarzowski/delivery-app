package com.delivery.backend.service;

import com.delivery.backend.entity.Response.MenuItemForRestaurantResponse;
import com.delivery.backend.entity.RestaurantMenuItem;

import java.util.List;

public interface RestaurantMenuItemService {
    boolean addItemToRestaurant(Long restaurantId, RestaurantMenuItem item);
    List<MenuItemForRestaurantResponse> getAllItemsFromRestaurant(Long id);
}
