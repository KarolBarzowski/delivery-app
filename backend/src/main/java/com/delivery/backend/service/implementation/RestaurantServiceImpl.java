package com.delivery.backend.service.implementation;

import com.delivery.backend.entity.Restaurant;
import com.delivery.backend.repository.RestaurantRepository;
import com.delivery.backend.service.RestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository repository;

    @Override
    public boolean createRestaurant(Restaurant restaurant) {
        Restaurant.builder()
                .restaurantName(restaurant.getRestaurantName())
                .street(restaurant.getStreet())
                .houseNumber(restaurant.getHouseNumber())
                .postalCode(restaurant.getPostalCode())
                .city(restaurant.getCity())
                .menu(null)
                .build();
        repository.save(restaurant);
        return true;
    }

    @Override
    public Optional<Restaurant> findRestaurantById(Long id) {
        return Optional.ofNullable(repository.findById(id).orElse(null));
    }

    @Override
    public List<Restaurant> showAllRestaurantsInCity(String city) {
        return repository.findRestaurantsByCity(city);
    }
}
