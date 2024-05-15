package com.ispwproject.lacremepastel.engineeringclasses.dao.db;

import com.ispwproject.lacremepastel.engineeringclasses.dao.ProductDAO;
import com.ispwproject.lacremepastel.engineeringclasses.query.CustomerQuery;
import com.ispwproject.lacremepastel.engineeringclasses.query.ProductQuery;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Connector;
import com.ispwproject.lacremepastel.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDbDAO implements ProductDAO {
    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        products= ProductQuery.getAllProduct(Connector.getConnection());
        return products;
    }

    @Override
    public void addProduct(Product product) {}

    @Override
    public void modifyProduct() {}
}
