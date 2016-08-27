package com.elpatika.eventadvisor.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Coords implements Parcelable {
    private double lat;
    private double lon;

    public double getLon() {
        return lon;
    }

    public double getLat() {
        return lat;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(this.lat);
        dest.writeDouble(this.lon);
    }

    public Coords() {
    }

    protected Coords(Parcel in) {
        this.lat = in.readDouble();
        this.lon = in.readDouble();
    }

    public static final Parcelable.Creator<Coords> CREATOR = new Parcelable.Creator<Coords>() {
        @Override
        public Coords createFromParcel(Parcel source) {
            return new Coords(source);
        }

        @Override
        public Coords[] newArray(int size) {
            return new Coords[size];
        }
    };
}
