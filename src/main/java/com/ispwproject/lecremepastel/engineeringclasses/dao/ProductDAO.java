package com.ispwproject.lecremepastel.engineeringclasses.dao;

import com.ispwproject.lecremepastel.engineeringclasses.bean.ProductBean;
import com.ispwproject.lecremepastel.engineeringclasses.query.ProductQuery;
import com.ispwproject.lecremepastel.engineeringclasses.singleton.Connector;
import com.ispwproject.lecremepastel.model.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public Product getProduct(int pid){
        try(ResultSet rs = ProductQuery.selectProduct(Connector.getConnection(), pid)){
            if(rs.next()){
                String name = rs.getString("name");
                String category = rs.getString("category");
                String path = rs.getString("pathPrev");
                double price = rs.getDouble("price");
                String username = rs.getString("user");
                return new Product(pid, name, category, price, path, username);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> getAllProducts(String username){
        ArrayList<Product> list = new ArrayList<>();
        try(ResultSet rs = ProductQuery.selectAllProducts(Connector.getConnection(), username)){
            while(rs.next()) {
                int pid = rs.getInt("id");
                String name = rs.getString("name");
                String category = rs.getString("category");
                String path = rs.getString("pathPrev");
                double price = rs.getDouble("price");
                list.add(new Product(pid, name, category, price, path, username));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    public Product createProduct(ProductBean p, String username) throws SQLException{
        try(ResultSet rs = ProductQuery.insertProduct(
                Connector.getConnection(),
                p.getProductName(),
                p.getCategory(),
                p.getPrice(),
                username
        )){
            return new Product(
                    rs.getInt(1),
                    p.getProductName(),
                    p.getCategory(),
                    p.getPrice(),
                    "",
                    username
            );
        }
    }

    public Boolean updateProduct(Product updated){
        try{
            ProductQuery.updateProduct(
                    Connector.getConnection(),
                    updated.getId(),
                    updated.getProductName(),
                    updated.getCategory(),
                    updated.getPrice(),
                    updated.getPathPreview(),
                    updated.getUsername()
            );
            return true;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}