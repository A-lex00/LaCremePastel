package com.ispwproject.lecremepastel.engineeringclasses.query;

import java.sql.*;

public class SimpleOrderQuery {

    private SimpleOrderQuery(){

    }

    public static ResultSet insertOrder(Connection conn, String username, int pending, int accepted, int done, int orderType) throws SQLException {
        String sql = "INSERT INTO Orders(customer, pending, accepted, done, ordertype) VALUES(?,?,?,?,?)";
        try(PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1,username);
            ps.setInt(2,pending);
            ps.setInt(3,accepted);
            ps.setInt(4,done);
            ps.setInt(5,orderType);
            ps.executeUpdate();
            return ps.getGeneratedKeys();
        }
    }

    public static ResultSet selectOrder(Connection conn, int orderId, String username) throws SQLException{
        String sql = "SELECT id,customer,pending,accepted,done FROM Orders WHERE id = ? AND customer = ?";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,orderId);
            ps.setString(2,username);
            return ps.executeQuery();
        }
    }

    public static ResultSet selectAllOrders(Connection conn, String username, int orderType) throws SQLException{
        String sql = "SELECT id,customer,pending,accepted,done FROM Orders WHERE customer = ? and orderType = ?";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1,username);
            ps.setInt(2,orderType);
            return ps.executeQuery();
        }
    }

    public static ResultSet selectAllOrders(Connection conn, int orderType, boolean onlyPending) throws SQLException {
        String sql;
        if (onlyPending) {
            sql = "SELECT id,customer,pending,accepted,done FROM Orders WHERE orderType = ? AND pending = 1";
        } else {
            sql = "SELECT id,customer,pending,accepted,done FROM Orders WHERE orderType = ?";
        }
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, orderType);
            return ps.executeQuery();
        }
    }
}
