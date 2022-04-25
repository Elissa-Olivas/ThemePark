package com.detroitlabs.ThemePark.data;

import com.detroitlabs.ThemePark.model.Lands;
import com.detroitlabs.ThemePark.model.Rides;


import com.detroitlabs.ThemePark.service.ParkService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class AttractionRepository {

    private List<Lands> lands;
    private List<Rides> rides;
    private AttractionRepository parkData;
    public List<Rides> listOfRides;
    private List<Lands> allLands;
    private List<Rides> ridesPerLand;


    public List<Lands> getLands() {
        return lands;
    }

    public List<Rides> getRides() {
        return rides;
    }


    public List<Lands> landsList() throws IOException {
        parkData = ParkService.fetchAttractionData();
        allLands = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            allLands.add(new Lands(parkData.getLands().get(i).getId(), parkData.getLands().get(i).getName(), parkData.getLands().get(i).getRides()));
        }
        return allLands;
    }

    public List<Lands> getAllLands() {
        return allLands;
    }




    //Creates All Rides
    public List<Rides> ridesList() throws IOException {
        listOfRides = new ArrayList<>();
        for (int l = 0; l < allLands.size(); l++) {
            for (int i = 0; i < allLands.get(l).getRides().size(); i++) {
                listOfRides.add(new Rides(allLands.get(l).getRides().get(i).getId(), allLands.get(l).getRides().get(i).getName(),
                        allLands.get(l).getRides().get(i).isIs_open(), allLands.get(l).getRides().get(i).getWait_time(),
                        allLands.get(l).getRides().get(i).getLast_updated(), allLands.get(l).getRides().get(i).getMinHeight()));
            }
        }
        return listOfRides;
    }

    public List<Rides> getListOfRides() {
        return listOfRides;
    }

    //gets rides by land, make list with rides only within that land
    public List<Rides> getRidesByLand(String name) {
        ridesPerLand = new ArrayList<>();
        for (Lands lands: allLands) {
            if(lands.getName().equals(name)) {
                ridesPerLand = lands.getRides();
            }
        }
        return ridesPerLand;
    }


    public Object findById(int id) {
        for (Lands landByID : allLands) {
            if (landByID.getId() == id) {
                return id;
            }
        }
        return null;
    }

    public String findByName(String name) {
        for (Lands landByName : allLands) {
            if (landByName.getName().equals(name)) {
                return name;
            }
        }
        return null;
    }

