package com.detroitlabs.ThemePark.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Rides {
    //rides which is a List- these items are in the ArrayList
    private int id;
    private String name;
    private boolean is_open;
    private double wait_time;
    private String last_updated;
    private int minHeight;

    public Rides(int id, String name, boolean is_open, double wait_time, String last_updated, int minHeight) {
        this.id = id;
        this.name = name;
        this.is_open = is_open;
        this.wait_time = wait_time;
        this.last_updated = last_updated;
        this.minHeight = minHeight;
    }


    public int getMinHeight() {
        return minHeight;
    }

    public void setMinHeight(int minHeight) {
        this.minHeight = minHeight;
    }

    public Rides() {

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

    public boolean isIs_open() {
        return is_open;
    }

    public void setIs_open(boolean is_open) {
        this.is_open = is_open;
    }

    public double getWait_time() {
        return wait_time;
    }

    public void setWait_time(double wait_time) {
        this.wait_time = wait_time;
    }

    public String getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }
}
