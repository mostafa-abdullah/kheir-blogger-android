package com.khierblogger.khierbloggerapp.MainClasses.Reviews;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

import java.util.Date;

@Parcel
public class EventReview extends BaseReview{

    @SerializedName("event_id")
    private long eventId;

    @ParcelConstructor
    public EventReview(long id, long userId , long eventId, String review, int rate, Date createdAt, Date updatedAt) {
        super(id, userId, review, rate, createdAt, updatedAt);
        this.eventId = eventId;
    }

    public long geteventId() {
        return eventId;
    }
}
