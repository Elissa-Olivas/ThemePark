package com.detroitlabs.ThemePark.controller;


import com.detroitlabs.ThemePark.data.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RestaurantController {

    @Autowired
    RestaurantRepository restaurantRepository;
}
