package com.ispwproject.lacremepastel.engineeringclasses.bean;

import com.ispwproject.lacremepastel.engineeringclasses.exception.InvalidParameterException;
import com.ispwproject.lacremepastel.model.Product;
import com.ispwproject.lacremepastel.other.SupportedProductCategory;
import com.ispwproject.lacremepastel.other.SupportedUserTypes;

public class ProductBean {

    private int id;
    private String productName;
    private double price;
    private SupportedProductCategory category;

    public ProductBean(int id, String productName, double price, String category){
        boolean isProductNameValid = productName != null;
        if(isProductNameValid  && price >= 0){
            this.productName = productName;
            this.id = id;
            this.price = price;
            if(category != null){
                this.category = SupportedProductCategory.valueOf(category);
            }
        }else{
            throw new InvalidParameterException("ProductBean: Invalid Parameters!");
        }
    }
    public ProductBean(int id, String productName, double price) {
        this(id,productName,price,null);
    }

    public ProductBean(String productName,double price) throws InvalidParameterException {
        this(0,productName,price);
    }
    public ProductBean(String productName){
        this(0,productName,0);
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

    @Override
    public String toString() {
        return id+") "+productName + "\t" + price + "€";
    }
}
