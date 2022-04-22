package com.detroitlabs.ThemePark.data;

import com.detroitlabs.ThemePark.model.Food;
import com.detroitlabs.ThemePark.model.Lands;
import com.detroitlabs.ThemePark.model.Restaurants;
import com.detroitlabs.ThemePark.model.Rides;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class RestaurantRepository {

    private List<Food> foodByRestaurant;

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

    public static final List<Food> restaurantFiveFood = Arrays.asList(
            new Food("Chicken Gumbo", "Chicken, Andouille Sausage, Tomatoes, Okra, Jasmine Rice, Green Onions", 7),
            new Food("Jambalaya", "Jumbo Shrimp, Andouille Sausage, Chicken, Tasso Ham, Creole Rice, Spiced Tomato Jus", 36),
            new Food("Cajun Cauliflower", "Romanesco Sauce, Mushroom Chips, Cajun Cheddar, Wilted Greens, and Shishito Chimichurri", 29),
            new Food("Vanilla-Bourbon Crème Brûlée", "Macerated Fresh Berries and Pecan Cookie", 9));

    public static final List<Food> restaurantSixFood = Arrays.asList(
            new Food("DOLE Whip® Float", "DOLE® Pineapple Juice topped with DOLE Whip® Pineapple Soft Serve", 7),
            new Food("Loco Moco Bao", "Spiced Ham, Egg, Ground Beef, Mushroom Gravy", 6),
            new Food("Lime Chicken Bao", "Butternut Squash, fresh Herbs", 6),
            new Food("Chips", "Falors: Original, Salt and Vinegar, Sirracha Sunrise, Maui Onion, Baked Sour Cream and Onion, Plantain, Vegan White Cheddar", 4));

    public static final List<Restaurants> ALL_RESTAURANTS = Arrays.asList(
            new Restaurants("Cocina Cucamonga Mexican Grill", "11am-7pm", "Fantasyland", restaurantOneFood),
            new Restaurants("Pizza Planet", "10:30am-7pm", "Tomorrowland", restaurantTwoFood),
            new Restaurants("Frosted Treats", "11:00am-7:00pm", "Fantasyland", restaurantThreeFood),
            new Restaurants("Plaza Inn", "08:00am-12:pm", "Main Street, U.S.A", restaurantFourFood),
            new Restaurants("Blue Bayou Restaurant", "11:00am-10:00pm", "New Orleans Square", restaurantFiveFood),
            new Restaurants("The Tropical Hideaway", "08:00am-12:00am", "Adventureland", restaurantSixFood));

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

    public static List<Food> getRestaurantFiveFood() {
        return restaurantFiveFood;
    }

    public static List<Food> getRestaurantSixFood() {
        return restaurantSixFood;
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

    //gets list of food by restaurant
    public List<Food> getFoodByRestaurant(String restaurantName) {
        foodByRestaurant = new ArrayList<>();
        for (Restaurants restaurants: ALL_RESTAURANTS) {
            if(restaurants.getRestaurantName().equals(restaurantName)) {
                foodByRestaurant = restaurants.getListOfFood();
            }
        }
        return foodByRestaurant;
    }

}
