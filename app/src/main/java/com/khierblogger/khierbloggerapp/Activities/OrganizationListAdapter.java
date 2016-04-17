package com.khierblogger.khierbloggerapp.Activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.khierblogger.khierbloggerapp.MainClasses.Organization;
import com.khierblogger.khierbloggerapp.R;


public class OrganizationListAdapter extends ArrayAdapter<Organization> {
    public OrganizationListAdapter(Context context, Organization[] orgs) {
        super(context, R.layout.cutom_organization, orgs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater myInflater= LayoutInflater.from(getContext());
        View customView = myInflater.inflate(R.layout.cutom_organization, parent, false);

        Organization org = getItem(position);
        TextView organizationTitle = (TextView) customView.findViewById(R.id.organizationTitle);
        ImageView organizationLogo = (ImageView) customView.findViewById(R.id.organizationLogo);
        RatingBar organizationRating = (RatingBar) customView.findViewById(R.id.organizationRatingBar);
        TextView organizationDescription = (TextView) customView.findViewById(R.id.organizationDescription);

        organizationTitle.setText(org.getName());
        organizationDescription.setText(org.getBio());
        organizationRating.setNumStars(5);
        organizationRating.setRating((float)org.getRate());
        organizationLogo.setImageResource(R.drawable.user);

        return customView;
    }
}
