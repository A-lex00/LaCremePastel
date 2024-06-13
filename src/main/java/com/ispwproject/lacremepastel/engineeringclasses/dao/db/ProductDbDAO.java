package com.ispwproject.lacremepastel.engineeringclasses.dao.db;

import com.ispwproject.lacremepastel.engineeringclasses.dao.ProductDAO;
import com.ispwproject.lacremepastel.engineeringclasses.exception.InvalidParameterException;
import com.ispwproject.lacremepastel.engineeringclasses.query.ProductQuery;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Configurations;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Connector;
import com.ispwproject.lacremepastel.model.Product;
import com.ispwproject.lacremepastel.model.ProductFilter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ProductDbDAO implements ProductDAO {
    @Override
    public List<Product> getAllProducts() {
        ArrayList<Product> products = new ArrayList<>();
        try (ResultSet rs = ProductQuery.getAllProduct(Connector.getConnection())) {
            while (rs.next()) {
                products.add(new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price")
                ));
            }
        } catch (SQLException e) {
            Logger logger = Logger.getLogger(Configurations.LOGGER_NAME);
            logger.severe(e.getMessage());
        }
        return products;
    }

    @Override
    public List<Product> getProducts(ProductFilter filter) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            ResultSet rs = ProductQuery.getFilteredProduct(Connector.getConnection(), filter.getCategory().toString());
            while (rs.next()) {
                String productName = rs.getString("name");
                double price = rs.getDouble("price");
                int id = rs.getInt("id");
                products.add(new Product(id, productName, price));
            }
        } catch (SQLException e) {
            Logger logger = Logger.getLogger(Configurations.LOGGER_NAME);
            logger.severe(e.getMessage());
        }
        return products;
    }

    @Override
    public boolean addProduct(Product product, String name) throws RuntimeException {
        try {
            ProductQuery.addProduct(Connector.getConnection(), product, name);
        } catch (SQLException e) {
            Logger.getLogger(Configurations.LOGGER_NAME).severe(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean modifyProduct(Product product, String name) throws InvalidParameterException {
        try {
            ProductQuery.modifyProduct(Connector.getConnection(), product, name);
        } catch (SQLException e) {
            Logger.getLogger(Configurations.LOGGER_NAME).severe(e.getMessage());
            return false;
        }
        return  true;
    }

    @Override
    public boolean deleteProduct(int productId, String userName) {
        try{
            ProductQuery.removeProduct(Connector.getConnection(),productId);
        }catch (SQLException e){
            Logger.getLogger(Configurations.LOGGER_NAME).severe(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public Product getProduct(int productId) {
        try{
            ResultSet rs = ProductQuery.getProduct(Connector.getConnection(),productId);
            if(rs.next()){
                System.out.println("Product DB DAO: Prodotto trovato");
                return new Product(
                        rs.getString("name"),
                        rs.getDouble("price")
                );
            }
        }catch (SQLException e){
            Logger.getLogger(Configurations.LOGGER_NAME).severe(e.getMessage());
        }
        return null;
    }
}