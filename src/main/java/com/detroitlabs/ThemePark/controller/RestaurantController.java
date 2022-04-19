package com.detroitlabs.ThemePark.controller;


import com.detroitlabs.ThemePark.data.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RestaurantController {

    @Autowired
    RestaurantRepository restaurantRepository;

    @RequestMapping("/restaurants")
    public String displayRestaurants(ModelMap modelMap) {
        modelMap.put("restaurant", restaurantRepository.getAllRestaurants());
        return "restaurants";
    }

//    @RequestMapping("/restaurants/{restaurantName}")
//    public String displayRestaurants(@RequestParam String restaurantName, ModelMap modelMap) {
//        modelMap.put("restaurant", restaurantRepository.searchRestaurantByName(restaurantName));
////        modelMap.put("restaurantOneFood", restaurantRepository.getRestaurantOneFood());
////        modelMap.put("restaurantOTwoFood", restaurantRepository.getRestaurantTwoFood());
//        return "restaurant-details";
//    }
}
