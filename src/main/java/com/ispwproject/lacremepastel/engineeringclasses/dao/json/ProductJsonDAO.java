package com.ispwproject.lacremepastel.engineeringclasses.dao.json;

import com.ispwproject.lacremepastel.engineeringclasses.dao.ProductDAO;
import com.ispwproject.lacremepastel.model.Product;
import com.ispwproject.lacremepastel.model.ProductFilter;
import com.ispwproject.lacremepastel.other.SupportedProductCategory;

import java.util.List;

public class ProductJsonDAO implements ProductDAO {
    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public List<Product> getProductsByCategory(SupportedProductCategory category) {
        return List.of();
    }

    @Override
    public List<Product> getProductsByName(String name) {
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
    public Product getProductById(int productId) {
        return null;
    }
}
