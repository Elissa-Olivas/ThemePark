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
        modelMap.put("allRides", attractionRepository.ridesList());
        return "allRides";
    }
//    @GetMapping("/allRides")
//    public String displayAllRides(ModelMap modelMap) throws IOException {
//        modelMap.put("allRides", attractionRepository.ridesList());
//        return "allRides";
//    }
//
//    @RequestMapping(value = "/ride-results/**", method = RequestMethod.GET)
//    public String routeToRideDetailOver30(@RequestParam Map<Integer, Integer> userInput) {
//        userSearch.setMinHeight(userInput.get("ridesOver32"));
//        return "redirect:ridesOver32";
//
//    }
//    @RequestMapping(value = "/ride-results2/**", method = RequestMethod.GET)
//    public String routeToRideDetailOver40(@RequestParam Map<Integer, Integer> userInput) {
//        userSearch.setMinHeight(userInput.get("ridesOver40"));
//        return "redirect:ridesOver40";
//
//    }
//
    @RequestMapping("/allRides/ridesOver32")
    public String displayRidesOver32Details(ModelMap modelMap) throws IOException {
        modelMap.put("allRides", attractionRepository.findByHeightOver32(32));
        return "ridesOver32";
    }

    @RequestMapping("/allRides/ridesOver40")
    public String displayRidesOver40Details(ModelMap modelMap) throws IOException {
        modelMap.put("allRides", attractionRepository.findByHeightOver40(40));
        return "ridesOver40";
    }

//    @RequestMapping("/allRides/{minHeight}")
//    public String displayAllRides(@PathVariable int minHeight, ModelMap modelMap) throws IOException {
//        List<Rides> ridesByHeight = attractionRepository.findByHeight(minHeight);
////        modelMap.put("allRides", attractionRepository.ridesList());
//        modelMap.put("allRides", ridesByHeight);
//        return "ridesOver32";
//    }


}
