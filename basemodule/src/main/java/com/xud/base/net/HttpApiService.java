package com.xud.base.net;

import java.util.Map;

import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by xud on 2018/3/25.
 */

public interface HttpApiService {

    @GET
    Observable<Object> getFromHttpServer(@Url String interfaceUrl, @QueryMap Map<String, Object> options);

    @POST
    Observable<Object> postFromHttpServer(@Url String interfaceUrl, @Body Map<String, Object> options);

    @PUT
    Observable<Object> putFromHttpServer(@Url String interfaceUrl, @Body Map<String, Object> options);

    @DELETE
    Observable<Object> deleteFromHttpServer(@Url String interfaceUrl);

    @GET
    Observable<Void> getFromHttpServerVoid(@Url String interfaceUrl, @QueryMap Map<String, Object> options);

    @POST
    Observable<Void> postFromHttpServerVoid(@Url String interfaceUrl, @Body Map<String, Object> options);

    @PUT
    Observable<Void> putFromHttpServerVoid(@Url String interfaceUrl, @Body Map<String, Object> options);

    @DELETE
    Observable<Void> deleteFromHttpServerVoid(@Url String interfaceUrl);
}


