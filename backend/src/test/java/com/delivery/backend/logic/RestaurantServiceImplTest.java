package com.delivery.backend.logic;

import com.delivery.backend.entity.Customer;
import com.delivery.backend.entity.Restaurant;
import com.delivery.backend.repository.RestaurantRepository;
import com.delivery.backend.service.implementation.ExampleData.UserExampleData;
import com.delivery.backend.service.implementation.RestaurantServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class RestaurantServiceImplTest {



    RestaurantServiceImpl restaurantService;


    @Mock
    RestaurantRepository repository;


    @BeforeEach
    void setUp() {
        restaurantService = new RestaurantServiceImpl(repository);
    }

    @Test
    void createRestaurant() {
        Restaurant restaurant = new Restaurant();
        restaurantService.createRestaurant(restaurant);

        ArgumentCaptor<Restaurant> argumentCaptor =
                ArgumentCaptor.forClass(Restaurant.class);
        verify(repository)
                .save(argumentCaptor.capture());
        Restaurant captorValue = argumentCaptor.getValue();
        assertEquals(captorValue, restaurant);
    }

    @Test
    void findRestaurantById() {
        restaurantService.findRestaurantById(1L);
        verify(repository).findById(1L);
    }

    @Test
    void showAllRestaurantsInCity() {
        restaurantService.showAllRestaurantsInCity("Gdynia");
        verify(repository).findRestaurantsByCity("Gdynia");
    }
}