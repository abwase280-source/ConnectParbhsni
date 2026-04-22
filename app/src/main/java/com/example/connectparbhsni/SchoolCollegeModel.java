package com.example.connectparbhsni;

public class SchoolCollegeModel {
    private String name;
    private String type; // "SCHOOL" or "COLLEGE"
    private String address;
    private double latitude;
    private double longitude;
    private String description;
    private String contact;
    private String website;
    private String establishedYear;
    private boolean isVerified;
    private boolean isExpanded;

    public SchoolCollegeModel(String name, String type, String address, double latitude, double longitude, 
                              String description, String contact, String website, String establishedYear, boolean isVerified) {
        this.name = name;
        this.type = type;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = description;
        this.contact = contact;
        this.website = website;
        this.establishedYear = establishedYear;
        this.isVerified = isVerified;
        this.isExpanded = false;
    }

    public String getName() { return name; }
    public String getType() { return type; }
    public String getAddress() { return address; }
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }
    public String getDescription() { return description; }
    public String getContact() { return contact; }
    public String getWebsite() { return website; }
    public String getEstablishedYear() { return establishedYear; }
    public boolean isVerified() { return isVerified; }
    public boolean isExpanded() { return isExpanded; }
    public void setExpanded(boolean expanded) { isExpanded = expanded; }
}
