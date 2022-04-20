package com.detroitlabs.ThemePark.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class RidesTest {

    private Rides testRide;

    @BeforeEach
    void newRide() {
        testRide = new Rides(404, "AdventureLand", true, 4, "2022-04-19T13:01:18.000Z", 65);
    }

    @Test
    void getId() {
        int result = testRide.getId();
        assertEquals(result, 404);
    }

//    @Test
//    void setId() throws NoSuchFieldException, IllegalAccessException {
//        testRide.setId(65);
//        final Field field = testRide.getClass().getDeclaredField("id");
//        field.setAccessible(true);
//        assertEquals(65, field.get(testRide), 65);
//    }

    @Test
    void getName() {
        String result = testRide.getName();
        assertEquals(result, "AdventureLand");
    }

    @Test
    void setName() throws NoSuchFieldException, IllegalAccessException {
        testRide.setName("AdventureIsland");
        final Field field = testRide.getClass().getDeclaredField("name");
        field.setAccessible(true);
        assertEquals("AdventureIsland", field.get(testRide), "AdventureIsland");
    }

    @Test
    void isIs_open() {
        boolean result = testRide.isIs_open();
        assertEquals(result, true);
    }

    @Test
    void setIs_open() throws NoSuchFieldException, IllegalAccessException{
        testRide.setIs_open(true);
        final Field field = testRide.getClass().getDeclaredField("is_open");
        field.setAccessible(true);
        assertEquals(true, field.get(testRide), String.valueOf(true));
    }

    @Test
    void getWait_time() {
        double result = testRide.getWait_time();
        assertEquals(result, 4);
    }

//    @Test
//    void setWait_time() throws NoSuchFieldException, IllegalAccessException{
//        testRide.setWait_time(10);
//        final Field field = testRide.getClass().getDeclaredField("wait_time");
//        assertEquals(10, field.get(testRide), 10);
//    }

    @Test
    void getLast_updated() {
        String result = testRide.getLast_updated();
        assertEquals(result, "2022-04-19T13:01:18.000Z");
    }

    @Test
    void setLast_updated() throws NoSuchFieldException, IllegalAccessException {
        testRide.setLast_updated("2022-04-19T10:00:00.000Z");
        final Field field = testRide.getClass().getDeclaredField("last_updated");
        field.setAccessible(true);
        assertEquals("2022-04-19T10:00:00.000Z", field.get(testRide), "2022-04-19T10:00:00.000Z");
    }
}