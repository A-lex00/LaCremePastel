package com.ispwproject.lacremepastel.engineeringclasses.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserQuery {

    private UserQuery(){}

    public static void addUser(Connection conn, String username, String passwd, String firstname, String lastname, String email, String cfPiva, String userTypes) throws SQLException {
        String query = "INSERT INTO User(username, password, firstname, lastname, email, `cf-piva`, userType) VALUES (?,?,?,?,?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, username);
            ps.setString(2, passwd);
            ps.setString(3, firstname);
            ps.setString(4, lastname);
            ps.setString(5, email);
            ps.setString(6, cfPiva);
            ps.setString(7, userTypes);
            ps.executeUpdate();
        }
    }

}
