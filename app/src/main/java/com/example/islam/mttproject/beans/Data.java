
package com.example.islam.mttproject.beans;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("request")
    @Expose
    private List<Request> request = new ArrayList<Request>();
    @SerializedName("current_condition")
    @Expose
    private List<CurrentCondition> currentCondition = new ArrayList<CurrentCondition>();
    @SerializedName("weather")
    @Expose
    private List<Weather> weather = new ArrayList<Weather>();
    @SerializedName("ClimateAverages")
    @Expose
    private List<ClimateAverage> climateAverages = new ArrayList<ClimateAverage>();

    /**
     * 
     * @return
     *     The request
     */
    public List<Request> getRequest() {
        return request;
    }

    /**
     * 
     * @param request
     *     The request
     */
    public void setRequest(List<Request> request) {
        this.request = request;
    }

    /**
     * 
     * @return
     *     The currentCondition
     */
    public List<CurrentCondition> getCurrentCondition() {
        return currentCondition;
    }

    /**
     * 
     * @param currentCondition
     *     The current_condition
     */
    public void setCurrentCondition(List<CurrentCondition> currentCondition) {
        this.currentCondition = currentCondition;
    }

    /**
     * 
     * @return
     *     The weather
     */
    public List<Weather> getWeather() {
        return weather;
    }

    /**
     * 
     * @param weather
     *     The weather
     */
    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    /**
     * 
     * @return
     *     The climateAverages
     */
    public List<ClimateAverage> getClimateAverages() {
        return climateAverages;
    }

    /**
     * 
     * @param climateAverages
     *     The ClimateAverages
     */
    public void setClimateAverages(List<ClimateAverage> climateAverages) {
        this.climateAverages = climateAverages;
    }

}
