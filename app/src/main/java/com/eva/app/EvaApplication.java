package com.eva.app;

import android.app.Application;
import de.greenrobot.event.EventBus;

/**
 * Created by dell on 6/8/2015.
 */
public class EvaApplication extends Application {

    private EventBus eventBus;

    // APPLICATION INSTANCE
    private static EvaApplication instance;

    public EvaApplication() {
        instance = this;
    }

    public static EvaApplication getInstance() {
        return instance;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        _initEventBus();
    }

    private void _initEventBus() {
        this.eventBus = EventBus.builder()
                .logNoSubscriberMessages(false)
                .sendNoSubscriberEvent(false)
                .build();
    }

    public EventBus getEventBus() {
        return eventBus;
    }

}
