package com.ispwproject.lacremepastel.engineeringclasses.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

    private static Connection conn = null;
    private static final String DB_URL = Configurations.getInstance().getProperty("DB_URL");
    private static final String DB_USER = Configurations.getInstance().getProperty("DB_USER");
    private static final String DB_PASSWD = Configurations.getInstance().getProperty("DB_PASSWD");

    private Connector(){}

    public static Connection getConnection(){
        try {
            if (conn == null) {
                conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return conn;
    }

}
