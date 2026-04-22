package com.example.connectparbhsni;

public class PlaceModel {
    private String name;
    private String category;
    private String address;
    private String phoneNumber;
    private String hours;
    private String distance;
    private double lat;
    private double lng;

    public PlaceModel(String name, String category, String address, String phoneNumber, String hours, String distance, double lat, double lng) {
        this.name = name;
        this.category = category;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.hours = hours;
        this.distance = distance;
        this.lat = lat;
        this.lng = lng;
    }

    public String getName() { return name; }
    public String getCategory() { return category; }
    public String getAddress() { return address; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getHours() { return hours; }
    public String getDistance() { return distance; }
    public double getLat() { return lat; }
    public double getLng() { return lng; }

    public void setDistance(String distance) {
        this.distance = distance;
    }
}