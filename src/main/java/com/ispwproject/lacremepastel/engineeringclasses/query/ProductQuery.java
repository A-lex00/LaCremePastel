package com.ispwproject.lacremepastel.engineeringclasses.query;

import com.ispwproject.lacremepastel.model.Product;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductQuery {
    private ProductQuery(){}
    public static ResultSet getAllProduct(Connection conn) throws SQLException{
        String query = "SELECT * FROM Product";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            return stmt.executeQuery();
        }
    }

    public static ResultSet getFilteredProduct(Connection conn, String category) throws SQLException{
        String query = "SELECT * FROM Product WHERE category = ?";
        try(PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1, category);
            return stmt.executeQuery();
        }
    }
}
