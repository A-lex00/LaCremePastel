package com.ispwproject.lacremepastel.engineeringclasses.singleton;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class Configurations {
    private static final String filePath = "src/config.properties";
    public static final String LoggerName = "LeCremePastel";

    private final Properties props = new Properties();
    private static Configurations instance = null;

    private Configurations(){
        try(FileInputStream propsInput = new FileInputStream(filePath)){
            props.load(propsInput);
        } catch (IOException e) {
            Logger.getLogger(LoggerName).severe(e.getMessage());
        }
    }

    public synchronized static Configurations getInstance(){
        if(instance == null) {
            instance = new Configurations();
        }
        return instance;
    }

    public String getProperty(String key){
        return props.getProperty(key);
    }

}
