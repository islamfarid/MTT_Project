package com.example.islam.mttproject.weather.presenter;

import android.support.test.InstrumentationRegistry;

import com.example.islam.mttproject.beans.WeatherData;
import com.example.islam.mttproject.db.City;
import com.example.islam.mttproject.weather.bussiness.WeatherBussiness;
import com.example.islam.mttproject.weather.view.WeatherView;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by islam on 7/26/16.
 */

/**
 * as the app is adb and network so we will only make sure that we call methods in a right way
 */
public class WeatherPresenterTest {
    public WeatherPresenterTest() {
    }
    WeatherBussiness weatherBussiness;
WeatherView weatherView;
    WeatherPresenter weatherPresenter;

    @Before
    public void init() {
        System.setProperty("dexmaker.dexcache", InstrumentationRegistry.getInstrumentation().getTargetContext().getCacheDir().getPath());
        weatherPresenter = new WeatherPresenter();
        weatherBussiness = mock(WeatherBussiness.class);
        weatherView = mock(WeatherView.class);
        weatherPresenter.setWeatherBussiness(weatherBussiness);
    }

    @Test
    public void testAfterLoadCities_CitiesAreDisplayed() throws Exception {
        List<City> cities = new ArrayList<>();
        when(weatherBussiness.getAllCities()).thenReturn(Observable.create((Observable.OnSubscribe<List<City>>) sub -> {
            sub.onNext(cities);
            sub.onCompleted();
            verify(weatherView, times(1)).showCities(cities);
        }));
        weatherPresenter.loadCities();
        verify(weatherBussiness, times(1)).getAllCities();
    }
    @Test
    public void testAfterLoadCitiesError_ErrorMessageISDisplayed() throws Exception {
        when(weatherBussiness.getAllCities()).thenReturn(Observable.create((Observable.OnSubscribe<List<City>>) sub -> {
            sub.onError(new Error());
            verify(weatherView, times(1)).showErrorMEssage(null);
        }));
        weatherPresenter.loadCities();
        verify(weatherBussiness, times(1)).getAllCities();
    }

    @Test
    public void testAfterAddingCity_CitiesListAreRefreshed() throws Exception {
        when(weatherBussiness.getAllCities()).thenReturn(Observable.create((Observable.OnSubscribe<List<City>>) sub -> {
            sub.onNext(null);
            sub.onCompleted();
            verify(weatherView, times(1)).showCities(null);
        }));
        when(weatherBussiness.saveCity(null)).thenReturn(Observable.create(
                subscriber -> {
                    subscriber.onNext(null);
                    subscriber.onCompleted();
                }));
        weatherPresenter.addCity(null);
        verify(weatherBussiness, times(1)).saveCity(null);
    }

    @Test
    public void testRemoveCity() throws Exception {
        String cityName = "Dublin";
        when(weatherBussiness.getAllCities()).thenReturn(Observable.create((Observable.OnSubscribe<List<City>>) sub -> {
            sub.onNext(null);
            sub.onCompleted();
            verify(weatherView, times(1)).showCities(null);
        }));
        when(weatherBussiness.removeCity(null)).thenReturn(Observable.create(
                subscriber -> {
                    subscriber.onNext(null);
                    subscriber.onCompleted();
                }));
        weatherPresenter.removeCity(null);
        verify(weatherBussiness, times(1)).removeCity(null);
    }

    @Test
    public void testGetWeather_WeatherIsDisplayed() throws Exception {
        City dublinCity = new City();
        when(weatherBussiness.getWeatherData(dublinCity)).thenReturn(Observable.create((Observable.OnSubscribe<WeatherData>) sub -> {
            sub.onNext(null);
            sub.onCompleted();
            verify(weatherView, times(1)).showWeather(null);
        }));
        weatherPresenter.getWeather(dublinCity);
        verify(weatherBussiness, times(1)).getWeatherData(dublinCity);
    }
    @Test
    public void testGetWeatherWrror_ErrorMEssageIsDisplayed() throws Exception {
        City dublinCity = new City();
        when(weatherBussiness.getWeatherData(dublinCity)).thenReturn(Observable.create((Observable.OnSubscribe<WeatherData>) sub -> {
            sub.onError(new Error());
            verify(weatherView, times(1)).showErrorMEssage(null);
        }));
        weatherPresenter.getWeather(dublinCity);
        verify(weatherBussiness, times(1)).getWeatherData(dublinCity);
    }
}