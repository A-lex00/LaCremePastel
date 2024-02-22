package com.ispwproject.lecremepastel.engineeringclasses.bean;

import com.ispwproject.lecremepastel.engineeringclasses.exception.IncorrectParametersException;

import java.util.Objects;

public class ProductBean {

    private int id;
    private String productName;
    private String category;
    private double price;

    public ProductBean() {
        this.id = -1;
        this.productName = "";
        this.category = "";
        this.price = 0;
    }

    public ProductBean(int id, String productName, String category, double price) throws IncorrectParametersException{
        boolean isProductNameValid = productName != null;
        boolean isCategoryValid = category != null;

        if(isProductNameValid && isCategoryValid && price >= 0){
            this.id = id;
            this.productName = productName;
            this.category = category;
            this.price = price;
        }else{
            throw new IncorrectParametersException("ProductBean: Invalid Parameters!");
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
    public int getId(){
        return id;
    }
    public void setId(int id){
        if(id>0){
           this.id=id;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductBean that = (ProductBean) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Codice prodotto :'" + id + '\'' +
                ", Nome prodotto :'" + productName + '\'' +
                ", Categoria :'" + category + '\'' +
                ", Prezzo :" + price + "€";
    }
}
