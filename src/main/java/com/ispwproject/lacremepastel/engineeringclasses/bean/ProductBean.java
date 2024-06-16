package com.ispwproject.lacremepastel.engineeringclasses.bean;

import com.ispwproject.lacremepastel.engineeringclasses.exception.InvalidParameterException;
import com.ispwproject.lacremepastel.other.SupportedProductCategory;

public class ProductBean {

    private int id;
    private String productName;
    private double price;
    private SupportedProductCategory category;
    private String owner;

    public ProductBean(int id, String productName, double price, String category, String owner) {
        boolean isProductNameValid = productName != null;
        boolean isPriceValid = price > 0;
        boolean isCategoryValid = category != null && !category.isBlank();
        boolean isOwnerValid = owner != null && !owner.isBlank();

        if(isProductNameValid && isPriceValid && isCategoryValid && isOwnerValid){
            this.productName = productName;
            this.id = id;
            this.price = price;
            this.category = SupportedProductCategory.valueOf(category);
            this.owner = owner;
        }else{
            throw new InvalidParameterException("ProductBean: Invalid Parameters!");
        }
    }

    public ProductBean(String productName, double price, String category, String owner) {
        this(0, productName, price, category, owner);
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SupportedProductCategory getCategory() {
        return category;
    }

    public void setCategory(SupportedProductCategory category) {
        this.category = category;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return id+") "+productName + "\t" + price + "€";
    }
}
