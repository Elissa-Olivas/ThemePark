package com.detroitlabs.ThemePark.data;

import com.detroitlabs.ThemePark.model.Lands;
import com.detroitlabs.ThemePark.model.Rides;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class AttractionRepository {

    private List<Lands> lands;

    public List<Lands> getLands() {
        return lands;
    }

    public void setLands(List<Lands> lands) {
        this.lands = lands;
    }

//    public List<Lands> allLands() {
//        List<Lands> allLands = new ArrayList<>();
//        for (int i = 0; i < lands.size(); i++) {
//            allLands.add(new Lands(lands.get(i).getId(), lands.get(i).getName(), lands.get(i).getRides()));
//        }
//        return allLands;
//    }

    public List<Lands> allLands() {
        List<Lands> allLands = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            allLands.add(new Lands(lands.get(i).getId(), lands.get(i).getName(), lands.get(i).getRides()));
        }
        return allLands;
    }

//    public static final List<Lands> AllLands = Arrays.asList(
//            new Lands(lands.get(0).getId(), lands.get(0).getName(), lands.get(0).getRides()),
//            new Lands(lands.get(1).getId(), lands.get(1).getName(), lands.get(1).getRides()),
//            new Lands(lands.get(2).getId(), lands.get(2).getName(), lands.get(2).getRides()),
//            new Lands(lands.get(3).getId(), lands.get(3).getName(), lands.get(3).getRides()),
//            new Lands(lands.get(4).getId(), lands.get(4).getName(), lands.get(4).getRides()),
//            new Lands(lands.get(5).getId(), lands.get(5).getName(), lands.get(5).getRides()),
//            new Lands(lands.get(6).getId(), lands.get(6).getName(), lands.get(6).getRides()),
//            new Lands(lands.get(7).getId(), lands.get(7).getName(), lands.get(7).getRides()));
//
//    public List<Lands> getAllLands() {
//        return AllLands;
//    }
    public List<Rides> allRides() {
        List<Rides> listOfRides = new ArrayList<>();
        for (int i= 0; i < lands.size(); i ++) {
            listOfRides.add(new Rides(lands.get(i).getRides().get(i).getId(), lands.get(i).getRides().get(i).getName(),
                    lands.get(i).getRides().get(i).isIs_open(), lands.get(i).getRides().get(i).getWait_time(),
                    lands.get(i).getRides().get(i).getLast_updated()));
        }
        return listOfRides;
    }


    public Object findById(int id) {
        for(Lands landByID: lands) {
            if (landByID.getId() == id) {
                return id;
            }
        }
        return null;
    }

    public String findByName(String name) {
        for(Lands landByName: lands) {
            if (landByName.getName().equals(name)) {
                return name;
            }
        }
        return null;
    }


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

}

