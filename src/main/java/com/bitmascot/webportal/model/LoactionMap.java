package com.bitmascot.webportal.model;

public class LoactionMap {
    private Long id;
    private String city;
    public LoactionMap(String name, String code) {
        this.id = id;
        this.city = city;
    }

    @Override
    public String toString() {
        return id + "=" + city;
    }
}



