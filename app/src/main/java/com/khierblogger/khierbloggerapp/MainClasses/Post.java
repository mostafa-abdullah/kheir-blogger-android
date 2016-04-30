package com.khierblogger.khierbloggerapp.MainClasses;

import java.util.Date;

public class Post {

    private long id;
    private long event_id;
    private long organization_id;
    private String title;
    private String description;
    private Date created_at;
    private Date updated_at;
    private Date deleted_at;

    private Post(long id, long event_id, long organization_id, String title, String description, Date created_at, Date updated_at, Date deleted_at) {
        this.id = id;
        this.event_id = event_id;
        this.organization_id = organization_id;
        this.title = title;
        this.description = description;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.deleted_at = deleted_at;
    }

    public long getId() {
        return id;
    }

    public long getEventId() {
        return event_id;
    }

    public long getOrganizationId() {
        return organization_id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getCreatedAt() {
        return created_at;
    }

    public Date getUpdatedAt() {
        return updated_at;
    }

    public Date getDeletedAt() {
        return deleted_at;
    }
}
