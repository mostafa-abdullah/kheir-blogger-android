package com.khierblogger.khierbloggerapp.MainClasses;

import java.util.Date;

public class Event {
    private long id;
    private String name ;
    private long organizationId;
    private String description ;
    private Date timing ;
    private String location ;
    private int required_contact_info;
    private int needed_membership;
    private double rate;
    private Date created_at;
    private Date updated_at;
    private Date deleted_at;

    private Event(long id, String name, long organizationId, String description, Date timing, String location, int contactInfoRequired, int needMembership, double rate, Date dateCreated, Date dateUpdated, Date dateDeleted) {
        this.id = id;
        this.name = name;
        this.organizationId = organizationId;
        this.description = description;
        this.timing = timing;
        this.location = location;
        this.required_contact_info = contactInfoRequired;
        this.needed_membership = needMembership;
        this.rate = rate;
        this.created_at = dateCreated;
        this.updated_at = dateUpdated;
        this.deleted_at = dateDeleted;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getOrganizationId() {
        return organizationId;
    }

    public String getDescription() {
        return description;
    }

    public Date getTiming() {
        return timing;
    }

    public String getLocation() {
        return location;
    }

    public boolean isContactInfoRequired() {
        return required_contact_info == 1 ;
    }

    public boolean isNeedMembership() {
        return needed_membership == 1;
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

    public Date getDateDeleted() {
        return deleted_at;
    }
}
