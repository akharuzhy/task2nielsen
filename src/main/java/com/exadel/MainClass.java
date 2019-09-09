package com.exadel;

import org.apache.log4j.Logger;
import java.util.Map;
import java.util.Properties;

class MainClass {

    public static final Logger log = Logger.getLogger(MainClass.class);

    public static void main(String[] args) throws Exception {
        Properties properties = new PropertiesLoader().loadProperties("./configuration.properties");

        String jsonString = new JsonReader().readFileToString(properties.getProperty("pathToJson"));
        Map<String, Double> map = MapUtils.convertJsonToMap(jsonString);
        map = MapUtils.filterMap(map);
        new ExcelWriter().writeMapToExcel(map, properties.getProperty("pathToResults"));
    }



}
