package com.khierblogger.khierbloggerapp.MainClasses.Reviews;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

import java.util.Date;

@Parcel
public class BaseReview {

    protected long id ;
    @SerializedName("user_id")
    protected long userId;
    protected String review ;
    protected int rate;
    @SerializedName("created_at")
    protected Date createdAt;
    @SerializedName("updated_at")
    protected Date updatedAt;

    @ParcelConstructor
    public BaseReview(long id, long userId, String review, int rate, Date createdAt, Date updatedAt) {
        this.id = id;
        this.userId = userId;
        this.review = review;
        this.rate = rate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public String getReview() {
        return review;
    }

    public int getRate() {
        return rate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }
}
