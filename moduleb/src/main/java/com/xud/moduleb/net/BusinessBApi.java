package com.xud.moduleb.net;

import com.xud.moduleb.entity.CityEnvironmentDTO;
import com.xud.moduleb.entity.RestResultDTO;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by xud on 2018/3/25.
 */

public interface BusinessBApi {

    @GET("/environment/query")
    Observable<RestResultDTO<CityEnvironmentDTO>> getCityWeather(@Query("key") String mobAppKey, @Query("province") String province, @Query("city") String city);

}
