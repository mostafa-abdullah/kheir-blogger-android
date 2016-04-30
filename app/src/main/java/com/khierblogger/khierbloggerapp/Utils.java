package com.khierblogger.khierbloggerapp;

import android.os.Parcelable;
import android.util.Log;

import com.khierblogger.khierbloggerapp.MainClasses.Reviews.BaseReview;
import com.khierblogger.khierbloggerapp.MainClasses.Reviews.EventReview;
import com.khierblogger.khierbloggerapp.MainClasses.Reviews.OrganizationReview;

import org.parceler.Parcels;

import java.util.ArrayList;

/**
 * A convenience class to log and do test work.<br/>
 * It will be deleted once we finish the app.
 */

public class Utils {

    public static void Log(Object o){
        Log.i("test" , o+"");
    }


    public static ArrayList<Parcelable> convertEventReviewsToParcelable(ArrayList<EventReview> reviews){
        ArrayList<Parcelable> parcelables = new ArrayList<>(reviews.size());
        for (int i = 0; i < reviews.size(); i++)
            parcelables.add(Parcels.wrap(reviews.get(i)));

        return parcelables;
    }

    public static ArrayList<Parcelable> convertOrganizationReviewsToParcelable(ArrayList<OrganizationReview> reviews){
        ArrayList<Parcelable> parcelables = new ArrayList<>(reviews.size());
        for (int i = 0; i < reviews.size(); i++)
            parcelables.add(Parcels.wrap(reviews.get(i)));

        return parcelables;
    }

    public static ArrayList<BaseReview> convertParcelableToReviews(ArrayList<Parcelable> parcelables){
        ArrayList<BaseReview> reviews = new ArrayList<>(parcelables.size());
        for (int i = 0; i < parcelables.size(); i++)
            reviews.add((BaseReview)Parcels.unwrap(parcelables.get(i)));

        return reviews;
    }
}
