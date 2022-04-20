package com.detroitlabs.ThemePark.model;

public class Company {
    private String name;
    private String email;
    private String phn;
    private String address;
//    private int picID;   //pic ID for MAP


    public Company(String name, String email, String phn, String address) {
        this.name = name;
        this.email = email;
        this.phn = phn;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhn() {
        return phn;
    }

    public void setPhn(String phn) {
        this.phn = phn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
