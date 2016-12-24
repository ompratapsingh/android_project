package com.dave.materialdesignsample.model;

/**
 * Created by Dave on 02-12-2016.
 */

public class EventModel {

    private String event, date, lat, lng, place;

    public EventModel() {
    }

    public EventModel(String event, String date, String lat, String lng, String place) {
        this.event = event;
        this.date = date;
        this.lat = lat;
        this.lng = lng;
        this.place = place;
    }

    public String getPlace() {

        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }
}
