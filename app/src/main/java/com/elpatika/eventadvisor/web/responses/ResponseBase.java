package com.elpatika.eventadvisor.web.responses;

import android.support.annotation.Nullable;

public class ResponseBase {
    private long count;
    private String next;
    private String previous;

    public long getCount() {
        return count;
    }

    @Nullable
    public String getNext() {
        return next;
    }

    @Nullable
    public String getPrevious() {
        return previous;
    }
}
