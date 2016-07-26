package com.example.islam.mttproject.weather.view;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;

import com.example.islam.mttproject.R;
import com.example.islam.mttproject.application.MTTApplication;
import com.example.islam.mttproject.beans.WeatherData;
import com.example.islam.mttproject.common.Constants;
import com.example.islam.mttproject.db.City;
import com.example.islam.mttproject.weather.presenter.WeatherPresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeatherFragment extends Fragment implements WeatherView {
    private static final int MY_REQUEST_CODE = 1;
    @Bind(R.id.list_of_cities_spinner)
    Spinner mCitiesSpinner;
    @Bind(R.id.add_city_button)
    Button mAddCityButton;
    @Bind(R.id.remove_city_button)
    Button mRemoveCityButton;
    @Bind(R.id.weather_data_recyclerview)
    RecyclerView mWeatherList;
    @Bind(R.id.progressBar)
    ProgressBar loadingBar;
    @Bind(R.id.refresh_imageview)
    ImageView refreshImageView;
    @Inject
    WeatherPresenter weatherPresenter;
    int selection = 0;

    public WeatherFragment() {
        // Required empty public constructor
        MTTApplication.getInstance().getApplicationComponent().inject(this);
        weatherPresenter.setView(this);
        weatherPresenter.loadCities();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather, container, false);
        ButterKnife.bind(this, view);
        mWeatherList.setLayoutManager(new LinearLayoutManager(getActivity()));
        if ((savedInstanceState != null)) {
            selection = savedInstanceState.getInt(Constants.CURRENT_SELLECTION);
        }

        return view;
    }


    @Override
    public void showCities(List<City> cities) {
        ArrayAdapter<City> dataAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_dropdown_item, cities);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mCitiesSpinner.setAdapter(dataAdapter);
        mCitiesSpinner.setSelection(selection, false);
    }

    @Override
    public void showWeather(WeatherData data) {
        HeaderAdapter headerAdapter = new HeaderAdapter(getActivity(), data);
        mWeatherList.setAdapter(headerAdapter);
    }

    @Override
    public void hideProgress() {
        loadingBar.setVisibility(View.GONE);
    }

    @Override
    public void showProgress() {
        loadingBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void showErrorMEssage(String message) {
        Snackbar bar = Snackbar.make(mCitiesSpinner, message, Snackbar.LENGTH_LONG);
        bar.show();
    }


    @OnClick(R.id.add_city_button)
    public void addNewCity() {
        AddingCityDialogFragment addingCityDialogFragment = new AddingCityDialogFragment();
        addingCityDialogFragment.show(getActivity().getFragmentManager(), AddingCityDialogFragment.class.getName());
        addingCityDialogFragment.setTargetFragment(WeatherFragment.this, MY_REQUEST_CODE);
    }

    @OnClick(R.id.refresh_imageview)
    public void refresh() {
        weatherPresenter.getWeather((City) mCitiesSpinner.getSelectedItem());
    }

    @OnClick(R.id.remove_city_button)
    public void removeCity() {
        weatherPresenter.removeCity((City) mCitiesSpinner.getSelectedItem());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == getActivity().RESULT_OK && requestCode == MY_REQUEST_CODE) {
            weatherPresenter.addCity(data.getExtras().get(Constants.NEW_CITY).toString());
        }
    }

    @OnItemSelected(R.id.list_of_cities_spinner)
    public void cityChoosen(int postion) {
        weatherPresenter.getWeather((City) mCitiesSpinner.getSelectedItem());
    }

    @Override
    public void onStop() {
        super.onStop();
        weatherPresenter.unSubscribe();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(Constants.CURRENT_SELLECTION, mCitiesSpinner.getSelectedItemPosition());
        super.onSaveInstanceState(outState);
    }
}
