package com.detroitlabs.ThemePark.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Results {
    private String name;
    private String starRating;
    private Address address;
    private Rateplan rateplan;
    private OptimizedThumbUrl optimizedThumbUrl;
    private Coordinate coordinate;

    @JsonProperty("optimizedThumbUrls")
    public OptimizedThumbUrl getOptimizedThumbUrl() {
        return optimizedThumbUrl;
    }

    @JsonProperty("optimizedThumbUrls")
    public void setOptimizedThumbUrl(OptimizedThumbUrl optimizedThumbUrl) {
        this.optimizedThumbUrl = optimizedThumbUrl;
    }

    @JsonProperty("ratePlan")
    public Rateplan getRateplan() {
        return rateplan;
    }

    @JsonProperty("ratePlan")
    public void setRateplan(Rateplan rateplan) {
        this.rateplan = rateplan;
    }

    @JsonProperty("coordinate")
    public Coordinate getCoordinate() {
        return coordinate;
    }


    @JsonProperty("coordinate")
    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStarRating() {
        return starRating;
    }

    public void setStarRating(String starRating) {
        this.starRating = starRating;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
