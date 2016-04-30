package com.khierblogger.khierbloggerapp.MainClasses.Reviews;


import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

import java.util.Date;

@Parcel
public class OrganizationReview extends BaseReview {

    @SerializedName("organization_id")
    private long organizationId;

    @ParcelConstructor
    public OrganizationReview(long id, long userId , long organizationId, String review, int rate, Date createdAt, Date updatedAt) {
        super(id, userId, review, rate, createdAt, updatedAt);
        this.organizationId = organizationId;
    }

    public long getOrganizationId() {
        return organizationId;
    }

}
