package com.detroitlabs.ThemePark.controller;


import com.detroitlabs.ThemePark.data.RestaurantRepository;
import com.detroitlabs.ThemePark.model.Food;
import com.detroitlabs.ThemePark.model.Restaurants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class RestaurantController {

    @Autowired
    RestaurantRepository restaurantRepository;

    @RequestMapping("/restaurants")
    public String displayRestaurants(ModelMap modelMap) {
        modelMap.put("restaurant", restaurantRepository.getAllRestaurants());
        return "restaurants";
    }

    @RequestMapping("/menu/{restaurantName}")
    public String displayRestaurantMenu(@PathVariable String restaurantName, ModelMap modelMap) {
        Restaurants restaurants = restaurantRepository.searchRestaurantByName(restaurantName);
        List<Food> restaurantFood = restaurantRepository.getAllRestaurants().get(2).getListOfFood();
        modelMap.put("restaurant", restaurants);
        modelMap.put("restaurantFood", restaurantFood);
        return "menu";
    }
//    @RequestMapping("/restaurants/{restaurantName}")
//    public String displayRestaurantDetails(@RequestParam String restaurantName, ModelMap modelMap) {
//        modelMap.put("restaurant", restaurantRepository.searchRestaurantByName(restaurantName));
////        modelMap.put("restaurantOneFood", restaurantRepository.getRestaurantOneFood());
////        modelMap.put("restaurantOTwoFood", restaurantRepository.getRestaurantTwoFood());
//        return "redirect:/restaurant-details";
//    }
}
