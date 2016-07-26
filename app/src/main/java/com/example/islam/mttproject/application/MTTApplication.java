package com.example.islam.mttproject.application;

import android.app.Application;

import com.example.islam.mttproject.dagger.ApplicationComponent;
import com.example.islam.mttproject.dagger.ApplicationModule;
import com.example.islam.mttproject.dagger.DaggerApplicationComponent;

/**
 * Created by islam on 7/24/16.
 */
public class MTTApplication extends Application {
    ApplicationComponent applicationComponent;
    private static MTTApplication mttApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        this.mttApplication = this;
        applicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    /**
     * we are sure that this instance wont be null in our application
     * as we give it a value in the application onCreate.
     * @return
     */
    public static MTTApplication getInstance() {
        return mttApplication;
    }
}
