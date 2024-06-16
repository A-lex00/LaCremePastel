package com.ispwproject.lacremepastel.engineeringclasses.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerQuery{

    private CustomerQuery(){
    }

    public static void saveAdditionalInfo(Connection conn, String firstname, String lastname, String cfPiva, String billingAddress, String username) throws SQLException{
        String query = "UPDATE User SET firstname = ?, lastname = ?, `cf-piva` = ?, billingAddress = ? WHERE username = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1,firstname);
            stmt.setString(2,lastname);
            stmt.setString(3,cfPiva);
            stmt.setString(4,billingAddress);
            stmt.setString(5,username);
            stmt.executeUpdate();
        }
    }
}