//    private List<Rides> listOfRidesWithHeight;
//    //setting height requirements
//    //GIVE NULL POINTER EXCEPTION
//    public List<Rides> setRidesListWithHeight() throws IOException {
//        listOfRidesWithHeight = new ArrayList<>();
//        for (int l = 0; l < allLands.size(); l++) {
//            for (int i = 0; i < allLands.get(l).getRides().size(); i++) {
//                listOfRidesWithHeight.add(new Rides(allLands.get(l).getRides().get(i).getId(), allLands.get(l).getRides().get(i).getName(),
//                        allLands.get(l).getRides().get(i).isIs_open(), allLands.get(l).getRides().get(i).getWait_time(),
//                        allLands.get(l).getRides().get(i).getLast_updated(), allLands.get(l).getRides().get(i).getMinHeight()));
//
//                if (allLands.get(l).getRides().get(i).getName().equals("Autopia")) {
//                    allLands.get(l).getRides().get(i).setMinHeight(32);
//                    listOfRidesWithHeight.add(new Rides(allLands.get(l).getRides().get(i).getId(), allLands.get(l).getRides().get(i).getName(),
//                            allLands.get(l).getRides().get(i).isIs_open(), allLands.get(l).getRides().get(i).getWait_time(),
//                            allLands.get(l).getRides().get(i).getLast_updated(), allLands.get(l).getRides().get(i).getMinHeight()));
//                }
//                if (listOfRides.get(l).getName().equals("Gadget's Go Coster")) {
//                    listOfRides.get(l).setMinHeight(35);
//                    listOfRidesWithHeight.add(new Rides(allLands.get(l).getRides().get(i).getId(), allLands.get(l).getRides().get(i).getName(),
//                            allLands.get(l).getRides().get(i).isIs_open(), allLands.get(l).getRides().get(i).getWait_time(),
//                            allLands.get(l).getRides().get(i).getLast_updated(), allLands.get(l).getRides().get(i).getMinHeight()));
//                }
//                if (listOfRides.get(l).getName().equals("Millennium Falcon: Smugglers Run")) {
//                    listOfRides.get(l).setMinHeight(38);
//                    listOfRidesWithHeight.add(new Rides(allLands.get(l).getRides().get(i).getId(), allLands.get(l).getRides().get(i).getName(),
//                            allLands.get(l).getRides().get(i).isIs_open(), allLands.get(l).getRides().get(i).getWait_time(),
//                            allLands.get(l).getRides().get(i).getLast_updated(), allLands.get(l).getRides().get(i).getMinHeight()));
//                }
//                if (listOfRides.get(l).getName().equals("Big Thunder Mountain Railroad")) {
//                    listOfRides.get(l).setMinHeight(40);
//                    listOfRidesWithHeight.add(new Rides(allLands.get(l).getRides().get(i).getId(), allLands.get(l).getRides().get(i).getName(),
//                            allLands.get(l).getRides().get(i).isIs_open(), allLands.get(l).getRides().get(i).getWait_time(),
//                            allLands.get(l).getRides().get(i).getLast_updated(), allLands.get(l).getRides().get(i).getMinHeight()));
//                }
//                if (listOfRides.get(l).getName().equals("Space Mountain")) {
//                    listOfRides.get(l).setMinHeight(40);
//                    listOfRidesWithHeight.add(new Rides(allLands.get(l).getRides().get(i).getId(), allLands.get(l).getRides().get(i).getName(),
//                            allLands.get(l).getRides().get(i).isIs_open(), allLands.get(l).getRides().get(i).getWait_time(),
//                            allLands.get(l).getRides().get(i).getLast_updated(), allLands.get(l).getRides().get(i).getMinHeight()));
//                }
//                if (listOfRides.get(l).getName().equals("Splash Mountain")) {
//                    listOfRides.get(l).setMinHeight(40);
//                    listOfRidesWithHeight.add(new Rides(allLands.get(l).getRides().get(i).getId(), allLands.get(l).getRides().get(i).getName(),
//                            allLands.get(l).getRides().get(i).isIs_open(), allLands.get(l).getRides().get(i).getWait_time(),
//                            allLands.get(l).getRides().get(i).getLast_updated(), allLands.get(l).getRides().get(i).getMinHeight()));
//                }
//                if (listOfRides.get(l).getName().equals("Star Tours")) {
//                    listOfRides.get(l).setMinHeight(40);
//                    listOfRidesWithHeight.add(new Rides(allLands.get(l).getRides().get(i).getId(), allLands.get(l).getRides().get(i).getName(),
//                            allLands.get(l).getRides().get(i).isIs_open(), allLands.get(l).getRides().get(i).getWait_time(),
//                            allLands.get(l).getRides().get(i).getLast_updated(), allLands.get(l).getRides().get(i).getMinHeight()));
//                }
//                if (listOfRides.get(l).getName().equals("Star Wars: Rise of the Resistance")) {
//                    listOfRides.get(l).setMinHeight(40);
//                    listOfRidesWithHeight.add(new Rides(allLands.get(l).getRides().get(i).getId(), allLands.get(l).getRides().get(i).getName(),
//                            allLands.get(l).getRides().get(i).isIs_open(), allLands.get(l).getRides().get(i).getWait_time(),
//                            allLands.get(l).getRides().get(i).getLast_updated(), allLands.get(l).getRides().get(i).getMinHeight()));
//                }
//                if (listOfRides.get(l).getName().equals("MMatterhorn Bobsleds")) {
//                    listOfRides.get(l).setMinHeight(42);
//                    listOfRidesWithHeight.add(new Rides(allLands.get(l).getRides().get(i).getId(), allLands.get(l).getRides().get(i).getName(),
//                            allLands.get(l).getRides().get(i).isIs_open(), allLands.get(l).getRides().get(i).getWait_time(),
//                            allLands.get(l).getRides().get(i).getLast_updated(), allLands.get(l).getRides().get(i).getMinHeight()));
//                }
//                if (listOfRides.get(l).getName().equals("Indiana Jones Adventure")) {
//                    listOfRides.get(l).setMinHeight(46);
//                    listOfRidesWithHeight.add(new Rides(allLands.get(l).getRides().get(i).getId(), allLands.get(l).getRides().get(i).getName(),
//                            allLands.get(l).getRides().get(i).isIs_open(), allLands.get(l).getRides().get(i).getWait_time(),
//                            allLands.get(l).getRides().get(i).getLast_updated(), allLands.get(l).getRides().get(i).getMinHeight()));
//                }
//            }
//        }
//            return listOfRidesWithHeight;
//    }


    //find by height
    public Rides findByHeight(int minHeight) {
        for (Rides ridesByHeight : rides) {
            if (ridesByHeight.getMinHeight() == minHeight) {
                return ridesByHeight;
            }
        }
        return null;
    }
}

