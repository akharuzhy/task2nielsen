
package com.exadel.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Metrics {

    @SerializedName("audiencePopulation")
    @Expose
    private Double audiencePopulation;
    @SerializedName("universePopulation")
    @Expose
    private Double universePopulation;
    @SerializedName("audienceSampleSize")
    @Expose
    private Integer audienceSampleSize;
    @SerializedName("universeSampleSize")
    @Expose
    private Integer universeSampleSize;

    public Double getAudiencePopulation() {
        return audiencePopulation;
    }

    @Override
    public String toString() {
        return "Metrics{" +
                "audiencePopulation=" + audiencePopulation +
                ", universePopulation=" + universePopulation +
                ", audienceSampleSize=" + audienceSampleSize +
                ", universeSampleSize=" + universeSampleSize +
                '}';
    }
}
