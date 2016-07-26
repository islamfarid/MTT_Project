
package com.example.islam.mttproject.beans;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClimateAverage {

    @SerializedName("month")
    @Expose
    private List<Month> month = new ArrayList<Month>();

    /**
     * 
     * @return
     *     The month
     */
    public List<Month> getMonth() {
        return month;
    }

    /**
     * 
     * @param month
     *     The month
     */
    public void setMonth(List<Month> month) {
        this.month = month;
    }

}
