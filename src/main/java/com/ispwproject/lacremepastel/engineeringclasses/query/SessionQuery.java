package com.ispwproject.lacremepastel.engineeringclasses.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SessionQuery {

    private SessionQuery(){

    }
    public static ResultSet authUser(Connection conn, String authString) throws SQLException {
        String query = "SELECT username, password, usertype FROM User WHERE (username = ? OR email = ?)";
        try(PreparedStatement ps = conn.prepareStatement(query)){
            ps.setString(1, authString);
            ps.setString(2, authString);
            return ps.executeQuery();
        }
    }

}
