package com.ispwproject.lecremepastel.engineeringclasses.query;

import java.sql.*;

public class ProductQuery {

    private ProductQuery(){

    }

    public static ResultSet selectProduct(Connection conn, int productId) throws SQLException {
        String sql = "SELECT * FROM Product WHERE id = ?";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,productId);
            return ps.executeQuery();
        }
    }

    public static ResultSet selectAllProducts(Connection conn, String username) throws SQLException{
        String sql = "SELECT * FROM Product WHERE user = ?";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1,username);
            return ps.executeQuery();
        }
    }

    public static void updateProduct(Connection conn, int productId, String name, String category, double price, String pathToPreview, String username) throws SQLException{
        //Query Generation
        StringBuilder sb = new StringBuilder("UPDATE Product SET ");
        if(name != null && !name.isBlank()){
            sb.append("name = ?, ");
        }
        if(category != null && !category.isBlank()){
            sb.append("category = ?, ");
        }
        sb.append("price = ?, ");
        if(pathToPreview != null && !pathToPreview.isBlank()){
            sb.append("pathPrev = ?");
        }
        sb.append("WHERE id = ? AND user = ?");

        //Query execution
        try(PreparedStatement ps = conn.prepareStatement(sb.toString())){
            ps.setString(1,name);
            ps.setString(2,category);
            ps.setDouble(3,price);
            ps.setString(4,pathToPreview);
            ps.setInt(5,productId);
            ps.setString(6,username);
            ps.executeUpdate();
        }
    }

    public static ResultSet insertProduct(Connection conn, String name, String category, double price, String username) throws SQLException {
        String sql = "INSERT INTO Product(name, category, price, user) VALUES(?,?,?,?)";
        try(PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1, name);
            ps.setString(2, category);
            ps.setDouble(3, price);
            ps.setString(4, username);
            ps.executeUpdate();
            return ps.getGeneratedKeys();
        }
    }

}
