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
            new Food("Tamale Plate", "Tamale of your choice: Beef, Cheese", 12));

    public static final List<Food> restaurantTwoFood = Arrays.asList(
            new Food("Pizza", "Personal Pizza: Cheese, Pepperoni, Meat-Lovers, Veggie", 10),
            new Food("Burger", "Single Patty: Ketchup, Pickle, Lettuce, Tomato", 8),
            new Food("Double-Burger", "Double Patty: Ketchup, Pickle, Lettuce, Tomato", 10));

    public static final List<Food> restaurantThreeFood = Arrays.asList(
            new Food("Olaf's Snowcones", "Our famous DolWhip. Flavors: Cherry, Pineapple, Cheesecake", 6));

    public static final List<Food> restaurantFourFood = Arrays.asList(
            new Food("Mickey Waffles", "Chocolate Chip waffles with Cherry compote", 10),
            new Food("Biscuits and Gravy", "2 Giant Biscuits with Sausage Gravy", 8),
            new Food("Breakfast Plate", "2 Eggs, Bacon or Sausage, Hashbrowns", 12));

    public static final List<Restaurants> ALL_RESTAURANTS = Arrays.asList(
            new Restaurants("Cocina Cucamonga Mexican Grill", "11am-7pm", "Fantasyland", restaurantOneFood),
            new Restaurants("Pizza Planet", "10:30am-7pm", "Tomorrowland", restaurantTwoFood),
            new Restaurants("Frosted Treats", "11:00am-7:00pm", "Fantasyland", restaurantThreeFood),
            new Restaurants("Plaza Inn", "08:00am-12:pm", "Main Street, U.S.A", restaurantFourFood));

    public static List<Food> getRestaurantOneFood() {
        return restaurantOneFood;
    }

    public static List<Food> getRestaurantTwoFood() {
        return restaurantTwoFood;
    }

    public static List<Food> getRestaurantThreeFood() {
        return restaurantThreeFood;
    }

    public static List<Food> getRestaurantFourFood() {
        return restaurantFourFood;
    }

    public static List<Restaurants> getAllRestaurants() {
        return ALL_RESTAURANTS;
    }


    public Restaurants searchRestaurantByName(String restaurantName) {
        for(Restaurants restaurants: ALL_RESTAURANTS) {
            if(restaurants.getRestaurantName().contains(restaurantName)){
                return restaurants;
            }
        }
        return null;
    }

    public Restaurants getListOfFood() {
        for (Restaurants restaurants: ALL_RESTAURANTS) {
                System.out.println(restaurants.getListOfFood().get(0).getName());
            return restaurants;
            }
        return null;
    }

}
