package com.detroitlabs.ThemePark.data;

import com.detroitlabs.ThemePark.model.Lands;
import com.detroitlabs.ThemePark.model.Rides;


import com.detroitlabs.ThemePark.service.ParkService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class AttractionRepository {

    private List<Lands> lands;
    private List<Rides> rides;
    private AttractionRepository parkData;


    public List<Lands> getLands() {
        return lands;
    }

    public List<Rides> getRides() {
        return rides;
    }


    private List<Lands> allLands;
    public List<Lands> landsList () throws IOException {
        parkData = ParkService.fetchAttractionData();
        allLands = new ArrayList<>();
        for(int i = 0; i < 9; i++) {
            allLands.add(new Lands(parkData.getLands().get(i).getId(), parkData.getLands().get(i).getName(), parkData.getLands().get(i).getRides()));
        }
        return allLands;
    }

    //Lands attempt 1 - no error, but dosent list any information on html page
//    private List<Lands> allLands;
//
//        public List<Lands> allLands() {
//        allLands = new ArrayList<>();
//        for (int i = 0; i < lands.size(); i++) {
//            allLands.add(new Lands(lands.get(i).getId(), lands.get(i).getName(), lands.get(i).getRides()));
//        }
//        return allLands;
//    }
//
//    public List<Lands> getAllLands() {
//        return allLands;
//    }


    //Lands attempt 2 - Get Error creating bean with name
//    public List<Lands> AllLands = Arrays.asList(
//            new Lands(lands.get(0).getId(), lands.get(0).getName(), lands.get(0).getRides()),
//            new Lands(lands.get(1).getId(), lands.get(1).getName(), lands.get(1).getRides()),
//            new Lands(lands.get(2).getId(), lands.get(2).getName(), lands.get(2).getRides()),
//            new Lands(lands.get(3).getId(), lands.get(3).getName(), lands.get(3).getRides()),
//            new Lands(lands.get(4).getId(), lands.get(4).getName(), lands.get(4).getRides()),
//            new Lands(lands.get(5).getId(), lands.get(5).getName(), lands.get(5).getRides()),
//            new Lands(lands.get(6).getId(), lands.get(6).getName(), lands.get(6).getRides()),
//            new Lands(lands.get(7).getId(), lands.get(7).getName(), lands.get(7).getRides()));

//    public List<Lands> getAllLands() {
//        return AllLands;
//    }


    //Attempt 1
    public List<Rides> listOfRides;

    public List<Rides> allRides() {
        listOfRides = new ArrayList<>();
        for (int i = 0; i < allLands.size(); i++) {
            listOfRides.add(new Rides(lands.get(i).getRides().get(i).getId(), lands.get(i).getRides().get(i).getName(),
                    lands.get(i).getRides().get(i).isIs_open(), lands.get(i).getRides().get(i).getWait_time(),
                    lands.get(i).getRides().get(i).getLast_updated(), lands.get(i).getRides().get(i).getMinHeight()));
        }
        return listOfRides;
    }

    public List<Rides> getListOfRides() {
        return listOfRides;
    }

    //Attempt 2
//    private List<Rides> listOfAllRides;
//
//    public List<Rides> getListOfAllRides() {
//        return listOfAllRides;
//    }
//
//    public void setListOfAllRides(List<Rides> listOfAllRides) {
//        this.listOfAllRides = listOfAllRides;
//    }
//
//    public void generateRides() throws IOException {
//        listOfAllRides = new ArrayList<>();
////        int landId = ParkService.fetchAttractionData().getLands().get(0).getId();
//        AttractionRepository attractionRepository = ParkService.fetchAttractionData();
//        for (int a = 0; a < 5; a++) {
//            String landName = attractionRepository.getLands().get(a).getName();
//                for (int r = 0; r < 5; r++) {
//                    int rideId = attractionRepository.allRides().get(r).getId();
//                    String rideName = attractionRepository.allRides().get(r).getName();
//                     boolean ride_is_open = attractionRepository.allRides().get(r).isIs_open();
//                     double ride_wait_time = attractionRepository.allRides().get(r).getWait_time();
//                     String ride_last_updated = attractionRepository.allRides().get(r).getLast_updated();
//                     int minHeight = attractionRepository.allRides().get(r).getMinHeight();
//                    listOfAllRides.add(new Rides(rideId, rideName, ride_is_open, ride_wait_time, ride_last_updated, minHeight));
//                }
//            }
//        }

//    public void generateAllRides() throws IOException {
//        listOfAllRides = new ArrayList<>();
//        AttractionRepository attractionRepository = ParkService.fetchAttractionData();
//        for (int a = 0; a < 5; a++) {
//                int rideId = attractionRepository.allRides().get(a).getId();
//                String rideName = attractionRepository.allRides().get(a).getName();
//                boolean ride_is_open = attractionRepository.allRides().get(a).isIs_open();
//                double ride_wait_time = attractionRepository.allRides().get(a).getWait_time();
//                String ride_last_updated = attractionRepository.allRides().get(a).getLast_updated();
//                int minHeight = attractionRepository.allRides().get(a).getMinHeight();
//                listOfAllRides.add(new Rides(rideId, rideName, ride_is_open, ride_wait_time, ride_last_updated, minHeight));
//            }
//        }

    public Object findById(int id) {
        for (Lands landByID : lands) {
            if (landByID.getId() == id) {
                return id;
            }
        }
        return null;
    }

    public String findByName(String name) {
        for (Lands landByName : lands) {
            if (landByName.getName().equals(name)) {
                return name;
            }
        }
        return null;
    }

    public Rides findByHeight(int minHeight) {
        for (Rides ridesByHeight : rides) {
            if (ridesByHeight.getMinHeight() == minHeight) {
                return ridesByHeight;
            }
        }
        return null;
    }

    }

