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
    private String _title = null;

    public long getId() {
        return id;
    }

    public String getTitle() {
        if (_title == null) {
            if (title == null || title.isEmpty()) {
                return "";
            }
            _title = Character.toUpperCase(title.charAt(0)) + title.substring(1);
        }
        return _title;
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
