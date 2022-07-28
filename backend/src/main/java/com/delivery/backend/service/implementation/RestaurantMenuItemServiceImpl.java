package com.delivery.backend.service.implementation;

import com.delivery.backend.entity.Response.MenuItemForRestaurantResponse;
import com.delivery.backend.entity.Restaurant;
import com.delivery.backend.entity.RestaurantMenuItem;
import com.delivery.backend.entity.enums.FoodType;
import com.delivery.backend.repository.RestaurantMenuItemRepository;
import com.delivery.backend.repository.RestaurantRepository;
import com.delivery.backend.service.RestaurantMenuItemService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
@Slf4j
public class RestaurantMenuItemServiceImpl implements RestaurantMenuItemService {
    private final RestaurantMenuItemRepository itemRepository;
    private final RestaurantRepository restaurantRepository;

    //TODO DO NAPRAWY:  Pole nie może być NULL"RESTAURANT_ID"
    //NULL not allowed for column "RESTAURANT_ID"; SQL statement:
    //DODANIE JSONA Z RESTAURACJĄ POZWALA PRZESŁAĆ REQUEST
    @Override
    @Transactional
    public boolean addItemToRestaurant(Long restaurantId, RestaurantMenuItem item) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);
        RestaurantMenuItem.builder()
                .name(item.getName())
                .price(item.getPrice())
                .type(item.getType())
                .size(item.getSize())
                .restaurant(restaurant.get())
                .build();
        if(checkIfAllIsFilledUp(item)) {
            itemRepository.save(item);
            log.info("Menu Item {} was created", item);
            return true;
        }
        else {
            log.warn("Not all fields are filled up!");
            return false;
        }
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
        for (RestaurantMenuItem item : menuItem) {
            itemResponse.setId(item.getId());
            itemResponse.setFoodName(item.getName());
            itemResponse.setFoodPrice(item.getPrice());
            itemResponse.setFoodType(item.getType());
        }
        return List.of(itemResponse);
    }


    private boolean checkIfAllIsFilledUp(RestaurantMenuItem item){
        return     checkIfFoodNameIsFilledUp(item.getName())
                || checkIfFoodPriceIsFilledUp(item.getPrice());
    }

    private boolean checkIfFoodPriceIsFilledUp(double price){
        Optional.ofNullable(price).orElseThrow(NullPointerException::new);
        return true;
    }
    private boolean checkIfFoodNameIsFilledUp(String name){
        Optional.ofNullable(name).orElseThrow(NullPointerException::new);
        return true;
    }
}
