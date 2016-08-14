package com.elpatika.eventadvisor.model;

import com.google.gson.annotations.SerializedName;

public class Thumbnails {
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
}
