package com.example.islam.mttproject.db.manager;

import com.example.islam.mttproject.db.City;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by islam on 7/25/16.
 */
public interface DbManager {
    void newCity(City newCity);
    void addCities(ArrayList<City> cities);
    List<City> loadAllCities();
    void removeCity(City city);
}
