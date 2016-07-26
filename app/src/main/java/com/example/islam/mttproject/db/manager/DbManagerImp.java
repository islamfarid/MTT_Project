package com.example.islam.mttproject.db.manager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.islam.mttproject.util.log.Logger;
import com.example.islam.mttproject.db.City;
import com.example.islam.mttproject.db.CityDao;
import com.example.islam.mttproject.db.DaoMaster;
import com.example.islam.mttproject.db.DaoSession;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by islam on 7/25/16.
 */
public class DbManagerImp implements DbManager {
    Context context;
    SQLiteDatabase db;
    DaoMaster.DevOpenHelper helper;
    DaoMaster daoMaster;
    DaoSession daoSession;
    CityDao cityDao;

    @Inject
    public DbManagerImp(Context context) {
        this.context = context;
    }

    private void initializeDB() {
        helper = new DaoMaster.DevOpenHelper(context, "cities-db", null);
        if (db == null) {
            db = helper.getWritableDatabase();
            Logger.i("initializeDB->: db==null");
        } else {
            if (!db.isOpen()) {
                db = helper.getWritableDatabase();
                Logger.i("initializeDB->: db!=null && !db.isOpen()");
            } else {
                Logger.i("initializeDB->: db!=null && db.isOpen()");
            }

        }
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();

        cityDao = daoSession.getCityDao();

    }

    @Override
    public void newCity(City newCity) {
        try {
            initializeDB();
            cityDao.insert(newCity);
        } finally {
            closeDb();
        }
    }

    @Override
    public void addCities(ArrayList<City> cities) {
        try {
            initializeDB();
            cityDao.insertInTx(cities);
        } finally {
            closeDb();
        }
    }

    @Override
    public List<City> loadAllCities() {
        List<City> allCities = null;
        try {
            initializeDB();
            allCities = cityDao.loadAll();
        } finally {
            closeDb();
        }
        return allCities;
    }

    @Override
    public void removeCity(City city) {
        try {
            initializeDB();
            cityDao.delete(city);
        } finally {
            closeDb();
        }
    }

    private void closeDb() {
        db.close();
    }
}
