package com.codecool.tradingproject.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Message {
    @GeneratedValue
    @Id
    private Long id;
    @ManyToOne
    private Users author;
    private Date messageSent= new Date(System.currentTimeMillis());
    @Column(length=2000)
    private String messages;
    private boolean seen=false;
    @OneToOne
    private Conversation conversation;

    public Long getId() {
        return id;
    }

    public Users getAuthor() {
        return author;
    }

    public void setAuthor(Users author) {
        this.author = author;
    }

    public Date getMessageSent() {
        return messageSent;
    }

    public void setMessageSent(Date messageSent) {
        this.messageSent = messageSent;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public boolean isSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }
}
