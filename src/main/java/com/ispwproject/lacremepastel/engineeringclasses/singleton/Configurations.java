package com.ispwproject.lacremepastel.engineeringclasses.singleton;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configurations {
    private static final String FILEPATH = "src/config.properties";
    private final Properties props = new Properties();
    private static Configurations instance = new Configurations();

    private Configurations(){
        try(FileInputStream propsInput = new FileInputStream(FILEPATH)){
            props.load(propsInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized Configurations getInstance(){
        if(instance == null){
            instance = new Configurations();
        }
        return instance;
    }

    public String getProperty(String key){
        return props.getProperty(key);
    }

}
