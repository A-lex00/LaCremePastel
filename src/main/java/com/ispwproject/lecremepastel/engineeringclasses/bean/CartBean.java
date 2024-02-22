package com.ispwproject.lecremepastel.engineeringclasses.bean;

import com.ispwproject.lecremepastel.model.Product;

public class CartBean {
    private ProductBean productBean;
    private String productName;
    private int ammout;
    private double unitPrice;

    public void setOrder(ProductBean product,int ammout){
        this.productName=product.getProductName();
        this.ammout=ammout;
        this.unitPrice=product.getPrice();
    }
    public String getProductName(){
        return productName;
    }
    public int getAmmout(){
        return ammout;
    }
    public double getUnitPrice(){
        return unitPrice;
    }
}

