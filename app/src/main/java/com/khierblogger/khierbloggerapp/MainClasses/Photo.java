package com.khierblogger.khierbloggerapp.MainClasses;

import java.util.Date;

public class Photo {
    private long id;
    private long event_id;
    private String name;
    private String caption;
    private Date created_at;
    private Date updated_at;

    private Photo(long id, long event_id, String name, String caption, Date created_at, Date updated_at) {
        this.id = id;
        this.event_id = event_id;
        this.name = name;
        this.caption = caption;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public long getId() {
        return id;
    }

    public long getEventId() {
        return event_id;
    }

    public String getName() {
        return name;
    }

    public String getCaption() {
        return caption;
    }

    public Date getCreatedAt() {
        return created_at;
    }

    public Date getUpdatedAt() {
        return updated_at;
    }
}
