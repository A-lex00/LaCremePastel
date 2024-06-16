package com.ispwproject.lacremepastel.engineeringclasses.dao;

import com.ispwproject.lacremepastel.model.Product;
import com.ispwproject.lacremepastel.other.SupportedProductCategory;

import java.util.List;

public interface ProductDAO {
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(SupportedProductCategory category);
    List<Product> getProductsByName(String name);
    boolean addProduct(Product product);
    boolean modifyProduct(Product product);
    boolean deleteProduct(int productId);
    Product getProductById(int productId);
}
