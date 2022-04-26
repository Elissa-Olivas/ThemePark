package com.detroitlabs.ThemePark.data;

import com.detroitlabs.ThemePark.model.Hotel;
import com.detroitlabs.ThemePark.model.HotelResponse;
import com.detroitlabs.ThemePark.service.HotelService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class HotelRepositoryTest {

//    private Hotel testHotel;

//    @BeforeEach
//    void newHotel () {
//        testHotel = new Hotel("Ritz", "5 star", "123 Ritz st", "Denver", "US", "80910", 12.123, 12.456, "$65", "image.jpeg");
//    }

    @Test
    void getData() throws IOException {
        String expectedAddress = "3665 Sandwich Street West";
        int locationId = HotelService.fetchDestinationId("Detroit").getSuggestions().get(0).getEntities().get(0).getDestinationId();
        HotelResponse hotelResponse = HotelService.fetchHotelDetails(locationId, "2020-01-08", "2020-01-15");

        assertEquals(expectedAddress, hotelResponse.getData().getBody().getSearchResults().getResults().get(0).getAddress().getStreetAddress());
    }

    @Test
    void setData() {
    }

    @Test
    void getAllHotels() {
    }

    @Test
    void setAllHotels() {
    }

    @Test
    void generateHotels() throws IOException {
        HotelRepository hotelRepository = new HotelRepository();
        hotelRepository.generateHotels("Detroit", "2022-05-08", "2022-05-10");
        for (Hotel hotel: hotelRepository.getAllHotels()) {
            System.out.println(hotel.getName());
        }
    }
}