package com.codecool.tradingproject.model;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Advertise2 {


    public long id;

    public int prefprice;
    public String title;
    public String description;
    public String url;

    public Advertise2(long id, String title, String description,int prefprice, String url) {
        this.id=id;
        this.title=title;
        this.description=description;
        this.prefprice=prefprice;
        this.url=url;
    }

    public Advertise2() {

    }
}

