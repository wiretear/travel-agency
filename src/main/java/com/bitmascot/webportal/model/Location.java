package com.bitmascot.webportal.model;

import javax.persistence.*;

@Entity
@Table(name="location")
public class Location {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="city")
    private String city;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return city;
    }

    public void setFirstName(String firstName) {
        this.city = firstName;
    }
    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", city='" + city + '\'' + '}';
    }



}
