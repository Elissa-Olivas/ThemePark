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
        modelMap.put("restaurant", restaurants);
        modelMap.put("restaurantFood", restaurantRepository.getFoodByRestaurant(restaurantName));
        return "menu";
    }
}
