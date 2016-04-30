package com.khierblogger.khierbloggerapp.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.khierblogger.khierbloggerapp.MainClasses.Reviews.BaseReview;
import com.khierblogger.khierbloggerapp.R;

import java.util.ArrayList;

public class ReviewsAdapter extends RecyclerView.Adapter<ReviewsAdapter.ReviewsViewHolder> {

    private ArrayList<BaseReview> reviews;

    public ReviewsAdapter(ArrayList<BaseReview> reviews) {
        this.reviews = reviews;
    }

    @Override
    public ReviewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ReviewsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_review , parent , false));
    }

    @Override
    public void onBindViewHolder(ReviewsViewHolder holder, int position) {
        BaseReview baseReview = reviews.get(position);
        holder.reviewBody.setText(baseReview.getReview());
        holder.rating.setText(String.valueOf(baseReview.getRate()));
    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }

    static class ReviewsViewHolder extends RecyclerView.ViewHolder{

        TextView reviewerName;
        TextView reviewBody;
        TextView rating;

        public ReviewsViewHolder(View itemView) {
            super(itemView);
            reviewerName = (TextView) itemView.findViewById(R.id.reviewer_name);
            reviewBody = (TextView) itemView.findViewById(R.id.review_body);
            rating = (TextView) itemView.findViewById(R.id.rate);
        }
    }
}
