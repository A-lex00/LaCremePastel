package com.ispwproject.lecremepastel.engineeringclasses.bean;

import com.ispwproject.lecremepastel.engineeringclasses.exception.IncorrectParametersException;

public class ProductBean {

    private String productName;
    private String category;
    private double price;

    public ProductBean(String productName, String category, double price) throws IncorrectParametersException{
        boolean isProductNameValid = productName != null && !productName.isBlank();
        boolean isCategoryValid = category != null && !category.isBlank();

        if(isProductNameValid && isCategoryValid && price > 0){
            this.productName = productName;
            this.category = category;
            this.price = price;
        }else{
            throw new IncorrectParametersException("ProductBean: Invalid Paameters!");
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        if(category != null && !category.isBlank()){
            this.category = category;
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
}
