package com.codecool.tradingproject.model;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Product {
    @GeneratedValue
    @Id
    private Long id;
    private String title;
    private String description;
    private String image;
    private String prefPrice;
    private Date publicationDate= new Date(System.currentTimeMillis());
    private boolean authorized;
    @OneToMany
    private List<Categories> interested;
    @ManyToOne
    private Users users;

    public Product(){}

    public Product(String title, String description, String image, String prefPrice, boolean authorized, List<Categories> interested,  Users users ,Date publicationDate) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.prefPrice = prefPrice;
        this.authorized = authorized;
        this.interested = interested;

        this.users = users;
        this.publicationDate=publicationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getPrefPrice() {
        return prefPrice;
    }

    public void setPrefPrice(String prefPrice) {
        this.prefPrice = prefPrice;
    }

    public boolean isAuthorized() {
        return authorized;
    }

    public void setAuthorized(boolean authorized) {
        this.authorized = authorized;
    }

    public List<Categories> getInterested() {
        return interested;
    }

    public void setInterested(List<Categories> interested) {
        this.interested = interested;
    }
    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public Long getId() {
        return id;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }
}
