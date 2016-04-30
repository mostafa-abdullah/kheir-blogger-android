package com.khierblogger.khierbloggerapp.Intefaces.EventCallbacks;

import com.khierblogger.khierbloggerapp.Intefaces.BaseCallback;
import com.khierblogger.khierbloggerapp.MainClasses.Event;

public interface SingleEventCallback extends BaseCallback {
    void onEventFetched(Event event);
}
