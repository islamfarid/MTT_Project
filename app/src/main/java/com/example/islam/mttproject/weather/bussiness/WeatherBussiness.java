package com.example.islam.mttproject.weather.bussiness;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;

import com.example.islam.mttproject.application.MTTApplication;
import com.example.islam.mttproject.beans.Data;
import com.example.islam.mttproject.beans.WeatherData;
import com.example.islam.mttproject.common.Constants;
import com.example.islam.mttproject.db.City;
import com.example.islam.mttproject.db.CityDao;
import com.example.islam.mttproject.db.DaoMaster;
import com.example.islam.mttproject.db.DaoSession;
import com.example.islam.mttproject.db.manager.DbManager;
import com.example.islam.mttproject.network.ServiceGenerator;
import com.example.islam.mttproject.network.WorldWeatherOnlineClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func0;
import rx.schedulers.Schedulers;

/**
 * Created by islam on 7/24/16.
 */
public class WeatherBussiness {
    private boolean isFirstTimeToOpenTheApp = false;
    Context context;
    @Inject
    DbManager dbManager;

    /**
     * for testing
     */
    public WeatherBussiness() {

    }

    /**
     * the weather bussiness constructor will check if the app is opened
     * for the first time or not in order to set the default cites
     *
     * @param context
     */
    @Inject
    public WeatherBussiness(Context context) {
        this.context = context;
        MTTApplication.getInstance().getApplicationComponent().inject(this);
        SharedPreferences pref = context.getApplicationContext().getSharedPreferences(Constants.MTT_PREFERENCE_NAME, context.MODE_PRIVATE);
        isFirstTimeToOpenTheApp = pref.getBoolean(Constants.APP_IS_OPENED_FOR_THE_FIRST_TIME, true);
        if (isFirstTimeToOpenTheApp) {
            SharedPreferences.Editor editor = pref.edit();
            editor.putBoolean(Constants.APP_IS_OPENED_FOR_THE_FIRST_TIME, false);
            editor.commit();
            saveCities(prepareDefaultCities())
                    .subscribe();
        }
    }

    public Observable saveCities(ArrayList<City> cities) {
        return Observable.create(
                subscriber -> {
                    dbManager.addCities(cities);
                    subscriber.onNext(true);
                    subscriber.onCompleted();
                });
    }

    public Observable<Object> saveCity(String cityName) {
        return Observable.create(
                subscriber -> {
                    City city = new City();
                    city.setCityName(cityName);
                    dbManager.newCity(city);
                    subscriber.onNext(true);
                    subscriber.onCompleted();
                });
    }

    public Observable<List<City>> getAllCities() {

        Observable<List<City>> observable = Observable.create(new Observable.OnSubscribe<List<City>>() {
            @Override
            public void call(Subscriber<? super List<City>> sub) {
                List<City> allCities = dbManager.loadAllCities();
                sub.onNext(allCities);
                sub.onCompleted();
            }
        });
        return observable;
    }

    public Observable<Object> removeCity(City city) {
        return Observable.create(
                subscriber -> {
                    dbManager.removeCity(city);
                    subscriber.onNext(true);
                    subscriber.onCompleted();
                });
    }

    public Observable<WeatherData> getWeatherData(City city) {
        HashMap<String, String> queryMap = new HashMap<>();
        queryMap.put("key", Constants.API_KEY);
        queryMap.put("q", city.getCityName());
        queryMap.put("num_of_days", String.valueOf(5));
        queryMap.put("format", "json");
        return ServiceGenerator.createService(WorldWeatherOnlineClient.class).weatherData(queryMap);
    }

    private ArrayList<City> prepareDefaultCities() {
        ArrayList<City> cities = new ArrayList<>();
        City dublinCity = new City();
        dublinCity.setCityName("Dublin");
        cities.add(dublinCity);
        City londonCity = new City();
        londonCity.setCityName("London");
        cities.add(londonCity);
        City newYorkCity = new City();
        newYorkCity.setCityName("New York");
        cities.add(newYorkCity);
        City barcelonaCity = new City();
        barcelonaCity.setCityName("Barcelona");
        cities.add(barcelonaCity);
        return cities;
    }
}
