package com.ispwproject.lacremepastel.engineeringclasses.query;


import com.ispwproject.lacremepastel.engineeringclasses.singleton.Configurations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

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

    public static void cleanOnFail(Connection conn, int orderId){
        String query = "DELETE FROM OrderLine WHERE `order` = ?";
        try(PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setInt(1,orderId);
            stmt.executeUpdate();
        }catch (SQLException e){
            Logger.getLogger(Configurations.getInstance().getProperty("LOGGER_NAME")).severe(e.getMessage());
        }
    }

}
