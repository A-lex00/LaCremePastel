package com.ispwproject.lacremepastel.engineeringclasses.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserQuery{

    private UserQuery(){}

    public static void addUser(Connection conn, String username, String passwd, String email, String userType) throws SQLException {
        String query = "INSERT INTO User(username, password, email, userType) VALUES (?,?,?,?);";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, passwd);
            stmt.setString(3, email);
            stmt.setString(4, userType);
            stmt.executeUpdate();
        }
    }

}
