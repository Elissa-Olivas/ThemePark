package com.detroitlabs.ThemePark.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Lands {
    private int id;
    private String name;
    private List<Rides> rides;     //list of rights in that land

    //constructor
    public Lands(int id, String name, List<Rides> rides) {
        this.id = id;
        this.name = name;
        this.rides = rides;
    }

    public Lands() {

    }
    public Lands(int id, String name) {
        this.id = id;
        this.name = name;
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
