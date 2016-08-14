package com.elpatika.eventadvisor.web;

import com.elpatika.eventadvisor.model.LocationType;
import com.elpatika.eventadvisor.web.responses.EventsResponse;

import javax.inject.Singleton;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

@Singleton
public class ApiImpl implements Api {

    private static final String WEB_URL = "https://kudago.com/public-api/";// TODO: 14.08.16 move to configs, web url can be splitted to test and production
    private static final String DEFAULT_VERSION = "v1.3";// TODO: 14.08.16 move to configs
    private KudaGoRestService webService;

    public ApiImpl() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WEB_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        webService = retrofit.create(KudaGoRestService.class);
    }

    @Override
    public Observable<EventsResponse> getEvents() {
        // TODO: 14.08.16 pagination
        return webService.getEvents(DEFAULT_VERSION, LocationType.msk);
    }
}
