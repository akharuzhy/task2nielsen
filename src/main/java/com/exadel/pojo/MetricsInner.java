
package com.exadel.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MetricsInner {

    @SerializedName("reachPopulation")
    @Expose
    private Double reachPopulation;
    @SerializedName("reachSampleSize")
    @Expose
    private Integer reachSampleSize;

    public Double getReachPopulation() {
        return reachPopulation;
    }

    @Override
    public String toString() {
        return "MetricsInner{" +
                "reachPopulation=" + reachPopulation +
                ", reachSampleSize=" + reachSampleSize +
                '}';
    }
}
