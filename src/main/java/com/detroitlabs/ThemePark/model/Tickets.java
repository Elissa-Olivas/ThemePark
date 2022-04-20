package com.detroitlabs.ThemePark.model;

public class Tickets {
    private String ticketType;      //infant, child, adult, senior
    private int numOfDays;
    private double price;

    public Tickets(String ticketType, int numOfDays, double price) {
        this.ticketType = ticketType;
        this.numOfDays = numOfDays;
        this.price = price;
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
