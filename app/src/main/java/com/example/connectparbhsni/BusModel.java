package com.example.connectparbhsni;

public class BusModel {
    private String busName;
    private String departureTime;
    private String arrivalTime;
    private String duration;
    private String price;
    private String busType;
    private String to;

    public BusModel(String busName, String departureTime, String arrivalTime, String duration, String price, String busType, String to) {
        this.busName = busName;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.duration = duration;
        this.price = price;
        this.busType = busType;
        this.to = to;
    }

    public String getBusName() {
        return busName;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public String getDuration() {
        return duration;
    }

    public String getPrice() {
        return price;
    }

    public String getBusType() {
        return busType;
    }

    public String getTo() {
        return to;
    }
}
