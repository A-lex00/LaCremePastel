package com.ispwproject.lecremepastel.engineeringclasses.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WorkerQuery {

    private WorkerQuery(){}

    public static ResultSet selectWorker(Connection conn, String username) throws SQLException {
        String sql = "SELECT * FROM User WHERE username = ?";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1,username);
            return ps.executeQuery();
        }
    }

    public static void insertWorker(Connection conn, String username, String cfPiva, String passwd, String firstname, String lastname, String email, String role, int userType) throws SQLException{
        String sql = "INSERT INTO User(username,`cf-piva`,password,firstname,lastname,email,role,usertype) VALUES (?,?,?,?,?,?,?,?)";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1,username);
            ps.setString(2,cfPiva);
            ps.setString(3,passwd);
            ps.setString(4,firstname);
            ps.setString(5,lastname);
            ps.setString(6,email);
            ps.setString(7,role);
            ps.setInt(8,userType);
            ps.executeUpdate();
        }
    }

}
