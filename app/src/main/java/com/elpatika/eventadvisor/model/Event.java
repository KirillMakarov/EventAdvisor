package com.elpatika.eventadvisor.model;

import java.util.List;

public class Event {
    private long id;
    private String title;
    private String slug;
    private String description; //html
    private String body_text; //html, full description
    private Location location;
    private boolean is_free;
    private List<Image> images;

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSlug() {
        return slug;
    }

    public String getDescription() {
        return description;
    }

    public String getBody_text() {
        return body_text;
    }

    public Location getLocation() {
        return location;
    }

    public boolean is_free() {
        return is_free;
    }

    public List<Image> getImages() {
        return images;
    }
}
