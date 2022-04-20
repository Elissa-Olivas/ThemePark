package com.detroitlabs.ThemePark.controller;



import com.detroitlabs.ThemePark.data.AttractionRepository;
import com.detroitlabs.ThemePark.model.Lands;
import com.detroitlabs.ThemePark.model.Rides;
import com.detroitlabs.ThemePark.service.ParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
        return "attractions";
    }
}
