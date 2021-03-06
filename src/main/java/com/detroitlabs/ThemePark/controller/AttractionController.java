package com.detroitlabs.ThemePark.controller;


import com.detroitlabs.ThemePark.data.AttractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
public class AttractionController {

    @Autowired
    private AttractionRepository attractionRepository;

    @RequestMapping("/attractions")
    public String displayAttractions(ModelMap modelMap) throws IOException {
        modelMap.put("allLands", attractionRepository.landsList());
        return "attractions";
    }

    @RequestMapping("/attraction-details/{name}")
    public String displayRestaurantMenu(@PathVariable String name, ModelMap modelMap) throws IOException {
        String lands = attractionRepository.findByName(name);
        modelMap.put("lands", lands);
        modelMap.put("image", attractionRepository.returnImage(name));
        modelMap.put("allRides", attractionRepository.getRidesByLand(name));
        return "attraction-details";
    }

        @RequestMapping("/allRides")
    public String displayAllRides(ModelMap modelMap) throws IOException {
        modelMap.put("allRides", attractionRepository.ridesList());
        return "allRides";
    }

    @RequestMapping("/allRides/ridesUnder32")
    public String displayRidesOver32Details(ModelMap modelMap) throws IOException {
        modelMap.put("allRides", attractionRepository.findByHeightUnder32(32));
        return "ridesUnder32";
    }

    @RequestMapping("/allRides/ridesOver32")
    public String displayRidesOver40Details(ModelMap modelMap) throws IOException {
        modelMap.put("allRides", attractionRepository.findByHeightOver32(32));
        return "ridesOver32";
    }

}
