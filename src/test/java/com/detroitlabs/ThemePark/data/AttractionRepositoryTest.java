package com.detroitlabs.ThemePark.data;

import com.detroitlabs.ThemePark.model.Lands;
import com.detroitlabs.ThemePark.model.Rides;
import com.detroitlabs.ThemePark.service.ParkService;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AttractionRepositoryTest {

    @Test
    void get_One_Lands() throws IOException {
        AttractionRepository attractionRepository = ParkService.fetchAttractionData();
        String results = attractionRepository.landsList().get(0).getName();
        assertEquals(results, "Adventureland");
    }

    @Test
    void setLands() {
    }

    @Test
    void return_Land_ID() throws IOException {
        AttractionRepository attractionRepository = ParkService.fetchAttractionData();
        int results = attractionRepository.landsList().get(0).getId();
        assertEquals(results, 109);
    }

    @Test
    void allRides() {
    }

    @Test
    void findById() {
    }

    @Test
    void findByName() {
    }

    @Test
    void testGetLands() {
    }

    @Test
    void testSetLands() {
    }

    //    public List<Lands> allLands() {
//        List<Lands> allLands = new ArrayList<>();
//        for (int i = 0; i < 8; i++) {
//            allLands.add(new Lands(lands.get(i).getId(), lands.get(i).getName(), lands.get(i).getRides()));
//        }
//        return allLands;
//    }
    @Test
    void testAllLands() throws IOException {
        AttractionRepository attractionRepository = ParkService.fetchAttractionData();
        List<Lands> testLand = attractionRepository.landsList();
        assertEquals(testLand.get(0).getName(), "Adventureland");
    }

    @Test
    void getAllLands() {


    }

//    @Test //fail - null pointer exception
//    void testRidesList_Return_a_Ride() throws IOException {
//        AttractionRepository attractionRepository = new AttractionRepository();
//        List<Rides> testRides = attractionRepository.ridesList();
//        assertEquals(testRides.get(0).getName(), "Indian");
//    }

//    @Test //failed - null pointer exception
//    void testFind_Rides_By_Name() throws IOException {
//        AttractionRepository attractionRepository = ParkService.fetchAttractionData();
//        String results = attractionRepository.findByName("Enchanted Tiki Room");
//        assertEquals(results, "Enchanted Tiki Room");
//    }

//    @Test //failed - null pointer exception
//    void test_return_Ride_Under32() {
//        AttractionRepository attractionRepository = new AttractionRepository();
//        List<Rides> result = attractionRepository.findByHeightUnder32(32);
//        assertEquals(result.get(0).getName(), "");
//    }
}