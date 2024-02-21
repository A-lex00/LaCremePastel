package com.ispwproject.lecremepastel.engineeringclasses.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SpecialOrderQuery{

    private SpecialOrderQuery(){

    }

    public static void insertOrder(Connection conn, int orderId, String content, String username, int orderType) throws SQLException {
        String sql = "INSERT INTO Orders(id, content, customer, ordertype) VALUES(?,?,?,?)";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,orderId);
            ps.setString(2,content);
            ps.setString(3,username);
            ps.setInt(4,orderType);
            ps.executeUpdate();
        }
    }

    public static ResultSet selectOrder(Connection conn, int orderId, String username) throws SQLException {
        String sql = "SELECT id,content,pending,accepted,done,customer FROM Orders WHERE id = ? AND customer = ?";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,orderId);
            ps.setString(2,username);
            return ps.executeQuery();
        }
    }

    public static ResultSet selectAllOrders(Connection conn, String username, int orderType) throws SQLException {
        String sql = "SELECT id,content,pending,accepted,done,customer FROM Orders WHERE customer = ? AND ordertype = ?";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1,username);
            ps.setInt(2,orderType);
            return ps.executeQuery();
        }
    }

    public static ResultSet selectAllOrders(Connection conn, int orderType) throws SQLException {
        String sql = "SELECT id,content,pending,accepted,done,customer FROM Orders WHERE ordertype = ?";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,orderType);
            return ps.executeQuery();
        }
    }

}
