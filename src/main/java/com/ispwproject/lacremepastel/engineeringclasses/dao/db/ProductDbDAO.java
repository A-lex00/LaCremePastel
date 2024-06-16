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
        List<Product> products = new ArrayList<>();
        try{
            ResultSet rs = ProductQuery.getAllProduct(Connector.getConnection());
            products = processResultSet(rs);
        } catch (SQLException e) {
            Logger logger = Logger.getLogger(Configurations.LOGGER_NAME);
            logger.severe(e.getMessage());
        }
        return products;
    }

    @Override
    public List<Product> getProductsByCategory(SupportedProductCategory category) {
        List<Product> products = new ArrayList<>();
        try {
            ResultSet rs = ProductQuery.getProductByCategory(Connector.getConnection(), category.toString());
            products = processResultSet(rs);
        } catch (SQLException e) {
            Logger logger = Logger.getLogger(Configurations.LOGGER_NAME);
            logger.severe(e.getMessage());
        }
        return products;
    }

    @Override
    public List<Product> getProductsByName(String name) {
        List<Product> products = new ArrayList<>();
        try {
            ResultSet rs = ProductQuery.getProductsByName(Connector.getConnection(),name);
            products = processResultSet(rs);
        } catch (SQLException e) {
            Logger logger = Logger.getLogger(Configurations.LOGGER_NAME);
            logger.severe(e.getMessage());
        }
        return products;
    }

    @Override
    public boolean addProduct(Product product) {
        try {
            ProductQuery.addProduct(Connector.getConnection(), product);
        } catch (SQLException e) {
            Logger.getLogger(Configurations.LOGGER_NAME).severe(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean modifyProduct(Product product) throws InvalidParameterException {
        try {
            ProductQuery.modifyProduct(Connector.getConnection(), product);
        } catch (SQLException e) {
            Logger.getLogger(Configurations.LOGGER_NAME).severe(e.getMessage());
            return false;
        }
        return  true;
    }

    @Override
    public boolean deleteProduct(int productId) {
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
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        SupportedProductCategory.valueOf(rs.getString("category")),
                        rs.getString("user")
                );
            }
        }catch (SQLException e){
            Logger.getLogger(Configurations.LOGGER_NAME).severe(e.getMessage());
        }
        return null;
    }

    private List<Product> processResultSet(ResultSet rs) throws SQLException{
        ArrayList<Product> products = new ArrayList<>();
        while (rs.next()) {
            products.add(new Product(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getDouble("price"),
                    SupportedProductCategory.valueOf(rs.getString("category")),
                    rs.getString("user")
            ));
        }
        return products;
    }
}