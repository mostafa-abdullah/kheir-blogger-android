package com.khierblogger.khierbloggerapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.khierblogger.khierbloggerapp.Intefaces.EventCallbacks.SingleEventCallback;
import com.khierblogger.khierbloggerapp.KhierBloggerServer;
import com.khierblogger.khierbloggerapp.MainClasses.Event;
import com.khierblogger.khierbloggerapp.R;
import com.khierblogger.khierbloggerapp.Utils;

import org.parceler.Parcels;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class EventActivity extends AppCompatActivity implements SingleEventCallback , View.OnClickListener {

    public static final String EVENT_IDENTIFIER = "event_id";
    private Event event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        long eventId = getIntent().getLongExtra(EVENT_IDENTIFIER , 0L);
        if (eventId == 0)
            throw new IllegalArgumentException("Must pass an event identifier to start the event activity");

      KhierBloggerServer.getEvent(eventId , this);

    }

    @Override
    public void onEventFetched(Event event) {
        this.event = event;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                initViews();
            }
        });
    }

    private void initViews() {
        String createdAt = new SimpleDateFormat("HH:mm dd/MM/yyyy").format(event.getDateCreated());
        TextView createdAtText = (TextView) findViewById(R.id.event_created_at_textView);
        createdAtText.setText("Created at : " + createdAt);

        String timing = new SimpleDateFormat("HH:mm dd/MM/yyyy").format(event.getTiming());
        TextView timingText = (TextView) findViewById(R.id.timing);
        timingText.setText("Starts at : " + timing + " in " + event.getLocation());

        TextView nameText = (TextView) findViewById(R.id.event_name);
        nameText.setText(event.getName());

        TextView descriptionText = (TextView) findViewById(R.id.event_description);
        descriptionText.setText(event.getDescription());

        TextView requiredContact = (TextView) findViewById(R.id.required_contact_info);
        requiredContact.setText("Required contact info : " + (event.isContactInfoRequired() ? "Yes" : "No"));

        TextView membershipNeeded= (TextView) findViewById(R.id.needed_membership);
        membershipNeeded.setText("Membership needed : " + (event.isNeedMembership() ? "Yes" : "No"));

        Button eventReviews = (Button) findViewById(R.id.event_reviews_button);
        eventReviews.setOnClickListener(this);
        Button eventPhotos = (Button) findViewById(R.id.event_photos_button);
        eventPhotos.setOnClickListener(this);
        Button eventPosts = (Button) findViewById(R.id.event_posts_button);
        eventPosts.setOnClickListener(this);
        Button eventQuestion = (Button) findViewById(R.id.event_questions_button);
        eventQuestion.setOnClickListener(this);
    }

    @Override
    public void onFailure(String errorMessage) {
        Toast.makeText(EventActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.event_photos_button:
                //TODO
                Toast.makeText(EventActivity.this, "To be implemented", Toast.LENGTH_SHORT).show();
                break;
            case R.id.event_reviews_button:
                Intent intent = new Intent(this , ReviewsActivity.class);

                intent.putExtra(ReviewsActivity.REVIEWS_IDENTIFIER , Utils.convertEventReviewsToParcelable(event.getReviews()));
                intent.putExtra(ReviewsActivity.REVIEWS_TITLE , event.getName() + " Reviews");
                startActivity(intent);
        }
    }
}
