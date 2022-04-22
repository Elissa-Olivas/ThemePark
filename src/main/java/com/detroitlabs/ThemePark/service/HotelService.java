package com.detroitlabs.ThemePark.service;

import com.detroitlabs.ThemePark.model.HotelInfo;
import com.detroitlabs.ThemePark.model.HotelResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Component
public class HotelService {

    public static HotelInfo fetchDestinationId(String locationID) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-RapidAPI-Host", "hotels4.p.rapidapi.com");
        httpHeaders.add("X-RapidAPI-Key", "374ccf4573msh51eac29f92de632p16fbc8jsna5fd4e1fb025");
        HttpEntity httpEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity responseEntity = restTemplate.exchange("https://hotels4.p.rapidapi.com/locations/v2/search?query=" + locationID, HttpMethod.GET, httpEntity, String.class);

        return new ObjectMapper().readValue(responseEntity.getBody().toString(), HotelInfo.class);
    }

    public static HotelResponse fetchHotelDetails(int destinationID, String checkIn, String checkout) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-RapidAPI-Host", "hotels4.p.rapidapi.com");
        httpHeaders.add("X-RapidAPI-Key", "374ccf4573msh51eac29f92de632p16fbc8jsna5fd4e1fb025");
        HttpEntity httpEntity = new HttpEntity<>(httpHeaders);


        ResponseEntity responseEntity = restTemplate.exchange("https://hotels4.p.rapidapi.com/properties/list?destinationId="
                        + destinationID + "&pageNumber=1&pageSize=10&checkIn="
                        + checkIn + "&checkOut="
                        + checkout + "&adults1=1&sortOrder=PRICE",
                HttpMethod.GET, httpEntity, String.class);

        return new ObjectMapper().readValue(responseEntity.getBody().toString(), HotelResponse.class);

    }
}
