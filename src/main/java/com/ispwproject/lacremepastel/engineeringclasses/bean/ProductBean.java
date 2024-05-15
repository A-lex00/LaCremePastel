package com.ispwproject.lacremepastel.engineeringclasses.bean;

import com.ispwproject.lacremepastel.engineeringclasses.dao.ProductDAO;
import com.ispwproject.lacremepastel.engineeringclasses.exception.InvalidParameterException;
import com.ispwproject.lacremepastel.engineeringclasses.query.ProductQuery;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Connector;
import com.ispwproject.lacremepastel.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductBean {
    private List<Product> products=new ArrayList<>();
    private String productName;
    private double price;
    public ProductBean() {
        this.productName = "";
        this.price = 0;
    }

    public ProductBean(String productName,double price) throws InvalidParameterException {
        boolean isProductNameValid = productName != null;

        if(isProductNameValid  && price >= 0){
            this.productName = productName;
            this.price = price;
        }else{
            throw new InvalidParameterException("ProductBean: Invalid Parameters!");
        }
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        if(productName != null && !productName.isBlank()){
            this.productName = productName;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price > 0){
            this.price = price;
        }
    }
    public List<Product> getAllProducts(){
        return this.products;
    }
    public void setAllProducts(List<Product> persistenceProducts){
        this.products=persistenceProducts;
    }

}
