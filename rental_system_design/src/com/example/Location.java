package com.example;

public class Location {
    private String id;
    private String cityName;
    private String stateName;
    private String longitude;
    private String latitude;


    @Override
    public String toString() {
        return "Location{" +
                "id='" + id + '\'' +
                ", cityName='" + cityName + '\'' +
                ", stateName='" + stateName + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                '}';
    }

    public Location(String id, String cityName, String stateName, String longitude, String latitude) {
        this.id = id;
        this.cityName = cityName;
        this.stateName = stateName;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
