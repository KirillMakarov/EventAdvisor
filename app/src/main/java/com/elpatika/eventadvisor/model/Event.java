package com.elpatika.eventadvisor.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Event implements Parcelable {

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.title);
        dest.writeString(this.slug);
        dest.writeString(this.description);
        dest.writeString(this.body_text);
        dest.writeParcelable(this.location, flags);
        dest.writeByte(this.is_free ? (byte) 1 : (byte) 0);
        dest.writeTypedList(this.images);
        dest.writeString(this._title);
    }

    public Event() {
    }

    protected Event(Parcel in) {
        this.id = in.readLong();
        this.title = in.readString();
        this.slug = in.readString();
        this.description = in.readString();
        this.body_text = in.readString();
        this.location = in.readParcelable(Location.class.getClassLoader());
        this.is_free = in.readByte() != 0;
        this.images = in.createTypedArrayList(Image.CREATOR);
        this._title = in.readString();
    }

    public static final Parcelable.Creator<Event> CREATOR = new Parcelable.Creator<Event>() {
        @Override
        public Event createFromParcel(Parcel source) {
            return new Event(source);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };
}
