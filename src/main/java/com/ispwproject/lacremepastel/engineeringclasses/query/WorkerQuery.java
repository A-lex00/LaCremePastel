package com.ispwproject.lacremepastel.engineeringclasses.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WorkerQuery {

    private WorkerQuery(){}

    public static void addWorker(Connection conn, String username, String passwd, String firstname, String lastname, String email, String cfPiva, String role, String userType) throws SQLException {
        String query = "INSERT INTO User(username, password, firstname, lastname, email, role, `cf-piva`, userType) VALUES (?,?,?,?,?,?,?,?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, passwd);
            stmt.setString(3, firstname);
            stmt.setString(4, lastname);
            stmt.setString(5, email);
            stmt.setString(6, role);
            stmt.setString(7, cfPiva);
            stmt.setString(8, userType);
            stmt.executeUpdate();
        }
    }

}
