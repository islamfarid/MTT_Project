package com.example.islam.mttproject.dagger;

import com.example.islam.mttproject.weather.bussiness.WeatherBussiness;
import com.example.islam.mttproject.weather.presenter.WeatherPresenter;
import com.example.islam.mttproject.weather.view.WeatherFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by islam on 7/24/16.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
   void inject(WeatherFragment weatherFragment);
   void inject(WeatherPresenter weatherPresenter);
   void inject(WeatherBussiness weatherBussiness);

}
