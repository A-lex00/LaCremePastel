package org.example.model;

public class Product {
    private double price;
    private String name;

    public void insertProduct(double price, String name){
        this.price=price;
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double modyfiedPrice){
        this.price=modyfiedPrice;
    }
    public void setName(String modyfiedName){
        this.name=modyfiedName;
    }
}
