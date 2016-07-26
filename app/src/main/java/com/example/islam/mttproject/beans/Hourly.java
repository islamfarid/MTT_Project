
package com.example.islam.mttproject.beans;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Hourly {

    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("tempC")
    @Expose
    private String tempC;
    @SerializedName("tempF")
    @Expose
    private String tempF;
    @SerializedName("windspeedMiles")
    @Expose
    private String windspeedMiles;
    @SerializedName("windspeedKmph")
    @Expose
    private String windspeedKmph;
    @SerializedName("winddirDegree")
    @Expose
    private String winddirDegree;
    @SerializedName("winddir16Point")
    @Expose
    private String winddir16Point;
    @SerializedName("weatherCode")
    @Expose
    private String weatherCode;
    @SerializedName("weatherIconUrl")
    @Expose
    private List<WeatherIconUrl> weatherIconUrl = new ArrayList<WeatherIconUrl>();
    @SerializedName("weatherDesc")
    @Expose
    private List<WeatherDesc> weatherDesc = new ArrayList<WeatherDesc>();
    @SerializedName("precipMM")
    @Expose
    private String precipMM;
    @SerializedName("humidity")
    @Expose
    private String humidity;
    @SerializedName("visibility")
    @Expose
    private String visibility;
    @SerializedName("pressure")
    @Expose
    private String pressure;
    @SerializedName("cloudcover")
    @Expose
    private String cloudcover;
    @SerializedName("HeatIndexC")
    @Expose
    private String heatIndexC;
    @SerializedName("HeatIndexF")
    @Expose
    private String heatIndexF;
    @SerializedName("DewPointC")
    @Expose
    private String dewPointC;
    @SerializedName("DewPointF")
    @Expose
    private String dewPointF;
    @SerializedName("WindChillC")
    @Expose
    private String windChillC;
    @SerializedName("WindChillF")
    @Expose
    private String windChillF;
    @SerializedName("WindGustMiles")
    @Expose
    private String windGustMiles;
    @SerializedName("WindGustKmph")
    @Expose
    private String windGustKmph;
    @SerializedName("FeelsLikeC")
    @Expose
    private String feelsLikeC;
    @SerializedName("FeelsLikeF")
    @Expose
    private String feelsLikeF;
    @SerializedName("chanceofrain")
    @Expose
    private String chanceofrain;
    @SerializedName("chanceofremdry")
    @Expose
    private String chanceofremdry;
    @SerializedName("chanceofwindy")
    @Expose
    private String chanceofwindy;
    @SerializedName("chanceofovercast")
    @Expose
    private String chanceofovercast;
    @SerializedName("chanceofsunshine")
    @Expose
    private String chanceofsunshine;
    @SerializedName("chanceoffrost")
    @Expose
    private String chanceoffrost;
    @SerializedName("chanceofhightemp")
    @Expose
    private String chanceofhightemp;
    @SerializedName("chanceoffog")
    @Expose
    private String chanceoffog;
    @SerializedName("chanceofsnow")
    @Expose
    private String chanceofsnow;
    @SerializedName("chanceofthunder")
    @Expose
    private String chanceofthunder;

    /**
     * 
     * @return
     *     The time
     */
    public String getTime() {
        return time;
    }

    /**
     * 
     * @param time
     *     The time
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * 
     * @return
     *     The tempC
     */
    public String getTempC() {
        return tempC;
    }

    /**
     * 
     * @param tempC
     *     The tempC
     */
    public void setTempC(String tempC) {
        this.tempC = tempC;
    }

    /**
     * 
     * @return
     *     The tempF
     */
    public String getTempF() {
        return tempF;
    }

    /**
     * 
     * @param tempF
     *     The tempF
     */
    public void setTempF(String tempF) {
        this.tempF = tempF;
    }

    /**
     * 
     * @return
     *     The windspeedMiles
     */
    public String getWindspeedMiles() {
        return windspeedMiles;
    }

    /**
     * 
     * @param windspeedMiles
     *     The windspeedMiles
     */
    public void setWindspeedMiles(String windspeedMiles) {
        this.windspeedMiles = windspeedMiles;
    }

    /**
     * 
     * @return
     *     The windspeedKmph
     */
    public String getWindspeedKmph() {
        return windspeedKmph;
    }

    /**
     * 
     * @param windspeedKmph
     *     The windspeedKmph
     */
    public void setWindspeedKmph(String windspeedKmph) {
        this.windspeedKmph = windspeedKmph;
    }

    /**
     * 
     * @return
     *     The winddirDegree
     */
    public String getWinddirDegree() {
        return winddirDegree;
    }

    /**
     * 
     * @param winddirDegree
     *     The winddirDegree
     */
    public void setWinddirDegree(String winddirDegree) {
        this.winddirDegree = winddirDegree;
    }

    /**
     * 
     * @return
     *     The winddir16Point
     */
    public String getWinddir16Point() {
        return winddir16Point;
    }

    /**
     * 
     * @param winddir16Point
     *     The winddir16Point
     */
    public void setWinddir16Point(String winddir16Point) {
        this.winddir16Point = winddir16Point;
    }

    /**
     * 
     * @return
     *     The weatherCode
     */
    public String getWeatherCode() {
        return weatherCode;
    }

    /**
     * 
     * @param weatherCode
     *     The weatherCode
     */
    public void setWeatherCode(String weatherCode) {
        this.weatherCode = weatherCode;
    }

    /**
     * 
     * @return
     *     The weatherIconUrl
     */
    public List<WeatherIconUrl> getWeatherIconUrl() {
        return weatherIconUrl;
    }

    /**
     * 
     * @param weatherIconUrl
     *     The weatherIconUrl
     */
    public void setWeatherIconUrl(List<WeatherIconUrl> weatherIconUrl) {
        this.weatherIconUrl = weatherIconUrl;
    }

    /**
     * 
     * @return
     *     The weatherDesc
     */
    public List<WeatherDesc> getWeatherDesc() {
        return weatherDesc;
    }

    /**
     * 
     * @param weatherDesc
     *     The weatherDesc
     */
    public void setWeatherDesc(List<WeatherDesc> weatherDesc) {
        this.weatherDesc = weatherDesc;
    }

    /**
     * 
     * @return
     *     The precipMM
     */
    public String getPrecipMM() {
        return precipMM;
    }

    /**
     * 
     * @param precipMM
     *     The precipMM
     */
    public void setPrecipMM(String precipMM) {
        this.precipMM = precipMM;
    }

    /**
     * 
     * @return
     *     The humidity
     */
    public String getHumidity() {
        return humidity;
    }

    /**
     * 
     * @param humidity
     *     The humidity
     */
    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    /**
     * 
     * @return
     *     The visibility
     */
    public String getVisibility() {
        return visibility;
    }

    /**
     * 
     * @param visibility
     *     The visibility
     */
    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    /**
     * 
     * @return
     *     The pressure
     */
    public String getPressure() {
        return pressure;
    }

    /**
     * 
     * @param pressure
     *     The pressure
     */
    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    /**
     * 
     * @return
     *     The cloudcover
     */
    public String getCloudcover() {
        return cloudcover;
    }

    /**
     * 
     * @param cloudcover
     *     The cloudcover
     */
    public void setCloudcover(String cloudcover) {
        this.cloudcover = cloudcover;
    }

    /**
     * 
     * @return
     *     The heatIndexC
     */
    public String getHeatIndexC() {
        return heatIndexC;
    }

    /**
     * 
     * @param heatIndexC
     *     The HeatIndexC
     */
    public void setHeatIndexC(String heatIndexC) {
        this.heatIndexC = heatIndexC;
    }

    /**
     * 
     * @return
     *     The heatIndexF
     */
    public String getHeatIndexF() {
        return heatIndexF;
    }

    /**
     * 
     * @param heatIndexF
     *     The HeatIndexF
     */
    public void setHeatIndexF(String heatIndexF) {
        this.heatIndexF = heatIndexF;
    }

    /**
     * 
     * @return
     *     The dewPointC
     */
    public String getDewPointC() {
        return dewPointC;
    }

    /**
     * 
     * @param dewPointC
     *     The DewPointC
     */
    public void setDewPointC(String dewPointC) {
        this.dewPointC = dewPointC;
    }

    /**
     * 
     * @return
     *     The dewPointF
     */
    public String getDewPointF() {
        return dewPointF;
    }

    /**
     * 
     * @param dewPointF
     *     The DewPointF
     */
    public void setDewPointF(String dewPointF) {
        this.dewPointF = dewPointF;
    }

    /**
     * 
     * @return
     *     The windChillC
     */
    public String getWindChillC() {
        return windChillC;
    }

    /**
     * 
     * @param windChillC
     *     The WindChillC
     */
    public void setWindChillC(String windChillC) {
        this.windChillC = windChillC;
    }

    /**
     * 
     * @return
     *     The windChillF
     */
    public String getWindChillF() {
        return windChillF;
    }

    /**
     * 
     * @param windChillF
     *     The WindChillF
     */
    public void setWindChillF(String windChillF) {
        this.windChillF = windChillF;
    }

    /**
     * 
     * @return
     *     The windGustMiles
     */
    public String getWindGustMiles() {
        return windGustMiles;
    }

    /**
     * 
     * @param windGustMiles
     *     The WindGustMiles
     */
    public void setWindGustMiles(String windGustMiles) {
        this.windGustMiles = windGustMiles;
    }

    /**
     * 
     * @return
     *     The windGustKmph
     */
    public String getWindGustKmph() {
        return windGustKmph;
    }

    /**
     * 
     * @param windGustKmph
     *     The WindGustKmph
     */
    public void setWindGustKmph(String windGustKmph) {
        this.windGustKmph = windGustKmph;
    }

    /**
     * 
     * @return
     *     The feelsLikeC
     */
    public String getFeelsLikeC() {
        return feelsLikeC;
    }

    /**
     * 
     * @param feelsLikeC
     *     The FeelsLikeC
     */
    public void setFeelsLikeC(String feelsLikeC) {
        this.feelsLikeC = feelsLikeC;
    }

    /**
     * 
     * @return
     *     The feelsLikeF
     */
    public String getFeelsLikeF() {
        return feelsLikeF;
    }

    /**
     * 
     * @param feelsLikeF
     *     The FeelsLikeF
     */
    public void setFeelsLikeF(String feelsLikeF) {
        this.feelsLikeF = feelsLikeF;
    }

    /**
     * 
     * @return
     *     The chanceofrain
     */
    public String getChanceofrain() {
        return chanceofrain;
    }

    /**
     * 
     * @param chanceofrain
     *     The chanceofrain
     */
    public void setChanceofrain(String chanceofrain) {
        this.chanceofrain = chanceofrain;
    }

    /**
     * 
     * @return
     *     The chanceofremdry
     */
    public String getChanceofremdry() {
        return chanceofremdry;
    }

    /**
     * 
     * @param chanceofremdry
     *     The chanceofremdry
     */
    public void setChanceofremdry(String chanceofremdry) {
        this.chanceofremdry = chanceofremdry;
    }

    /**
     * 
     * @return
     *     The chanceofwindy
     */
    public String getChanceofwindy() {
        return chanceofwindy;
    }

    /**
     * 
     * @param chanceofwindy
     *     The chanceofwindy
     */
    public void setChanceofwindy(String chanceofwindy) {
        this.chanceofwindy = chanceofwindy;
    }

    /**
     * 
     * @return
     *     The chanceofovercast
     */
    public String getChanceofovercast() {
        return chanceofovercast;
    }

    /**
     * 
     * @param chanceofovercast
     *     The chanceofovercast
     */
    public void setChanceofovercast(String chanceofovercast) {
        this.chanceofovercast = chanceofovercast;
    }

    /**
     * 
     * @return
     *     The chanceofsunshine
     */
    public String getChanceofsunshine() {
        return chanceofsunshine;
    }

    /**
     * 
     * @param chanceofsunshine
     *     The chanceofsunshine
     */
    public void setChanceofsunshine(String chanceofsunshine) {
        this.chanceofsunshine = chanceofsunshine;
    }

    /**
     * 
     * @return
     *     The chanceoffrost
     */
    public String getChanceoffrost() {
        return chanceoffrost;
    }

    /**
     * 
     * @param chanceoffrost
     *     The chanceoffrost
     */
    public void setChanceoffrost(String chanceoffrost) {
        this.chanceoffrost = chanceoffrost;
    }

    /**
     * 
     * @return
     *     The chanceofhightemp
     */
    public String getChanceofhightemp() {
        return chanceofhightemp;
    }

    /**
     * 
     * @param chanceofhightemp
     *     The chanceofhightemp
     */
    public void setChanceofhightemp(String chanceofhightemp) {
        this.chanceofhightemp = chanceofhightemp;
    }

    /**
     * 
     * @return
     *     The chanceoffog
     */
    public String getChanceoffog() {
        return chanceoffog;
    }

    /**
     * 
     * @param chanceoffog
     *     The chanceoffog
     */
    public void setChanceoffog(String chanceoffog) {
        this.chanceoffog = chanceoffog;
    }

    /**
     * 
     * @return
     *     The chanceofsnow
     */
    public String getChanceofsnow() {
        return chanceofsnow;
    }

    /**
     * 
     * @param chanceofsnow
     *     The chanceofsnow
     */
    public void setChanceofsnow(String chanceofsnow) {
        this.chanceofsnow = chanceofsnow;
    }

    /**
     * 
     * @return
     *     The chanceofthunder
     */
    public String getChanceofthunder() {
        return chanceofthunder;
    }

    /**
     * 
     * @param chanceofthunder
     *     The chanceofthunder
     */
    public void setChanceofthunder(String chanceofthunder) {
        this.chanceofthunder = chanceofthunder;
    }

}
