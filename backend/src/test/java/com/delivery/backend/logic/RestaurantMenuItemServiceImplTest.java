package com.delivery.backend.logic;

import com.delivery.backend.entity.Restaurant;
import com.delivery.backend.repository.RestaurantMenuItemRepository;
import com.delivery.backend.repository.RestaurantRepository;
import com.delivery.backend.service.implementation.RestaurantMenuItemServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class RestaurantMenuItemServiceImplTest {


    RestaurantMenuItemServiceImpl itemService;


    @Mock
    RestaurantMenuItemRepository repository;

    @Mock
    RestaurantRepository restaurantRepository;

    @BeforeEach
    void setUp() {
        itemService = new RestaurantMenuItemServiceImpl(repository, restaurantRepository);
    }
    @Test
    void addItemToRestaurant() {
    }

    @Test
    void getAllItemsFromRestaurant() {
        Restaurant restaurant = new Restaurant();
        itemService.getAllItemsFromRestaurant(restaurant.getId());
        verify(repository).findRestaurantMenuItemsByRestaurant(restaurant);

    }
}