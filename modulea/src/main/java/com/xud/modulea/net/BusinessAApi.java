package com.xud.modulea.net;

import com.xud.modulea.entity.CityWeatherDTO;
import com.xud.modulea.entity.ProvinceDTO;
import com.xud.modulea.entity.RestResultDTO;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by xud on 2018/3/25.
 */

public interface BusinessAApi {

    @GET("/v1/weather/citys")
    Observable<RestResultDTO<ProvinceDTO>> getSupportCitys(@Query("key") String mobAppKey);

    @GET("/v1/weather/query")
    Observable<RestResultDTO<CityWeatherDTO>> getCityWeather(@Query("key") String mobAppKey, @Query("province") String province, @Query("city") String city);

}
