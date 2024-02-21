package com.ispwproject.lecremepastel.engineeringclasses.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderLineQuery {

    private OrderLineQuery(){}

    public static void insertOrderLine(Connection conn, int orderId, int productId, int amount) throws SQLException {
        String sql = "INSERT INTO OrderLine(`order`,product,amount) VALUES(?,?,?)";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,orderId);
            ps.setInt(2,productId);
            ps.setInt(3,amount);
            ps.executeUpdate();
        }
    }

    public static ResultSet loadOrderLines(Connection conn, int orderId) throws SQLException {
        String sql = "SELECT * FROM OrderLine WHERE `order` = ?";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,orderId);
            return ps.executeQuery();
        }
    }

    public static void updateOrderLine(Connection conn, int orderId, int productId, int amount) throws SQLException {
        String sql = "UPDATE OrderLine SET amount = ? WHERE `order` = ? AND product = ?";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,amount);
            ps.setInt(2,orderId);
            ps.setInt(3,productId);
            ps.executeUpdate();
        }
    }

    public static int deleteOrderLine(Connection conn, int orderId, int productId) throws SQLException{
        //Meaning of this query: DELETE the OrderLine selected ONLY IF the relative order is still pending
        String sql = "DELETE FROM OrderLine WHERE `order` = ? AND product = ? AND EXISTS (SELECT id FROM Orders WHERE id = ? AND pending = 1);";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,orderId);
            ps.setInt(2,productId);
            ps.setInt(3,orderId);
            return ps.executeUpdate();
        }
    }

}
