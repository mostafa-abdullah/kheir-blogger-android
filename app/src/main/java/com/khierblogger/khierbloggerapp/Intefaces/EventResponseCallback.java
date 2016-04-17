package com.khierblogger.khierbloggerapp.Intefaces;

import com.khierblogger.khierbloggerapp.MainClasses.Event;

import java.util.ArrayList;

public interface EventResponseCallback extends BaseCallback {
    void onEventFetched(ArrayList<Event> events);
}
