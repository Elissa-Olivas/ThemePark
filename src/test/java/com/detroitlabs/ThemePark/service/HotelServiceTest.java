package com.detroitlabs.ThemePark.service;

import com.detroitlabs.ThemePark.model.HotelInfo;
import com.detroitlabs.ThemePark.model.HotelResponse;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class HotelServiceTest {

    @Test
    void fetchDestinationId() throws IOException {
        String actualTerm = HotelService.fetchDestinationId("Detroit").getTerm();

        assertEquals("Detroit", actualTerm);
    }

    @Test
    void VerifyHotelAddress() throws IOException {
        String expectedAddress = "3665 Sandwich Street West";
        int locationId = HotelService.fetchDestinationId("Detroit").getSuggestions().get(0).getEntities().get(0).getDestinationId();
        HotelResponse hotelResponse = HotelService.fetchHotelDetails(locationId, "2020-01-08", "2020-01-15");

        assertEquals(expectedAddress, hotelResponse.getData().getBody().getSearchResults().getResults().get(0).getAddress().getStreetAddress());
    }

    @Test
    void fetchSuggestions() throws IOException {
        HotelInfo hotelInfo = HotelService.fetchDestinationId("Detroit");

        System.out.println(hotelInfo.getSuggestions().get(0).getEntities().get(0).getDestinationId());
    }
}