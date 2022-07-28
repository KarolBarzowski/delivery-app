package com.delivery.backend.controller;


import com.delivery.backend.entity.Response.MenuItemForRestaurantResponse;
import com.delivery.backend.entity.RestaurantMenuItem;
import com.delivery.backend.service.implementation.RestaurantMenuItemServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
@AllArgsConstructor
public class RestaurantMenuItemController {
    private final RestaurantMenuItemServiceImpl itemService;


    @GetMapping("/getMenu/{restaurantId}")
    public List<MenuItemForRestaurantResponse> getRestaurantMenuForRestaurant(@PathVariable("restaurantId")Long restaurantId){
        return itemService.getAllItemsFromRestaurant(restaurantId);
    }

  //  @PostMapping("/addMenuItem/{restaurantId}")
    public boolean addItemsToRestaurant(@PathVariable("restaurantId")Long restaurantId, @RequestBody RestaurantMenuItem item){
        return itemService.addItemToRestaurant(restaurantId, item);
    }
}
