package com.khierblogger.khierbloggerapp.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.khierblogger.khierbloggerapp.Adapters.VolunteerEventsAdapter;
import com.khierblogger.khierbloggerapp.R;

public class VolunteerProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_profile);

        GridView gridView = (GridView) findViewById(R.id.grid_view);

        // The array of events to be displayed.
        Integer[] events = {R.drawable.google, R.drawable.google, R.drawable.google, R.drawable.google,
                R.drawable.google, R.drawable.google, R.drawable.google, R.drawable.google,
                R.drawable.google, R.drawable.google, R.drawable.google};
        gridView.setAdapter(new VolunteerEventsAdapter(this, events));
    }
}
