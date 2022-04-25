package com.detroitlabs.ThemePark.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Lands {
    private int id;
    private String name;
    private String picID;
    private List<Rides> rides;     //list of rights in that land

    //constructor
    public Lands(int id, String name, String picID, List<Rides> rides) {
        this.id = id;
        this.name = name;
        this.picID = picID;
        this.rides = rides;
    }

    public String getPicID() {
        return picID;
    }

    public void setPicID(String picID) {
        this.picID = picID;
    }

    public Lands() {

    }
    public Lands(int id, String landName) {
        this.id = id;
        this.name = landName;
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Rides> getRides() {
        return rides;
    }

    public void setRides(List<Rides> rides) {
        this.rides = rides;
    }
}
