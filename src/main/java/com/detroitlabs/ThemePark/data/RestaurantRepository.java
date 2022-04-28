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
            new Food("QuesaBirria", "Braised Beef and Cheese Tacos with Tomatillo Salsa and Consomé. Limit 2 per transaction.", 12),
            new Food("Carne Asada", "Citrus-marinated Grilled Steak Tacos with Crushed Avocados and Fuego Salsa", 12),
            new Food("Al Pastor", "Pineapple-Achiote-marinated Pork with Crushed Avocados and Jalapeño-Garlic Salsa", 12),
            new Food("Frijoles Charros", "Chorizo and Bacon stewed Pinto Beans", 4),
            new Food("Tacos Dorados de Papa", "crispy Potato Tacos topped with Cabbage Slaw, Dairy-free Crema and Tomatillo Salsa", 10));

    public static final List<Food> restaurantTwoFood = Arrays.asList(
            new Food("Hawaiian-style Pizza - Slice", "topped with Spiced Pizza Sauce, Pineapple, Red Bell Pepper, Canadian Bacon, Mozzarella & Parmesan Cheese Blend", 10),
            new Food("Astro Antipasto Salad", "Single Patty: Ketchup, Pickle, Lettuce, Tomato", 11),
            new Food("Snacky Mac", "Light Teal Macaron Shell filled with Blackberry Cream Cheese Frosting and Passion Fruit Curd", 5),
            new Food("Kashyykian Spicy Meat Pie – Slice", "Italian Sausage, Classic & Crispy Cupped Pepperoni, Mozzarella and Pepper Jack, Red Pepper Flakes and Fresno Chilis, atop spicy Blush Sauce", 9),
            new Food("Kid-Size Cheese Pizza", "served with Carrots, a Cuties® Mandarin, and choice of Small Lowfat Milk or Small DASANI® Water", 7));

    public static final List<Food> restaurantThreeFood = Arrays.asList(
            new Food("Olaf's Snowcones", "Our famous DolWhip. Flavors: Cherry, Pineapple, Cheesecake", 6),
            new Food("It's Snow-Capped Lemon!", "Nondairy Lemon Soft-serve topped with White Chocolate", 6),
            new Food("It's Chile-Lime Mango!", "Nondairy Mango Soft-serve with Chamoy, Chile-Lime Seasoning, and Diced Mango", 6),
            new Food("Pixar Pier Frosty Parfait with Blue Curaçao", "Nondairy Lemon Soft-serve with Blue Raspberry swirl and a splash of Blue Curaçao", 14));

    public static final List<Food> restaurantFourFood = Arrays.asList(
            new Food("Mickey Waffles", "Chocolate Chip waffles with Cherry compote", 10),
            new Food("Biscuits and Gravy", "2 Giant Biscuits with Sausage Gravy", 8),
            new Food("Breakfast Plate", "2 Eggs, Bacon or Sausage, Hashbrowns", 12));

    public static final List<Food> restaurantFiveFood = Arrays.asList(
            new Food("Chicken Gumbo", "Chicken, Andouille Sausage, Tomatoes, Okra, Jasmine Rice, Green Onions", 7),
            new Food("Jambalaya", "Jumbo Shrimp, Andouille Sausage, Chicken, Tasso Ham, Creole Rice, Spiced Tomato Jus", 36),
            new Food("Gumbo Fries", "Cajun-spiced fries, Chicken Gumbo, Cajun Cheese", 10),
            new Food("Chicken & Kale Rice", "Roasted Spanish Vegetables, House Herb Mixture and Natural Jus", 35),
            new Food("Cajun Cauliflower", "Romanesco Sauce, Mushroom Chips, Cajun Cheddar, Wilted Greens, and Shishito Chimichurri", 29),
            new Food("Vanilla-Bourbon Crème Brûlée", "Macerated Fresh Berries and Pecan Cookie", 9));

    public static final List<Food> restaurantSixFood = Arrays.asList(
            new Food("DOLE Whip® Float", "DOLE® Pineapple Juice topped with DOLE Whip® Pineapple Soft Serve", 7),
            new Food("Loco Moco Bao", "Spiced Ham, Egg, Ground Beef, Mushroom Gravy", 6),
            new Food("Lime Chicken Bao", "Butternut Squash, fresh Herbs", 6),
            new Food("Chips", "Falors: Original, Salt and Vinegar, Sirracha Sunrise, Maui Onion, Baked Sour Cream and Onion, Plantain", 4));

    public static final List<Restaurants> ALL_RESTAURANTS = Arrays.asList(
            new Restaurants("Cocina Cucamonga Mexican Grill", "cocina", "11am-7pm", "Fantasyland", restaurantOneFood),
            new Restaurants("Pizza Planet", "pizzaplanet", "10:30am-7pm", "Tomorrowland", restaurantTwoFood),
            new Restaurants("Frosted Treats", "frostedtreats", "11:00am-7:00pm", "Fantasyland", restaurantThreeFood),
            new Restaurants("Plaza Inn", "plazainn", "08:00am-12:pm", "Main Street, U.S.A", restaurantFourFood),
            new Restaurants("Blue Bayou Restaurant", "bayou", "11:00am-10:00pm", "New Orleans Square", restaurantFiveFood),
            new Restaurants("The Tropical Hideaway", "tropical", "08:00am-12:00am", "Adventureland", restaurantSixFood));

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
