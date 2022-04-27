package com.detroitlabs.ThemePark.model;

public class Tickets {
    private String ticketType;      //infant, child, adult, senior
    private int numOfDays;
    private double price;
    private int id;

    public Tickets(String ticketType, int numOfDays, double price, int id) {
        this.ticketType = ticketType;
        this.numOfDays = numOfDays;
        this.price = price;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public int getNumOfDays() {
        return numOfDays;
    }

    public void setNumOfDays(int numOfDays) {
        this.numOfDays = numOfDays;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
