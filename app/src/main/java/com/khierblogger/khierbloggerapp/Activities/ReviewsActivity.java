package com.khierblogger.khierbloggerapp.Activities;

import android.os.Parcelable;
import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.khierblogger.khierbloggerapp.Adapters.ReviewsAdapter;
import com.khierblogger.khierbloggerapp.MainClasses.Reviews.BaseReview;
import com.khierblogger.khierbloggerapp.R;
import com.khierblogger.khierbloggerapp.Utils;

import org.parceler.Parcels;

import java.util.ArrayList;

public class ReviewsActivity extends AppCompatActivity {

    public static final String REVIEWS_IDENTIFIER = "reviews_identifier";
    public static final String REVIEWS_TITLE = "title";
    private ArrayList<BaseReview> reviews = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);

        TextView title = (TextView)findViewById(R.id.review_title_textView);
        title.setText(getIntent().getStringExtra(REVIEWS_TITLE));
        ArrayList<Parcelable> parcelables = getIntent().getParcelableArrayListExtra(REVIEWS_IDENTIFIER);

       reviews = Utils.convertParcelableToReviews(parcelables);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.reviews_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ReviewsAdapter(reviews));
    }
}
