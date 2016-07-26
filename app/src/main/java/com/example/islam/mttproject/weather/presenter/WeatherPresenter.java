package com.example.islam.mttproject.weather.presenter;


import com.example.islam.mttproject.application.MTTApplication;
import com.example.islam.mttproject.beans.WeatherData;
import com.example.islam.mttproject.util.log.Logger;
import com.example.islam.mttproject.db.City;
import com.example.islam.mttproject.weather.bussiness.WeatherBussiness;
import com.example.islam.mttproject.weather.view.WeatherView;

import java.lang.ref.WeakReference;
import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by islam on 7/24/16.
 */
public class WeatherPresenter {
    WeakReference<WeatherView> weatherView;
    @Inject
    WeatherBussiness weatherBussiness;
    Subscription subscription;

    public void setView(WeatherView weatherView) {
        MTTApplication.getInstance().getApplicationComponent().inject(this);
        this.weatherView = new WeakReference(weatherView);
    }

    public void loadCities() {
        subscription = weatherBussiness.getAllCities().subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).unsubscribeOn(AndroidSchedulers.
                mainThread()).subscribe(new Subscriber<List<City>>() {
            @Override
            public void onCompleted() {
                Logger.i("getCities Completed for the city");

            }

            @Override
            public void onError(Throwable e) {
                Logger.e("getCities Completed for the city" + e.getMessage());
                if (isViewAttached()) {
                    weatherView.get().showErrorMEssage(e.getMessage());
                }
            }

            @Override
            public void onNext(List<City> cities) {
                Logger.i("getCities OnNext for the city");
                if (isViewAttached()) {
                    weatherView.get().showCities(cities);
                    cities = cities;
                }
            }
        });
    }

    public void addCity(String city) {
        weatherBussiness.saveCity(city).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnCompleted(() -> loadCities())
                .subscribe();
    }

    public void removeCity(City city) {
        weatherBussiness.removeCity(city).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnCompleted(() -> loadCities())
                .subscribe();
        ;
    }

    public void getWeather(City city) {
        if (isViewAttached()) {
            weatherView.get().showProgress();
        }
        weatherBussiness.getWeatherData(city).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.
                mainThread()).subscribe(new Subscriber<WeatherData>() {
            @Override
            public void onCompleted() {
                Logger.i("getWeather completed !");
                if (isViewAttached()) {
                    weatherView.get().hideProgress();
                }
            }

            @Override
            public void onError(Throwable e) {
                if (isViewAttached()) {
                    weatherView.get().showErrorMEssage(e.getMessage());
                    weatherView.get().hideProgress();
                }
            }

            @Override
            public void onNext(WeatherData data) {
                if (isViewAttached()) {
                    weatherView.get().showWeather(data);
                }
            }
        });
    }

    private boolean isViewAttached() {
        return weatherView != null && weatherView.get() != null;
    }

    public void unSubscribe() {
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    /**
     * for testing
     * @param weatherBussiness
     */
    public void setWeatherBussiness(WeatherBussiness weatherBussiness) {
        this.weatherBussiness = weatherBussiness;
    }
}
