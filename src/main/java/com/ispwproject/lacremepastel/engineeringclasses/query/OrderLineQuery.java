package com.ispwproject.lacremepastel.engineeringclasses.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderLineQuery {

    private OrderLineQuery(){}

    public static void saveOrderLine(Connection conn, int orderId, int productId, int amount) throws SQLException {
        String query = "INSERT INTO OrderLine (`order`, product, amount) VALUES (?, ?, ?)";
        try(PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, orderId);
            stmt.setInt(2, productId);
            stmt.setInt(3, amount);
            stmt.executeUpdate();
        }
    }

    public static void cleanOnFail(Connection conn, int orderId) throws SQLException{
        String query = "DELETE FROM OrderLine WHERE `order` = ?";
        try(PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setInt(1,orderId);
            stmt.executeUpdate();
        }
    }

    public static ResultSet getOrderLinesByOrderId(Connection conn, int orderId) throws SQLException {
        String query = "SELECT OrderLine.product ,OrderLine.amount FROM OrderLine WHERE `order` = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, orderId);
            return stmt.executeQuery();
        }
    }

}