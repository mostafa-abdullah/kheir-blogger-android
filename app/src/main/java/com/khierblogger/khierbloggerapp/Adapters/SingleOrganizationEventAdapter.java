package com.khierblogger.khierbloggerapp.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.khierblogger.khierbloggerapp.Intefaces.EventCallbacks.EventClickedCallback;
import com.khierblogger.khierbloggerapp.MainClasses.Event;
import com.khierblogger.khierbloggerapp.R;

import java.util.ArrayList;

public class SingleOrganizationEventAdapter extends RecyclerView.Adapter<SingleOrganizationEventAdapter.EventViewHolder>{

    private ArrayList<Event> events ;
    private EventClickedCallback callback;

    public SingleOrganizationEventAdapter(ArrayList<Event> events , EventClickedCallback callback){
        this.events = events;
        this.callback = callback;
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new EventViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_organization_event , parent , false));
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
        final Event event = events.get(position);
        holder.eventName.setText(event.getName());
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onEventClicked(event);
            }
        });
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    static class EventViewHolder extends RecyclerView.ViewHolder{

        ImageView eventImageView;
        TextView eventName;
        ViewGroup mainLayout;

        public EventViewHolder(View itemView) {
            super(itemView);
            eventImageView = (ImageView) itemView.findViewById(R.id.event_image);
            eventName =(TextView) itemView.findViewById(R.id.event_name);
            mainLayout = (ViewGroup) itemView.findViewById(R.id.main_layout);
        }
    }
}
