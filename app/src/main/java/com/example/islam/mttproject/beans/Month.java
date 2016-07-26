
package com.example.islam.mttproject.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Month {

    @SerializedName("index")
    @Expose
    private String index;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("avgMinTemp")
    @Expose
    private String avgMinTemp;
    @SerializedName("avgMinTemp_F")
    @Expose
    private String avgMinTempF;
    @SerializedName("absMaxTemp")
    @Expose
    private String absMaxTemp;
    @SerializedName("absMaxTemp_F")
    @Expose
    private String absMaxTempF;

    /**
     * 
     * @return
     *     The index
     */
    public String getIndex() {
        return index;
    }

    /**
     * 
     * @param index
     *     The index
     */
    public void setIndex(String index) {
        this.index = index;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The avgMinTemp
     */
    public String getAvgMinTemp() {
        return avgMinTemp;
    }

    /**
     * 
     * @param avgMinTemp
     *     The avgMinTemp
     */
    public void setAvgMinTemp(String avgMinTemp) {
        this.avgMinTemp = avgMinTemp;
    }

    /**
     * 
     * @return
     *     The avgMinTempF
     */
    public String getAvgMinTempF() {
        return avgMinTempF;
    }

    /**
     * 
     * @param avgMinTempF
     *     The avgMinTemp_F
     */
    public void setAvgMinTempF(String avgMinTempF) {
        this.avgMinTempF = avgMinTempF;
    }

    /**
     * 
     * @return
     *     The absMaxTemp
     */
    public String getAbsMaxTemp() {
        return absMaxTemp;
    }

    /**
     * 
     * @param absMaxTemp
     *     The absMaxTemp
     */
    public void setAbsMaxTemp(String absMaxTemp) {
        this.absMaxTemp = absMaxTemp;
    }

    /**
     * 
     * @return
     *     The absMaxTempF
     */
    public String getAbsMaxTempF() {
        return absMaxTempF;
    }

    /**
     * 
     * @param absMaxTempF
     *     The absMaxTemp_F
     */
    public void setAbsMaxTempF(String absMaxTempF) {
        this.absMaxTempF = absMaxTempF;
    }

}
