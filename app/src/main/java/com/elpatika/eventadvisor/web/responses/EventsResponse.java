package com.elpatika.eventadvisor.web.responses;

import com.elpatika.eventadvisor.model.Event;

import java.util.List;

public class EventsResponse extends ResponseBase {
    private List<Event> results;

    public List<Event> getResults() {
        return results;
    }
}
