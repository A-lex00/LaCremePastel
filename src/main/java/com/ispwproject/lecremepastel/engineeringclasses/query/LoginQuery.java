package com.ispwproject.lecremepastel.engineeringclasses.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginQuery {

    private LoginQuery(){

    }

    public static ResultSet selectUser(Connection conn, String authString) throws SQLException {
        String sql = "SELECT username,password,userType FROM User WHERE username = ? OR email = ?";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1,authString);
            ps.setString(2,authString);
            return ps.executeQuery();
        }
    }
}
