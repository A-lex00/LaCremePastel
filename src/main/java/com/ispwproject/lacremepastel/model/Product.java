package com.ispwproject.lacremepastel.model;

import com.ispwproject.lacremepastel.other.SupportedProductCategory;

public class Product {
    private double price;
    private String name;
    private int id;
    private SupportedProductCategory category;
    private String owner;

    public Product(int id, String name, double price, SupportedProductCategory category, String owner){
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.owner = owner;
    }
    
    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product(String name,  double price) {
        this.name=name;
        this.price=price;
    }

    public Product(String name){
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
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
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
}
