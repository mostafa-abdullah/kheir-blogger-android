package com.khierblogger.khierbloggerapp.MainClasses;

import com.khierblogger.khierbloggerapp.MainClasses.Reviews.OrganizationReview;

import java.util.ArrayList;
import java.util.Date;

/**
 * Organization model, As seen in website's organization table migration
 */

public class Organization {

    private long id;
    private String name;
    private String email;
    private String password;
    private String bio;
    private String slogan;
    //TODO: ask why is the phone a string, should be an int
    private String phone;
    //TODO: ask why is the location a string, should be longitude and latitude
    private String location;
    private double rate ;
    private Date created_at;
    private Date updated_at;
    private ArrayList<Event> events;
    private ArrayList<OrganizationReview> reviews ;
    private ArrayList<User> subscribers;

    private Organization(long id, String name, String email, String password, String bio, String slogan, String phone, String location,
                        double rate, Date dateCreated, Date dateUpdated , ArrayList<Event> events , ArrayList<OrganizationReview> reviews , ArrayList<User> subscribers) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.bio = bio;
        this.slogan = slogan;
        this.phone = phone;
        this.location = location;
        this.rate = rate;
        this.created_at = dateCreated;
        this.updated_at = dateUpdated;
        this.events = events;
        this.reviews = reviews;
        this.subscribers = subscribers;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getBio() {
        return bio;
    }

    public String getSlogan() {
        return slogan;
    }

    public String getPhone() {
        return phone;
    }

    public String getLocation() {
        return location;
    }

    public double getRate() {
        return rate;
    }

    public Date getDateCreated() {
        return created_at;
    }

    public Date getDateUpdated() {
        return updated_at;
    }

    public ArrayList<Event>getEvents() {
        return events;
    }

    public ArrayList<OrganizationReview> getReviews() {
        return reviews;
    }

    public ArrayList<User> getSubscribers() {
        return subscribers;
    }

}
