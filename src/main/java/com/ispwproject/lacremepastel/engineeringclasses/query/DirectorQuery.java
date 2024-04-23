package com.ispwproject.lacremepastel.engineeringclasses.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DirectorQuery {

    private DirectorQuery(){}

    public static void addDirector(Connection conn, String username, String passwd, String firstname, String lastname, String email, String cfPiva, String userType) throws SQLException {
        String query = "INSERT INTO User(username, password, firstname, lastname, email, `cf-piva`, userType) VALUES (?,?,?,?,?,?,?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, passwd);
            stmt.setString(3, firstname);
            stmt.setString(4, lastname);
            stmt.setString(5, email);
            stmt.setString(6, cfPiva);
            stmt.setString(7, userType);
            stmt.executeUpdate();
        }
    }

}
