package com.detroitlabs.ThemePark.data;

import com.detroitlabs.ThemePark.model.Lands;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AttractionRepositoryTest {

    @Test
    void getLands() {
    }

    @Test
    void setLands() {
    }

//    public List<Lands> allLands() {
//        List<Lands> allLands = new ArrayList<>();
//        for (int i = 0; i < 8; i++) {
//            allLands.add(new Lands(lands.get(i).getId(), lands.get(i).getName(), lands.get(i).getRides()));
//        }
//        return allLands;
//    }
    @Test
    void allLands() {
        AttractionRepository attractionRepository = new AttractionRepository();
        String results = attractionRepository.getLands().get(0).getName();
        assertEquals(results, "AdventureLand");
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

    @Test
    void testAllLands() {
    }

    @Test
    void getAllLands() {
    }

    @Test
    void testAllRides() {
    }

    @Test
    void testFindById() {
    }

    @Test
    void testFindByName() {
    }
}