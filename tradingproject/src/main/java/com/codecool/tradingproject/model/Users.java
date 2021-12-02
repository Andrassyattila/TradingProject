package com.codecool.tradingproject.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
public class Users {
    @GeneratedValue
    @Id
    private Long id;
    private String firstName;
    private String surName;
    private String username;
    private String password;
    private String postcode;
    private String city;
    private String email;
    private String phoneNumber;
    private float rating=0;
    private int ratingcounter=0;
    private String role = "USER";
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "usersid")
    private List<Product> products;



    public Users(){}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String lastName) {
        this.surName = lastName;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postCode) {
        this.postcode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String userroles) {
        this.role = userroles;
    }

    public Long getId() {
        return id;
    }

    public int getRatingcounter() {
        return ratingcounter;
    }

    public void setRatingcounter(int ratingcounter) {
        this.ratingcounter = ratingcounter;
    }
}
