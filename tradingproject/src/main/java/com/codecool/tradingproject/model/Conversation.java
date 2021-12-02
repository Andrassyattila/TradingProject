package com.codecool.tradingproject.model;

import javax.persistence.*;

@Entity
public class Conversation {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Users userA;
    @ManyToOne
    private Users userB;


    public Users getUserA() {
        return userA;
    }

    public void setUserA(Users userA) {
        this.userA = userA;
    }

    public Users getUserB() {
        return userB;
    }

    public void setUserB(Users userB) {
        this.userB = userB;
    }
}
