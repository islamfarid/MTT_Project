package com.example.islam.mttproject.network;

import com.example.islam.mttproject.beans.Data;
import com.example.islam.mttproject.beans.WeatherData;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by islam on 7/25/16.
 */
public interface WorldWeatherOnlineClient {
    @GET("weather.ashx")
    Observable<WeatherData> weatherData(@QueryMap Map<String, String> params);
}
