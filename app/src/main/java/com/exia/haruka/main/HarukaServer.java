package com.exia.haruka.main;

import com.exia.haruka.bean.WeatherBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface HarukaServer {

//    http://t.weather.sojson. com/api/weather/city/ city_code

    @GET("api/weather/city/{code}")
    Observable<WeatherBean> getWeatherData(@Path("code") String cityCode);

}

