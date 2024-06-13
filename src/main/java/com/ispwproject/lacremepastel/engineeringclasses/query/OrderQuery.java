package com.ispwproject.lacremepastel.engineeringclasses.query;

import com.ispwproject.lacremepastel.engineeringclasses.singleton.Configurations;
import com.ispwproject.lacremepastel.other.SupportedOrderTypes;

import java.sql.*;
import java.util.logging.Logger;

public class OrderQuery {
    private OrderQuery() {
    }

    public static ResultSet createSimpleOrder(Connection conn, int pending, int accepted, int closed, String customer) throws SQLException {
        String createEntryOrders = "INSERT INTO Orders ( pending, accepted, done, customer, ordertype) VALUES (?,?,?,?,?) ";
        try (PreparedStatement stmt = conn.prepareStatement(createEntryOrders, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, pending);
            stmt.setInt(2, accepted);
            stmt.setInt(3, closed);
            stmt.setString(4, customer);
            stmt.setString(5, SupportedOrderTypes.SIMPLE.toString());
            stmt.executeUpdate();
            return stmt.getGeneratedKeys();
        }

    }

    public static ResultSet getAllOrders(Connection conn) throws SQLException {
        String query = "SELECT * FROM Orders";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            return stmt.executeQuery();
        }
    }

    public static ResultSet getOrderById(Connection conn, int id) throws SQLException {
        String query = """
                SELECT product.name, orderline.amount
                FROM orderline JOIN orders ON orders.id = orderline.order
                JOIN product ON orderline.product = product.id 
                WHERE orderline.order = ? AND orders.pending = 1 """;
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            return stmt.executeQuery();

        }
    }

    public static void cleanOnFail(Connection conn, int orderId) throws  SQLException{
        String query = "DELETE FROM Orders WHERE id = ?";
        try(PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, orderId);
            stmt.executeUpdate();
        }
    }
}