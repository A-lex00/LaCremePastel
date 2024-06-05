package com.ispwproject.lacremepastel.engineeringclasses.query;

import com.ispwproject.lacremepastel.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductQuery {
    private ProductQuery(){}
    public static List<Product> getAllProduct(Connection conn){
            String query = "SELECT * FROM Product";
            List<Product> productList = new ArrayList<>();
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                ResultSet resultSet = stmt.executeQuery();
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    double price = resultSet.getDouble("price");
                    Product product=new Product(name,price);
                    productList.add(product);
                }
                return productList;
            }catch (SQLException e) {
                throw new RuntimeException(e);
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
