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
            allLands.add(new Lands(parkData.getLands().get(i).getId(), parkData.getLands().get(i).getName(), returnImage(parkData.getLands().get(i).getName()), parkData.getLands().get(i).getRides()));
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
                Rides ride = allLands.get(l).getRides().get(i);
                listOfRides.add(new Rides(ride.getId(), ride.getName(),
                        ride.isIs_open(), allLands.get(l).getRides().get(i).getWait_time(),
                        ride.getLast_updated(), returnHeightOfRide(ride.getName())));
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

    public String findByName(String name) {
        for (Lands landByName : allLands) {
            if (landByName.getName().equals(name)) {
                return name;
            }
        }
        return null;
    }

    public int returnHeightOfRide(String name) {
        if (name.equals("Autopia")) {
            return 32;
        }
        else if (name.equals("Gadget's Go Coster")) {
            return 35;
        }
        else if (name.equals("Millennium Falcon: Smugglers Run")) {
            return 38;
        }
        else if (name.equals("Big Thunder Mountain Railroad") || name.equals("Space Mountain") || name.equals("Star Tours") || name.equals("Star Wars: Rise of the Resistance")) {
            return 40;
        }
        else if (name.equals("Matterhorn Bobsleds")) {
            return 42;
        }
        else if (name.equals("Indiana Jones Adventure")) {
            return 46;
        }
        else {
            return 0;
        }
    }

    public String returnImage(String name) {
        if (name.equals("Adventureland")) {
            return "adventureland";
        }
        else if (name.equals("Critter Country")) {
            return "crittercountry";
        }
        else if (name.equals("Fantasyland")) {
            return "fantasyland";
        }
        else if (name.equals("Frontierland")) {
            return "frontierland";
        }
        else if (name.equals("Main Street U.S.A")) {
            return "mainstreet";
        }
        else if (name.equals("Mickey's Toontown")) {
            return "toontown";
        }
        else if (name.equals("New Orleans Square")) {
            return "orleans";
        }
        else if (name.equals("Star Wars: Galaxy's Edge")) {
            return "starwars";
        }
        else {
            return "tomorrowland";
        }
    }


    //find by height
    public List<Rides> findByHeightUnder32(int minHeight) {
        List<Rides> ridesByHeight32 = new ArrayList<>();
        for (Rides rides : listOfRides) {
            if (rides.getMinHeight() < minHeight) {
                ridesByHeight32.add(rides);
            }
        }
        return ridesByHeight32;
    }

    public List<Rides> findByHeightOver32(int minHeight) {
        List<Rides> ridesByHeightOver32 = new ArrayList<>();
        for (Rides rides : listOfRides) {
            if (rides.getMinHeight() >= minHeight) {
                ridesByHeightOver32.add(rides);
            }
        }
        return ridesByHeightOver32;
    }
}

