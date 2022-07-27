package com.delivery.backend.service.implementation;

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
                .foodName(item.getFoodName())
                .foodPrice(item.getFoodPrice())
                .foodType(item.getFoodType())
                .foodSize(item.getFoodSize())
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
        item.setFoodName("Pizza margharita");
        item.setFoodSize("42");
        item.setFoodType(FoodType.PIZZA);
        item.setFoodPrice(25.35);
        itemRepository.save(item);
    }

    @Override
    public List<RestaurantMenuItem> getAllItemsFromRestaurant(Long id) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        return itemRepository.findRestaurantMenuItemsByRestaurant(restaurant.get());
    }
}
