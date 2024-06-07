package com.ispwproject.lacremepastel.engineeringclasses.query;

import com.ispwproject.lacremepastel.engineeringclasses.bean.OrderBean;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Configurations;
import com.ispwproject.lacremepastel.model.Order;
import com.ispwproject.lacremepastel.model.OrderLine;
import com.ispwproject.lacremepastel.model.Product;
import com.ispwproject.lacremepastel.other.SupportedOrderTypes;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

public class OrderQuery{
    private OrderQuery(){}

    public static ResultSet  createSimpleOrder(Connection conn, int pending, int accepted, int closed, String customer) throws  SQLException  {
    String createEntryOrders = "INSERT INTO Orders ( pending, accepted, done, customer, ordertype) VALUES (?,?,?,?,?) ";
        try (PreparedStatement stmt = conn.prepareStatement(createEntryOrders, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, pending);
            stmt.setInt(2, accepted);
            stmt.setInt(3, closed);
            stmt.setString(4, customer);
            stmt.setString(5,SupportedOrderTypes.SIMPLE.toString());
            stmt.executeUpdate();
            return stmt.getGeneratedKeys();
        }
    }

    public static void cleanOnFail(Connection conn, int orderId){
        String query = "DELETE FROM Orders WHERE id = ?";
        try(PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setInt(1, orderId);
            stmt.executeUpdate();
        }catch (SQLException e){
            Logger.getLogger(Configurations.getInstance().getProperty("LOGGER_NAME")).severe(e.getMessage());
        }
    }
}