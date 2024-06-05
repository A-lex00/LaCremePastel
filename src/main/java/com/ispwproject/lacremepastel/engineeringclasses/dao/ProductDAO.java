package com.ispwproject.lacremepastel.engineeringclasses.dao;

import com.ispwproject.lacremepastel.model.Product;
import com.ispwproject.lacremepastel.model.ProductFilter;

import java.util.List;

public interface ProductDAO {
    List<Product> getAllProducts();
    List<Product> getProducts(ProductFilter filter);
    void addProduct(Product product);
    void modifyProduct();
}
