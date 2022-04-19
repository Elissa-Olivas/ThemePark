package com.detroitlabs.ThemePark.data;

import com.detroitlabs.ThemePark.model.Lands;
import com.detroitlabs.ThemePark.model.Rides;
import com.detroitlabs.ThemePark.service.ParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Attr;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class AttractionRepository {

    @Autowired
    private List<Lands> lands;

    public List<Lands> getLands() {
        return lands;
    }

    public void setLands(List<Lands> lands) {
        this.lands = lands;
    }

    public List<Lands> allLands() {
        for (int i = 0; i < lands.size(); i++) {
            lands.add(new Lands(lands.get(i).getId(), lands.get(i).getName(), lands.get(i).getRides()));
        }
        return lands;
    }

    public List<Rides> allRides() {
        List<Rides> listOfRides = new ArrayList<>();
        for (int i= 0; i < lands.size(); i ++) {
            listOfRides.add(new Rides(lands.get(i).getRides().get(i).getId(), lands.get(i).getRides().get(i).getName(),
                    lands.get(i).getRides().get(i).isIs_open(), lands.get(i).getRides().get(i).getWait_time(),
                    lands.get(i).getRides().get(i).getLast_updated()));
        }
        return listOfRides;
    }

    //    private List<Rides> allRides;

//    public static final List<Lands> ALL_LANDS = Arrays.asList(
//            new Lands(lands.getId(), lands.getName(), lands.getRides()));
//
//    public static Lands getLands() {
//        return lands;
//    }
//
//    public static void setLands(Lands lands) {
//        AttractionRepository.lands = lands;
//    }

//    public Object findById(int id) {
//        for(Lands lands: ALL_LANDS) {
//            if (lands.getId() == id) {
//                return id;
//            }
//        }
//        return null;
//    }
//
//    public String findByName(String name) {
//        for(Lands lands: ALL_LANDS) {
//            if (lands.getName().equals(name)) {
//                return name;
//            }
//        }
//        return null;
//    }
//
//    public List<Lands> getAllLands() {
//        return ALL_LANDS;
//    }
//
//    public void generateRides() {
//        allRides = new ArrayList<>();
//        Lands lands = ParkService.fetchAttractionData();
//        for (int a = 0; a < 5; a++) {
//            for (int r = 0; r < 5; r++) {
//                int rideId = lands.getRides().get(a).getId();
//                String rideName = lands.getRides().get(r).getName();
//                boolean ride_is_open = lands.getRides().get(r).isIs_open();
//                double ride_wait_time = lands.getRides().get(r).getWait_time();
//                String ride_last_updated = lands.getRides().get(r).getLast_updated();
//
//                allRides.add(new Rides(rideId, rideName, ride_is_open, ride_wait_time, ride_last_updated));
//            }
//        }
//    }
//
//
//
//    public List<Rides> getAllRides() {
//        return allRides;
//    }
//
//    public void setAllRides(List<Rides> allRides) {
//        this.allRides = allRides;
//    }
}

