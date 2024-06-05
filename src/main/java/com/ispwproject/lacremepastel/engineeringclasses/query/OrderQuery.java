package com.ispwproject.lacremepastel.engineeringclasses.query;

import com.ispwproject.lacremepastel.engineeringclasses.bean.OrderBean;
import com.ispwproject.lacremepastel.model.Order;
import com.ispwproject.lacremepastel.model.OrderLine;
import com.ispwproject.lacremepastel.model.Product;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class OrderQuery{
    private OrderQuery(){}

    public static ResultSet  createSimpleOrder(Connection conn, int pending, int accepted, int closed, String customer) throws  SQLException  {
    String createEntryOrders = "INSERT INTO Orders ( pending, accepted, done, customer) VALUES (?,?,?,?) ";
        try (PreparedStatement stmt = conn.prepareStatement(createEntryOrders, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, pending);
            stmt.setInt(2, accepted);
            stmt.setInt(3, closed);
            stmt.setString(4, customer);
            stmt.executeUpdate();
            return stmt.getGeneratedKeys();
        }
    }
}