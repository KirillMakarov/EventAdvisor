package com.elpatika.eventadvisor.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Thumbnails implements Parcelable {
    @SerializedName("144x96")
    private String small;
    @SerializedName("640x384")
    private String large;

    public String getSmall() {
        return small;
    }

    public String getLarge() {
        return large;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.small);
        dest.writeString(this.large);
    }

    public Thumbnails() {
    }

    protected Thumbnails(Parcel in) {
        this.small = in.readString();
        this.large = in.readString();
    }

    public static final Parcelable.Creator<Thumbnails> CREATOR = new Parcelable.Creator<Thumbnails>() {
        @Override
        public Thumbnails createFromParcel(Parcel source) {
            return new Thumbnails(source);
        }

        @Override
        public Thumbnails[] newArray(int size) {
            return new Thumbnails[size];
        }
    };
}
