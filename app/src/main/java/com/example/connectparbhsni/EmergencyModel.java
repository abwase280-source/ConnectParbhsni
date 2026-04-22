package com.example.connectparbhsni;

public class EmergencyModel {
    private String title;
    private String phoneNumber;

    public EmergencyModel(String title, String phoneNumber) {
        this.title = title;
        this.phoneNumber = phoneNumber;
    }

    public String getTitle() { return title; }
    public String getPhoneNumber() { return phoneNumber; }
}