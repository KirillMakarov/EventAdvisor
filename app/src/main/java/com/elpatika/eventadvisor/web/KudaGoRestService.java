package com.elpatika.eventadvisor.web;


import com.elpatika.eventadvisor.model.LocationType;
import com.elpatika.eventadvisor.web.responses.EventsResponse;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface KudaGoRestService {

    @GET("{version}/events/?location=msk&fields=location,title,id,slug,description,is_free,body_text,images&expand=location,images&page_size=100")
    Observable<EventsResponse> getEvents(@Path("version") String version,
                                         @Query("locationType") LocationType locationType);
}
