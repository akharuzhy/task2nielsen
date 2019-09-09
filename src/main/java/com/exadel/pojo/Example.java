
package com.exadel.pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("resultSet")
    @Expose
    private List<ResultSet> resultSet = null;

    public List<ResultSet> getResultSet() {
        return resultSet;
    }

    @Override
    public String toString() {
        return "Example{" +
                "kind='" + kind + '\'' +
                ", id='" + id + '\'' +
                ", resultSet=" + resultSet +
                '}';
    }
}
