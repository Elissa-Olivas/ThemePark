package com.detroitlabs.ThemePark.controller;



import com.detroitlabs.ThemePark.data.AttractionRepository;
import com.detroitlabs.ThemePark.model.Food;
import com.detroitlabs.ThemePark.model.Lands;
import com.detroitlabs.ThemePark.model.Restaurants;
import com.detroitlabs.ThemePark.model.Rides;
import com.detroitlabs.ThemePark.service.ParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
public class AttractionController {


    @Autowired
    private AttractionRepository attractionRepository;



    @RequestMapping("/attractions")
    public String displayAttractions(ModelMap modelMap) throws IOException {
        modelMap.put("allLands", attractionRepository.landsList());
//        modelMap.put("allRides", attractionRepository.ridesList());
        return "attractions";
    }

    @RequestMapping("/attraction-details/{name}")
    public String displayRestaurantMenu(@PathVariable String name, ModelMap modelMap) throws IOException {
        String lands = attractionRepository.findByName(name);
        modelMap.put("lands", lands);
        modelMap.put("allRides", attractionRepository.getRidesByLand(name));
        return "attraction-details";
    }

    @RequestMapping("/allRides")
    public String displayAllRides(ModelMap modelMap) throws IOException {
//        List<Rides> settingHeight = attractionRepository.setRidesListWithHeight();
//        modelMap.put("allRides", settingHeight);
        modelMap.put("allRides", attractionRepository.ridesList());
        return "allRides";
    }

    @RequestMapping("/allRides/{minHeight}")
    public String displayAllRides(@PathVariable int minHeight, ModelMap modelMap) throws IOException {
        Rides ridesByHeight = attractionRepository.findByHeight(minHeight);
        modelMap.put("allRides", attractionRepository.ridesList());
        return "allRides";
    }


}
