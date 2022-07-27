package com.delivery.backend.service.implementation;

import com.delivery.backend.entity.Response.MenuItemForRestaurantResponse;
import com.delivery.backend.entity.Restaurant;
import com.delivery.backend.entity.RestaurantMenuItem;
import com.delivery.backend.entity.enums.FoodType;
import com.delivery.backend.repository.RestaurantMenuItemRepository;
import com.delivery.backend.repository.RestaurantRepository;
import com.delivery.backend.service.RestaurantMenuItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class RestaurantMenuItemServiceImpl implements RestaurantMenuItemService {
    private final RestaurantMenuItemRepository itemRepository;
    private final RestaurantRepository restaurantRepository;

    @Override
    public boolean addItemToRestaurant(Long restaurantId, RestaurantMenuItem item) {
        Optional<Restaurant> restaurant = Optional.ofNullable(restaurantRepository.findById(restaurantId).orElse(null));
        RestaurantMenuItem.builder()
                .name(item.getName())
                .price(item.getPrice())
                .type(item.getType())
                .size(item.getSize())
                .restaurant(restaurant.get())
                .build();
        itemRepository.save(item);
        return true;
    }

    @PostConstruct
    private void addFood(){
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantName("Da Grasso");
        restaurantRepository.save(restaurant);
        RestaurantMenuItem item = new RestaurantMenuItem();
        item.setRestaurant(restaurant);
        item.setName("Pizza margharita");
        item.setSize("42");
        item.setType(FoodType.PIZZA);
        item.setPrice(25.35);
        itemRepository.save(item);
    }

    @Override
    public List<MenuItemForRestaurantResponse> getAllItemsFromRestaurant(Long id) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        List<RestaurantMenuItem> menuItem = itemRepository.findRestaurantMenuItemsByRestaurant(restaurant.get());
        MenuItemForRestaurantResponse itemResponse = new MenuItemForRestaurantResponse();
        for(int i = 0; i<menuItem.size();i++) {
            itemResponse.setId(menuItem.get(i).getId());
            itemResponse.setFoodName(menuItem.get(i).getName());
            itemResponse.setFoodPrice(menuItem.get(i).getPrice());
            itemResponse.setFoodType(menuItem.get(i).getType());
        }
        return List.of(itemResponse);
    }
}
