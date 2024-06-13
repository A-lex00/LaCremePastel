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
    private ProductQuery() {
    }

    public static ResultSet getAllProduct(Connection conn) throws SQLException {
        String query = "SELECT * FROM Product";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            return stmt.executeQuery();
        }
    }

    public static ResultSet getFilteredProduct(Connection conn, String category) throws SQLException {
        String query = "SELECT * FROM Product WHERE category = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, category);
            return stmt.executeQuery();
        }
    }

    public static void addProduct(Connection conn, Product product, String name) throws SQLException {
        String query = "INSERT INTO Product (id,name, category, price, user) VALUES (?,?,?,?,?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, product.getId());
            stmt.setString(2, product.getName());
            stmt.setString(3, String.valueOf(product.getCategory()));
            stmt.setDouble(4, product.getPrice());
            stmt.setString(5, name);
            stmt.executeUpdate();
        }
    }

    public static void modifyProduct(Connection conn, Product product, String name) throws SQLException {
        String query = "UPDATE Product SET name = ?, price = ?, user = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, product.getName());
            stmt.setDouble(2, product.getPrice());
            stmt.setString(3, name);
            stmt.setInt(4, product.getId());
            stmt.executeUpdate();
        }
    }

    public static void removeProduct(Connection conn, int productId) throws SQLException {
        String query = "DELETE from Product where id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, productId);
        }
    }

    public static ResultSet getProduct(Connection conn, int productId) throws SQLException{
        String query = "SELECT * FROM Product WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, productId);
            return stmt.executeQuery();
        }
    }
}