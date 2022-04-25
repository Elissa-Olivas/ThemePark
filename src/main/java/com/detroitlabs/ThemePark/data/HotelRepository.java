package com.detroitlabs.ThemePark.data;

import com.detroitlabs.ThemePark.model.Data;
import com.detroitlabs.ThemePark.model.Hotel;
import com.detroitlabs.ThemePark.model.HotelResponse;
import com.detroitlabs.ThemePark.service.HotelService;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class HotelRepository {     //Data,Body,SearchResults, Results (hotel name, starRating, address, Price, Coordinates, srpDesktop(URL IMAGE))

    private Data data;

    private List<Hotel> allHotels;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public List<Hotel> getAllHotels() {
        return allHotels;
    }

    public void setAllHotels(List<Hotel> allHotels) {
        this.allHotels = allHotels;
    }


//    public void generateHotels(String location, String checkIn, String checkout) throws IOException {
//        allHotels = new ArrayList<>();
//        int locationId = HotelService.fetchDestinationId(location).getSuggestions().get(0).getEntities().get(0).getDestinationId();
//        HotelResponse hotelResponse = HotelService.fetchHotelDetails(locationId, checkIn, checkout);
//        for (int h = 0; h < 9; h++) {
//            String name = hotelResponse.getData().getBody().getSearchResults().getResults().get(h).getName();
//            String starRating = hotelResponse.getData().getBody().getSearchResults().getResults().get(h).getStarRating();
//            String streetAddress = hotelResponse.getData().getBody().getSearchResults().getResults().get(h).getAddress().getStreetAddress();
//            String locality = hotelResponse.getData().getBody().getSearchResults().getResults().get(h).getAddress().getLocality();
//            String region = hotelResponse.getData().getBody().getSearchResults().getResults().get(h).getAddress().getRegion();
//            String postalCode = hotelResponse.getData().getBody().getSearchResults().getResults().get(h).getAddress().getPostalCode();
//
//
//            double lat = hotelResponse.getData().getBody().getSearchResults().getResults().get(h).getCoordinate().getLat();
//            double lon = hotelResponse.getData().getBody().getSearchResults().getResults().get(h).getCoordinate().getLon();
//
//            allHotels.add(new Hotel(name, starRating, streetAddress, locality, region, postalCode, lat, lon));
//        }
//    }

    public void generateHotels(String location, String checkIn, String checkout) throws IOException {
        allHotels = new ArrayList<>();
        int locationId = HotelService.fetchDestinationId(location).getSuggestions().get(0).getEntities().get(0).getDestinationId();
        HotelResponse hotelResponse = HotelService.fetchHotelDetails(locationId, checkIn, checkout);
        for (int h = 0; h < 9; h++) {
            String name = hotelResponse.getData().getBody().getSearchResults().getResults().get(h).getName();
            String starRating = hotelResponse.getData().getBody().getSearchResults().getResults().get(h).getStarRating();
            String streetAddress = hotelResponse.getData().getBody().getSearchResults().getResults().get(h).getAddress().getStreetAddress();
            String locality = hotelResponse.getData().getBody().getSearchResults().getResults().get(h).getAddress().getLocality();
            String region = hotelResponse.getData().getBody().getSearchResults().getResults().get(h).getAddress().getRegion();
            String postalCode = hotelResponse.getData().getBody().getSearchResults().getResults().get(h).getAddress().getPostalCode();


            double lat = hotelResponse.getData().getBody().getSearchResults().getResults().get(h).getCoordinate().getLat();
            double lon = hotelResponse.getData().getBody().getSearchResults().getResults().get(h).getCoordinate().getLon();
            String current = hotelResponse.getData().getBody().getSearchResults().getResults().get(h).getRateplan().getPrice().getCurrent();
            String srpDesktop = hotelResponse.getData().getBody().getSearchResults().getResults().get(h).getOptimizedThumbUrl().getSrpDesktop();

            allHotels.add(new Hotel(name, starRating, streetAddress, locality, region, postalCode, lat, lon, current, srpDesktop));
        }
    }

}
