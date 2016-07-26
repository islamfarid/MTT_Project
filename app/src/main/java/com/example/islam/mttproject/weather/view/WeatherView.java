package com.example.islam.mttproject.weather.view;


import com.example.islam.mttproject.beans.Data;
import com.example.islam.mttproject.beans.WeatherData;
import com.example.islam.mttproject.db.City;

import java.util.List;

/**
 * Created by islam on 7/24/16.
 */
public interface WeatherView {
    void showCities(List<City> cities);
    void showWeather(WeatherData data);
    void hideProgress();
    void showProgress();
    void showErrorMEssage(String message);
}
