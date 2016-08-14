package com.elpatika.eventadvisor.web;


import com.elpatika.eventadvisor.web.responses.EventsResponse;

import rx.Observable;

public interface Api {
    Observable<EventsResponse> getEvents();
}
