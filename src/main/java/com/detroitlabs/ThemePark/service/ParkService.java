package com.detroitlabs.ThemePark.service;


import com.detroitlabs.ThemePark.model.Lands;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ParkService {

    public static Lands fetchAttractionData() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://queue-times.com/en-US/parks/16/queue_times.json", Lands.class);
    }
}
