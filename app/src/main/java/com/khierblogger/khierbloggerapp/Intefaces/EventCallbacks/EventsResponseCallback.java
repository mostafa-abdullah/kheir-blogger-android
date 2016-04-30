package com.khierblogger.khierbloggerapp.Intefaces.EventCallbacks;

import com.khierblogger.khierbloggerapp.Intefaces.BaseCallback;
import com.khierblogger.khierbloggerapp.MainClasses.Event;

import java.util.ArrayList;

public interface EventsResponseCallback extends BaseCallback {
    void onEventsFetched(ArrayList<Event> events);
}
