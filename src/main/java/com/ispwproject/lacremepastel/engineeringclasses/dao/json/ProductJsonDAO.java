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
    public boolean addProduct(Product product, String userName) {
        return false;
    }

    @Override
    public boolean modifyProduct(Product product, String userName) {
        return false;
    }

    @Override
    public boolean deleteProduct(int productId, String userName) {
        return false;
    }

    @Override
    public Product getProduct(int productId) {
        return null;
    }
}
