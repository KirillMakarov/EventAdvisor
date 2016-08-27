package com.elpatika.eventadvisor.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Location implements Parcelable {
    private String slug;
    private String name;
    private Coords coords;

    public String getSlug() {
        return slug;
    }

    public String getName() {
        return name;
    }

    public Coords getCoords() {
        return coords;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.slug);
        dest.writeString(this.name);
        dest.writeParcelable(this.coords, flags);
    }

    public Location() {
    }

    protected Location(Parcel in) {
        this.slug = in.readString();
        this.name = in.readString();
        this.coords = in.readParcelable(Coords.class.getClassLoader());
    }

    public static final Parcelable.Creator<Location> CREATOR = new Parcelable.Creator<Location>() {
        @Override
        public Location createFromParcel(Parcel source) {
            return new Location(source);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };
}
