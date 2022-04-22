package com.detroitlabs.ThemePark.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Price {
    private String current;
    private int exactCurrent;

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public int getExactCurrent() {
        return exactCurrent;
    }

    public void setExactCurrent(int exactCurrent) {
        this.exactCurrent = exactCurrent;
    }
}
