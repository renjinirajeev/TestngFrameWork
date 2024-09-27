package com.automation.utils;

import java.io.*;
import java.util.Properties;

public class ConfigReader {
    static Properties prop;
    public static void initConfig(){
        prop = new Properties();
        try {
            prop.load(new FileInputStream("src/test/resources/config/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getConfig(String key){
        return prop.getProperty(key);
    }

    public static void setConfig(String key ,String value){
        prop.setProperty(key,value);
        try {
            prop.save(new FileOutputStream("src/test/resources/config/config.properties"),"done");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
