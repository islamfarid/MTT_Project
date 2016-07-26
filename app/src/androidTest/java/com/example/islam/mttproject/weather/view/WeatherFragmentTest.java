package com.example.islam.mttproject.weather.view;

import android.content.Intent;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;

import com.example.islam.mttproject.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by islam on 7/26/16.
 */
public class WeatherFragmentTest {
    @Rule
    public ActivityTestRule<WeatherActivity> activityRule = new ActivityTestRule<>(
            WeatherActivity.class,
            true,     // initialTouchMode
            false);   // launchActivity. False so we can customize the intent per test method

    @Before
    public void setUp() {
        activityRule.launchActivity(new Intent());
    }

    @Test
    public void checkProgressISNotDisplayedAtTheBegining() {
        onView(withId(R.id.progressBar))
                .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));
    }
    @Test
    public void checkAllViewsExceptTheProgressAreDisplayed() {
        onView(withId(R.id.list_of_cities_spinner)
        ).check(matches(isDisplayed()));
        onView(withId(R.id.add_city_button)
        ).check(matches(isDisplayed()));
        onView(withId(R.id.refresh_imageview)
        ).check(matches(isDisplayed()));
        onView(withId(R.id.refresh_imageview)
        ).check(matches(isDisplayed()));
        onView(withId(R.id.weather_data_recyclerview)
        ).check(matches(isDisplayed()));
    }




}