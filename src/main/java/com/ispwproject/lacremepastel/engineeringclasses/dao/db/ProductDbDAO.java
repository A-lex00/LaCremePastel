package com.ispwproject.lacremepastel.engineeringclasses.dao.db;

import com.ispwproject.lacremepastel.engineeringclasses.dao.ProductDAO;
import com.ispwproject.lacremepastel.engineeringclasses.exception.InvalidParameterException;
import com.ispwproject.lacremepastel.engineeringclasses.factory.PopupFactory;
import com.ispwproject.lacremepastel.engineeringclasses.query.ProductQuery;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Configurations;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Connector;
import com.ispwproject.lacremepastel.model.Product;
import com.ispwproject.lacremepastel.other.SupportedProductCategory;
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
                        rs.getDouble("price"),
                        SupportedProductCategory.valueOf(rs.getString("category"))
                ));
            }
        } catch (SQLException e) {
            Logger logger = Logger.getLogger(Configurations.LOGGER_NAME);
            logger.severe(e.getMessage());
        }
        return products;
    }

    @Override
    public List<Product> getProductsByCategory(SupportedProductCategory category) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            ResultSet rs = ProductQuery.getProductByCategory(Connector.getConnection(), category.toString());
            while (rs.next()) {
                String productName = rs.getString("name");
                double price = rs.getDouble("price");
                int id = rs.getInt("id");
                products.add(new Product(id, productName, price, category));
            }
        } catch (SQLException e) {
            Logger logger = Logger.getLogger(Configurations.LOGGER_NAME);
            logger.severe(e.getMessage());
        }
        return products;
    }

    @Override
    public List<Product> getProductsByName(String name) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            ResultSet rs = ProductQuery.getProductsByName(Connector.getConnection(),name);
            while (rs.next()) {
                int id = rs.getInt("id");
                String productName = rs.getString("name");
                double price = rs.getDouble("price");
                SupportedProductCategory category = SupportedProductCategory.valueOf(rs.getString("category"));
                products.add(new Product(id, productName, price,category));
            }
        } catch (SQLException e) {
            Logger logger = Logger.getLogger(Configurations.LOGGER_NAME);
            logger.severe(e.getMessage());
        }
        return products;
    }

    @Override
    public boolean addProduct(Product product, String name) {
        try {
            ProductQuery.addProduct(Connector.getConnection(), product, name);
        } catch (SQLException e) {
            Logger.getLogger(Configurations.LOGGER_NAME).severe(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean modifyProduct(Product product, String userName) throws InvalidParameterException {
        try {
            ProductQuery.modifyProduct(Connector.getConnection(), product, userName);
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
            PopupFactory popupFactory = new PopupFactory();
            popupFactory.createBasePopup("Prodotto Eliminato con Successo","black");
        }catch (SQLException e){
            Logger.getLogger(Configurations.LOGGER_NAME).severe(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public Product getProductById(int productId) {
        try{
            ResultSet rs = ProductQuery.getProduct(Connector.getConnection(),productId);
            if(rs.next()){
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