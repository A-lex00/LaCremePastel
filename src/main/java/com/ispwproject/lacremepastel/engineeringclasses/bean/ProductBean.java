package com.ispwproject.lacremepastel.engineeringclasses.bean;

import com.ispwproject.lacremepastel.engineeringclasses.exception.InvalidParameterException;

public class ProductBean {

    private String productName;
    private double price;

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

    @Override
    public String toString() {
        return productName + "\t" + price + "€";
    }
}
