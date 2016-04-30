package com.khierblogger.khierbloggerapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.khierblogger.khierbloggerapp.Adapters.SingleOrganizationEventAdapter;
import com.khierblogger.khierbloggerapp.Intefaces.EventCallbacks.EventClickedCallback;
import com.khierblogger.khierbloggerapp.Intefaces.OrganizationCallbacks.SingleOrganizationResponseCallback;
import com.khierblogger.khierbloggerapp.KhierBloggerServer;
import com.khierblogger.khierbloggerapp.MainClasses.Event;
import com.khierblogger.khierbloggerapp.MainClasses.Organization;
import com.khierblogger.khierbloggerapp.R;
import com.khierblogger.khierbloggerapp.Utils;

public class OrganizationActivity extends AppCompatActivity implements EventClickedCallback {

    public static final String ORGANIZATION_IDENTIFIER = "org_id";

    private Organization organization ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organization);

        long organizationId = getIntent().getLongExtra(ORGANIZATION_IDENTIFIER , 0L);
        if (organizationId == 0L)
            throw new IllegalArgumentException("Must pass an Organization identifier to start the activity");

        ImageView imageView = (ImageView) findViewById(R.id.organization_image);
        imageView.setImageResource(organizationId % 2 != 0 ? R.drawable.google : R.drawable.instagram);

        Utils.Log(organizationId + " : is the id");
        KhierBloggerServer.getOrganization(organizationId, new SingleOrganizationResponseCallback() {
            @Override
            public void onOrganizationFetched(final Organization organization) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        OrganizationActivity.this.organization = organization;
                        initViews();
                    }
                });
            }
            @Override
            public void onFailure(String errorMessage) {
                Toast.makeText(OrganizationActivity.this, "Couldn't retrieve organization info", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initViews() {
        final TextView organizationName = (TextView) findViewById(R.id.organization_name);
        organizationName.setText(organization.getName());

        TextView organizationSlogan = (TextView) findViewById(R.id.organization_slogan);
        organizationSlogan.setText(organization.getSlogan());

        TextView subscribers = (TextView) findViewById(R.id.number_of_subscribers);
        subscribers.setText(String.valueOf(organization.getSubscribers().size()));

        TextView events = (TextView) findViewById(R.id.number_of_events);
        events.setText(String.valueOf(organization.getEvents().size()));

        TextView reviews = (TextView) findViewById(R.id.number_of_reviews);
        reviews.setText(String.valueOf(organization.getReviews().size()));

        RecyclerView eventsRecyclerView = (RecyclerView) findViewById(R.id.events_recyclerView);
        eventsRecyclerView.setLayoutManager(new GridLayoutManager(this , 2));
        eventsRecyclerView.setAdapter(new SingleOrganizationEventAdapter(organization.getEvents() , this));

        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.organization_reviews_layout);
        viewGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrganizationActivity.this , ReviewsActivity.class);
                intent.putExtra(ReviewsActivity.REVIEWS_IDENTIFIER , Utils.convertOrganizationReviewsToParcelable(organization.getReviews()));
                intent.putExtra(ReviewsActivity.REVIEWS_TITLE , organization.getName() + " Reviews");
                startActivity(intent);
            }
        });
    }


    @Override
    public void onEventClicked(Event event) {
        Intent intent = new Intent(this , EventActivity.class);
        intent.putExtra(EventActivity.EVENT_IDENTIFIER , event.getId());
        startActivity(intent);
    }
}
