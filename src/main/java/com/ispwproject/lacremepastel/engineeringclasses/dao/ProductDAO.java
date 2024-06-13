package com.ispwproject.lacremepastel.engineeringclasses.dao;

import com.ispwproject.lacremepastel.model.Product;
import com.ispwproject.lacremepastel.other.SupportedProductCategory;

import java.util.List;

public interface ProductDAO {
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(SupportedProductCategory category);
    List<Product> getProductsByName(String name);
    boolean addProduct(Product product, String userName);
    boolean modifyProduct(Product product, String userName);
    boolean deleteProduct(int productId, String userName);
    Product getProductById(int productId);
}
