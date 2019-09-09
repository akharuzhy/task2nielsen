
package com.exadel.pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultSet {

    @SerializedName("period")
    @Expose
    private List<String> period = null;
    @SerializedName("metrics")
    @Expose
    private Metrics metrics;
    @SerializedName("resultSet")
    @Expose
    private List<ResultSetInner> resultSet = null;

    public Metrics getMetrics() {
        return metrics;
    }

    public List<ResultSetInner> getResultSet() {
        return resultSet;
    }

    @Override
    public String toString() {
        return "ResultSet{" +
                "period=" + period +
                ", metrics=" + metrics +
                ", resultSet=" + resultSet +
                '}';
    }
}
