
package com.exadel.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultSetInner {

    @SerializedName("format")
    @Expose
    private String format;
    @SerializedName("metrics")
    @Expose
    private MetricsInner metrics;
    @SerializedName("groupKey")
    @Expose
    private String groupKey;

    public MetricsInner getMetrics() {
        return metrics;
    }

    public String getGroupKey() {
        return groupKey;
    }

    @Override
    public String toString() {
        return "ResultSetInner{" +
                "format='" + format + '\'' +
                ", metrics=" + metrics +
                ", groupKey='" + groupKey + '\'' +
                '}';
    }
}
