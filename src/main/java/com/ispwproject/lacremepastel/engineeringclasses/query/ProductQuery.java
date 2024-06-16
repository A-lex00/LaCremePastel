package com.ispwproject.lacremepastel.engineeringclasses.query;

import com.ispwproject.lacremepastel.model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductQuery {
    private ProductQuery() {
    }

    public static ResultSet getAllProduct(Connection conn) throws SQLException {
        String query = "SELECT id,name,category,price,user FROM Product WHERE available = 1";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            return stmt.executeQuery();
        }
    }

    public static ResultSet getProductByCategory(Connection conn, String category) throws SQLException {
        String query = "SELECT id,name,category,price,user FROM Product WHERE category = ? AND available = 1";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, category);
            return stmt.executeQuery();
        }
    }

    public static void addProduct(Connection conn, Product product) throws SQLException {
        String query = "INSERT INTO Product (id,name, category, price, user) VALUES (?,?,?,?,?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, product.getId());
            stmt.setString(2, product.getName());
            stmt.setString(3, String.valueOf(product.getCategory()));
            stmt.setDouble(4, product.getPrice());
            stmt.setString(5, product.getOwner());
            stmt.executeUpdate();
        }
    }

    public static void modifyProduct(Connection conn, Product product) throws SQLException {
        String query = "UPDATE Product SET name = ?, category = ?, price = ?, user = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getCategory().toString());
            stmt.setDouble(3, product.getPrice());
            stmt.setString(4, product.getOwner());
            stmt.setInt(5, product.getId());
            stmt.executeUpdate();
        }
    }

    public static void removeProduct(Connection conn, int productId) throws SQLException {
        String query = "UPDATE Product SET available = 0 WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, productId);
                stmt.executeUpdate();
        }
    }

    public static ResultSet getProduct(Connection conn, int productId) throws SQLException{
        String query = "SELECT id,name,category,price,user FROM Product WHERE id = ? AND available = 1";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, productId);
            return stmt.executeQuery();
        }
    }

    public static ResultSet getProductsByName(Connection conn, String name) throws SQLException{
        String query = "SELECT id,name,category,price,user FROM Product WHERE name LIKE ? AND available = 1";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, "%"+name+"%");
            return stmt.executeQuery();
        }
    }
}