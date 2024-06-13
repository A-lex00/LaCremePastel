package com.ispwproject.lacremepastel.engineeringclasses.query;

import com.ispwproject.lacremepastel.model.Order;
import com.ispwproject.lacremepastel.other.SupportedOrderTypes;

import java.sql.*;

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

    public static ResultSet getPendingOrders(Connection conn) throws SQLException {
        String query = "SELECT * FROM Orders WHERE pending = 1";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
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

    public static void updateOrder(Connection connection, Order order) throws SQLException{
        String query = "UPDATE Orders SET pending = ?, accepted = ?, done = ? WHERE id = ?";
        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1,(order.isPending())?1:0);
            stmt.setInt(2,(order.isAccepted())?1:0);
            stmt.setInt(3,(order.isClosed()?1:0));
            stmt.setInt(4,(order.getIdOrder()));
            stmt.executeUpdate();
        }
    }

    public static ResultSet getOrderById(Connection connection, int orderId) throws SQLException{
        String query = "SELECT * FROM Orders WHERE id = ?";
        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1,orderId);
            return stmt.executeQuery();
        }
    }
}