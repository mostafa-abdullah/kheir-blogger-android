package com.khierblogger.khierbloggerapp.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class VolunteerEventsAdapter extends BaseAdapter {
    private Context context;
    private Integer events[];

    public VolunteerEventsAdapter(Context context, Integer events[]) {
        this.context = context;
        this.events = events;
    }

    @Override
    public int getCount() {
        return events.length;
    }

    @Override
    public Object getItem(int i) {
        return events[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(events[i]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(70, 70));
        return imageView;
    }
}
