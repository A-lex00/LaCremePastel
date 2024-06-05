package com.ispwproject.lacremepastel.engineeringclasses.dao.db;

import com.ispwproject.lacremepastel.engineeringclasses.dao.ProductDAO;
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
        List<Product> products;
        products= ProductQuery.getAllProduct(Connector.getConnection());
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
                products.add(new Product(productName,price));
            }
        }catch (SQLException e){
            Logger logger = Logger.getLogger(Configurations.getInstance().getProperty("LOGGER_NAME"));
            logger.severe(e.getMessage());
        }
        return products;
    }

    @Override
    public void addProduct(Product product) {}

    @Override
    public void modifyProduct() {}
}
