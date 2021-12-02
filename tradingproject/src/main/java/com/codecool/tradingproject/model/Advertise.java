package com.codecool.tradingproject.model;


import javax.persistence.*;

@Entity
public class Advertise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    public Advertise(int id, String title, String description) {
    }

    public Advertise() {

    }
}

