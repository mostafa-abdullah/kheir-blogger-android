package com.khierblogger.khierbloggerapp.MainClasses;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

import java.util.Date;

public class User {

    private long id;
    private String first_name;
    private String last_name;
    private Date birth_date;
    private String phone;
    private String address;
    private String city;
    private String email;
    private String password;
    private String remember_token;
    private Date created_at;
    private Date updated_at;
    private int role;
    private Pivot pivot;

    private User(long id, String firstName, String lastName, Date birthDate, String phone, String address, String city, String email, String password, String rememberToken, Date createdAt, Date updatedAt, int role , Pivot pivot) {
        this.id = id;
        this.first_name = firstName;
        this.last_name = lastName;
        this.birth_date = birthDate;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.email = email;
        this.password = password;
        this.remember_token = rememberToken;
        this.created_at = createdAt;
        this.updated_at = updatedAt;
        this.role = role;
        this.pivot= pivot;
    }


    @Parcel(Parcel.Serialization.BEAN)
    public static class Pivot{

        private long organization_id;
        private long user_id;
        private Date created_at;
        private Date updated_at;

        @ParcelConstructor
        public Pivot(long organizationId, long userId, Date createdAt, Date updatedAt) {
            this.organization_id = organizationId;
            this.user_id = userId;
            this.created_at = createdAt;
            this.updated_at = updatedAt;
        }

        public long getOrganizationId() {
            return organization_id;
        }

        public long getUserId() {
            return user_id;
        }

        public Date getCreatedAt() {
            return created_at;
        }

        public Date getUpdatedAt() {
            return updated_at;
        }
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public Date getBirthDate() {
        return birth_date;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRememberToken() {
        return remember_token;
    }

    public Date getCreatedAt() {
        return created_at;
    }

    public Date getUpdatedAt() {
        return updated_at;
    }

    public int getRole() {
        return role;
    }

    public Pivot getPivot() {
        return pivot;
    }
}
