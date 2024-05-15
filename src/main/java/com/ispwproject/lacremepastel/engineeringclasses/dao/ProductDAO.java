package com.ispwproject.lacremepastel.engineeringclasses.dao;

import com.ispwproject.lacremepastel.model.Product;

import java.util.List;

public interface ProductDAO {
    public   List<Product> getAllProducts();
    public  void addProduct(Product product);
    public   void modifyProduct();
}
