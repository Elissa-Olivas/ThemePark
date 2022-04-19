package com.detroitlabs.ThemePark.service;

import com.detroitlabs.ThemePark.data.AttractionRepository;
import com.detroitlabs.ThemePark.model.Lands;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkServiceTest {

    @Test
    void fetchAttractionData() {
        Lands lands = ParkService.fetchAttractionData();
        String results = lands.getName();
        assertEquals(results, "Adventureland");
    }
}