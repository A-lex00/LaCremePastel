package com.ispwproject.lacremepastel.engineeringclasses.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CustomerQuery {

    private CustomerQuery() {
    }

    public static void addCustomer(Connection conn, String username, String passwd, String firstname, String lastname, String email, String cfPiva, String billingAddress, String userType) throws SQLException {
        String query = "INSERT INTO User(username, password, firstname, lastname, email, billingAddress, `cf-piva`, userType) VALUES (?,?,?,?,?,?,?,?);";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, passwd);
            stmt.setString(3, firstname);
            stmt.setString(4, lastname);
            stmt.setString(5, email);
            stmt.setString(6, billingAddress);
            stmt.setString(7, cfPiva);
            stmt.setString(8, userType);
            stmt.executeUpdate();
        }
    }

    public static List<String> getAllCustomer(Connection conn) {
        String query = "SELECT username, cf-piva, password, firstname, lastname, email, billingAddress, role FROM User WHERE usertype = ?";
        List<String> customerList = null;
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, "CUSTOMER");
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("firstname");
                String surname = resultSet.getString("surname");
                customerList.add(name + "   " + surname);
            }
        return customerList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
