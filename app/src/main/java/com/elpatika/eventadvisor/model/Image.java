package com.elpatika.eventadvisor.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Image implements Parcelable {
    String image;
    Thumbnails thumbnails;

    public String getImage() {
        return image;
    }

    public Thumbnails getThumbnails() {
        return thumbnails;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.image);
        dest.writeParcelable(this.thumbnails, flags);
    }

    public Image() {
    }

    protected Image(Parcel in) {
        this.image = in.readString();
        this.thumbnails = in.readParcelable(Thumbnails.class.getClassLoader());
    }

    public static final Parcelable.Creator<Image> CREATOR = new Parcelable.Creator<Image>() {
        @Override
        public Image createFromParcel(Parcel source) {
            return new Image(source);
        }

        @Override
        public Image[] newArray(int size) {
            return new Image[size];
        }
    };
}
