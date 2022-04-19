package com.detroitlabs.ThemePark.data;

import com.detroitlabs.ThemePark.model.Food;
import com.detroitlabs.ThemePark.model.Restaurants;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class RestaurantRepository {

    public static final List<Food> restaurantOneFood = Arrays.asList(
            new Food("Tacos", "3 tacos of your choice: Chicken, Beef, Fish", 10),
            new Food("Tamale Plate", "Tamale of yoour choice: Beef, Cheese", 12));

    public static final List<Food> restaurantTwoFood = Arrays.asList(
            new Food("Pizza", "Personal Pizza: Cheese, Pepperoni, Meat-Lovers, Veggie", 10),
            new Food("Burger", "Single Patty: Ketchup, Pickle, Lettuce, Tomato", 8),
            new Food("Double-Burger", "Double Patty: Ketchup, Pickle, Lettuce, Tomato", 10));

    public static final List<Restaurants> ALL_RESTAURANTS = Arrays.asList(
            new Restaurants("Mexican Food", "11am-7pm", restaurantOneFood),
            new Restaurants("American Food", "10:30am-7pm", restaurantTwoFood));

    public static List<Food> getRestaurantOneFood() {
        return restaurantOneFood;
    }

    public static List<Food> getRestaurantTwoFood() {
        return restaurantTwoFood;
    }

    public static List<Restaurants> getAllRestaurants() {
        return ALL_RESTAURANTS;
    }


    public Restaurants searchRestaurantByName(String name) {
        for(Restaurants restaurants: ALL_RESTAURANTS) {
            if(restaurants.getRestaurantName().equals(name)){
                return restaurants;
            }
        }
        return null;
    }




}
