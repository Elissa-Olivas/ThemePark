package com.detroitlabs.ThemePark.data;

import com.detroitlabs.ThemePark.model.Food;
import com.detroitlabs.ThemePark.model.Restaurants;
import com.detroitlabs.ThemePark.model.Tickets;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantRepositoryTest {

    @Test
    void getItem_From_getRestaurantOneFood() {
        RestaurantRepository restaurantRepository = new RestaurantRepository();
        List<Restaurants> allRestaurants = restaurantRepository.getAllRestaurants();
        Restaurants results = restaurantRepository.getListOfFood();
        assertEquals(allRestaurants.get(0).getListOfFood().get(1).getName(), "Tamale Plate");
    }

    @Test
    void getItem_From_getRestaurantTwoFood() {
        RestaurantRepository restaurantRepository = new RestaurantRepository();
        List<Restaurants> allRestaurants = restaurantRepository.getAllRestaurants();
        Restaurants results = restaurantRepository.getListOfFood();
        assertEquals(allRestaurants.get(1).getListOfFood().get(1).getName(), "Burger");
    }

    @Test
    void getItem_From_getRestaurantThreeFood() {
        RestaurantRepository restaurantRepository = new RestaurantRepository();
        List<Restaurants> allRestaurants = restaurantRepository.getAllRestaurants();
        Restaurants results = restaurantRepository.getListOfFood();
        assertEquals(allRestaurants.get(2).getListOfFood().get(0).getName(), "Olaf's Snowcones");
    }

    @Test
    void getItem_From_getRestaurantFourFood() {
        RestaurantRepository restaurantRepository = new RestaurantRepository();
        List<Restaurants> allRestaurants = restaurantRepository.getAllRestaurants();
        Restaurants results = restaurantRepository.getListOfFood();
        assertEquals(allRestaurants.get(3).getListOfFood().get(0).getName(), "Mickey Waffles");
    }

    @Test
    void getA_Restaurant_from_getAllRestaurants() {
        RestaurantRepository restaurantRepository = new RestaurantRepository();
        List<Restaurants> allRestaurants = restaurantRepository.getAllRestaurants();
        assertEquals(allRestaurants.get(1).getRestaurantName(), "Pizza Planet");
    }

    @Test
    void get_Restaurant_using_searchRestaurantByName() {
        RestaurantRepository restaurantRepository = new RestaurantRepository();
        Restaurants results = restaurantRepository.searchRestaurantByName("Blue Bayou Restaurant");
        assertEquals(results.getRestaurantName(), "Blue Bayou Restaurant");
    }

    @Test
    void getItem_From_getListOfFood() {
        RestaurantRepository restaurantRepository = new RestaurantRepository();
        List<Restaurants> allRestaurants = restaurantRepository.getAllRestaurants();
        Restaurants results = restaurantRepository.getListOfFood();
        assertEquals(allRestaurants.get(1).getListOfFood().get(0).getName(), "Pizza");
    }

//    @Test (not sure how to test for null)
//    void testing_Null_From_getListOfFood() {
//        RestaurantRepository restaurantRepository = new RestaurantRepository();
//        List<Restaurants> allRestaurants = restaurantRepository.getAllRestaurants();
//        Restaurants results = restaurantRepository.getListOfFood();
//        assertEquals(results, null);
//    }

    @Test
    void getItem_From_getFoodByRestaurant() {
        RestaurantRepository restaurantRepository = new RestaurantRepository();
        List<Food> results = restaurantRepository.getFoodByRestaurant("Blue Bayou Restaurant");
        assertEquals(results.get(0).getName(), "Chicken Gumbo");
    }
}