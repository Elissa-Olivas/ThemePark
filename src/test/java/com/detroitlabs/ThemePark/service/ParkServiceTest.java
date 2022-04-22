package com.detroitlabs.ThemePark.service;

import com.detroitlabs.ThemePark.data.AttractionRepository;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


class ParkServiceTest {


    @Test
    void fetchAttractionData_LandName() throws IOException {
        AttractionRepository attractionRepository = ParkService.fetchAttractionData();
        String results = attractionRepository.getLands().get(0).getName();
        assertEquals(results, "Adventureland");
    }

    @Test
    void fetchAttractionData_LandID() throws IOException {
        AttractionRepository attractionRepository = ParkService.fetchAttractionData();
        int results = attractionRepository.getLands().get(0).getId();
        assertEquals(results, 109);
    }

    @Test
    void fetchAttractionData_RideName() throws IOException {
        AttractionRepository attractionRepository = ParkService.fetchAttractionData();
        String results = attractionRepository.getLands().get(0).getRides().get(0).getName();
        assertEquals(results, "Enchanted Tiki Room");
    }
    @Test
    void fetchAttractionData_Ride_is_open() throws IOException {
        AttractionRepository attractionRepository = ParkService.fetchAttractionData();
        boolean results = attractionRepository.getLands().get(0).getRides().get(0).isIs_open();
        assertEquals(results, true);
    }

    @Test
    void fetchAttractionData_RideWaitTime() throws IOException {
        AttractionRepository attractionRepository = ParkService.fetchAttractionData();
        double results = attractionRepository.getLands().get(0).getRides().get(0).getWait_time();
        assertNotNull(results);
    }

    @Test
    void fetchAttractionData_RideLastUpdated() throws IOException {
        AttractionRepository attractionRepository = ParkService.fetchAttractionData();
        String results = attractionRepository.getLands().get(0).getRides().get(0).getLast_updated();
        assertNotNull(results);
    }

}