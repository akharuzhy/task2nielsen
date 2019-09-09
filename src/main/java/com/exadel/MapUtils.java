package com.exadel;

import com.exadel.pojo.Example;
import com.exadel.pojo.ResultSetInner;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MapUtils {

    public static Map<String, Double> convertJsonToMap(String json) {
        Gson gson = new Gson();
        Example example = gson.fromJson(json, Example.class);
        HashMap<String, Double> map = new HashMap<>();
        Double audiencePopulation = example.getResultSet().get(0).getMetrics().getAudiencePopulation();
        List<ResultSetInner> resultSetInner = example.getResultSet().get(0).getResultSet();
        for (ResultSetInner rsi : resultSetInner){
            String channelName = rsi.getGroupKey();
            Double reachPercentage = rsi.getMetrics().getReachPopulation() / audiencePopulation * 100;
            map.put(channelName, reachPercentage);
        }
        return map;
    }

    public static Map<String, Double> filterMap(final Map<String, Double> map){
        Map<String, Double> filteredMap = new HashMap<>();
        map.keySet().stream().forEach(k -> {
            if (map.get(k) > 45.0) filteredMap.put(k, map.get(k));
        });
        return filteredMap;
    }

}
