package com.detroitlabs.ThemePark.data;

import com.detroitlabs.ThemePark.model.Restaurants;
import com.detroitlabs.ThemePark.model.Tickets;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantRepositoryTest {

    @Test
    void getRestaurantOneFood() {
    }

    @Test
    void getRestaurantTwoFood() {
    }

    @Test
    void getRestaurantThreeFood() {
    }

    @Test
    void getRestaurantFourFood() {
    }

    @Test
    void getAllRestaurants() {
    }

    @Test
    void searchRestaurantByName() {
    }

    @Test
    void getListOfFood() {
        RestaurantRepository restaurantRepository = new RestaurantRepository();
        List<Restaurants> allRestaurants = restaurantRepository.getAllRestaurants();
        Restaurants results = restaurantRepository.getListOfFood();
        assertEquals(allRestaurants.get(1).getListOfFood().get(0).getName(), "Pizza");
    }
}