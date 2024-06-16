package com.ispwproject.lacremepastel.engineeringclasses.singleton;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class Configurations {
    private static final String FILEPATH = "src/config.properties";
    public static final String LOGGER_NAME = "LeCremePastel";

    private final Properties props = new Properties();
    private static final Configurations instance = new Configurations();

    private Configurations(){
        try(FileInputStream propsInput = new FileInputStream(FILEPATH)){
            props.load(propsInput);
        } catch (IOException e) {
            Logger.getLogger(LOGGER_NAME).severe(e.getMessage());
        }
    }

    public static Configurations getInstance(){
        return instance;
    }

    public String getProperty(String key){
        return props.getProperty(key);
    }

}
