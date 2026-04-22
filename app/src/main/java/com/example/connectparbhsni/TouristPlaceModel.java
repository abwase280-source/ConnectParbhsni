package com.example.connectparbhsni;

import java.io.Serializable;
import java.util.List;

public class TouristPlaceModel implements Serializable {
    private String name;
    private String shortDescription;
    private String fullHistory;
    private String locationName;
    private double latitude;
    private double longitude;
    private List<Integer> imageResIds;
    private String category;

    public TouristPlaceModel(String name, String shortDescription, String fullHistory, String locationName, double latitude, double longitude, List<Integer> imageResIds, String category) {
        this.name = name;
        this.shortDescription = shortDescription;
        this.fullHistory = fullHistory;
        this.locationName = locationName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.imageResIds = imageResIds;
        this.category = category;
    }

    public String getName() { return name; }
    public String getShortDescription() { return shortDescription; }
    public String getFullHistory() { return fullHistory; }
    public String getLocationName() { return locationName; }
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }
    public List<Integer> getImageResIds() { return imageResIds; }
    public String getCategory() { return category; }
}
