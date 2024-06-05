package com.ispwproject.lacremepastel.engineeringclasses.dao.json;

import com.ispwproject.lacremepastel.engineeringclasses.dao.ProductDAO;
import com.ispwproject.lacremepastel.model.Product;
import com.ispwproject.lacremepastel.model.ProductFilter;

import java.util.List;

public class ProductJsonDAO implements ProductDAO {
    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public List<Product> getProducts(ProductFilter filter) {
        return List.of();
    }

    @Override
    public void addProduct(Product product) {

    }

    @Override
    public void modifyProduct() {

    }
}
