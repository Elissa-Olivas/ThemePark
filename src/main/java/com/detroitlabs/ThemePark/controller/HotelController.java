package com.detroitlabs.ThemePark.controller;

import com.detroitlabs.ThemePark.data.HotelRepository;
import com.detroitlabs.ThemePark.model.UserSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@Controller
public class HotelController {
    @Autowired
    HotelRepository hotelRepository;
    @Autowired
    UserSearch userSearch;

    //need to add in the getmapping home page
    @GetMapping("/hotels")
    public String displayHotelMain() {
        return "hotels";
    }

    //site works, button works, however - once button clicked goes back to hotels and not hotel-details
//    hotel-results?location=Denver&checkin=2022-04-26&checkout=2022-04-27&adults=1
    @RequestMapping(value= "/hotel-results/**", method = RequestMethod.GET)
    public String routeToHotelDetailPage(@RequestParam Map<String, String> userInput) {
        System.out.println(userInput.get("location"));
        System.out.println(userInput.get("checkin"));
        System.out.println(userInput.get("checkout"));
        userSearch.setLocation(userInput.get("location"));
        userSearch.setCheckInDate(userInput.get("checkin"));
        userSearch.setCheckOutDate(userInput.get("checkout"));
        return "redirect:hotel-details"; //"redirect:hotel-details" makes the button not work

    }

    @RequestMapping("/hotel-details")
    public String displayHotelDetails(ModelMap modelMap) throws IOException {  //image, name, price, address(streetAddress, locality, postalCode, region)
        hotelRepository.generateHotels(userSearch.getLocation(), userSearch.getCheckInDate(), userSearch.getCheckOutDate());
        modelMap.put("hotels", hotelRepository.getAllHotels());
        return "hotel-details";
    }

}
