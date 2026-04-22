package com.example.connectparbhsni;

import java.io.Serializable;

public class TheaterModel implements Serializable {
    private String name;
    private String address;
    private double latitude;
    private double longitude;
    private String phone;
    private String category;
    private String description;
    private int imageResId;
    private boolean isMultiplex;

    public TheaterModel(String name, String address, double latitude, double longitude, String phone, String category, String description, int imageResId, boolean isMultiplex) {
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.phone = phone;
        this.category = category;
        this.description = description;
        this.imageResId = imageResId;
        this.isMultiplex = isMultiplex;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getPhone() {
        return phone;
    }

    public String getContactNumber() {
        return phone;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResId() {
        return imageResId;
    }

    public boolean isMultiplex() {
        return isMultiplex;
    }
}
