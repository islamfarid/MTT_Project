package com.example.islam.mttproject.dagger;

import com.example.islam.mttproject.application.MTTApplication;
import com.example.islam.mttproject.db.manager.DbManager;
import com.example.islam.mttproject.db.manager.DbManagerImp;
import com.example.islam.mttproject.weather.bussiness.WeatherBussiness;
import com.example.islam.mttproject.weather.presenter.WeatherPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by islam on 7/24/16.
 */
@Module
public class ApplicationModule {
    MTTApplication mttApplication;
    public ApplicationModule(MTTApplication mttApplication){
        this.mttApplication = mttApplication;
    }
    @Singleton
    @Provides
    public WeatherPresenter provideWeatherPresenter(){
        return new WeatherPresenter();
    }
    @Singleton
    @Provides
    public WeatherBussiness provideWeatherBussiness(){
        return new WeatherBussiness(mttApplication.getApplicationContext());
    }
    @Singleton
    @Provides
    public DbManager provideDbManager(){
        return new DbManagerImp(mttApplication.getApplicationContext());
    }
}
