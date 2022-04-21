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
    private List<String> ridesPerLand;


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




    //Creates Rides
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

    public Rides findByHeight(int minHeight) {
        for (Rides ridesByHeight : rides) {
            if (ridesByHeight.getMinHeight() == minHeight) {
                return ridesByHeight;
            }
        }
        return null;
    }
}

