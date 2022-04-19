package com.detroitlabs.ThemePark.model;

import java.util.List;

public class Restaurants {
    private String restaurantName;
    private String hours;
    private List<Food> listOfFood;

    public Restaurants(String restaurantName, String hours, List<Food> listOfFood) {
        this.restaurantName = restaurantName;
        this.hours = hours;
        this.listOfFood = listOfFood;
    }


    public List<Food> getListOfFood() {
        return listOfFood;
    }

    public void setListOfFood(List<Food> listOfFood) {
        this.listOfFood = listOfFood;
    }


    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }
}
