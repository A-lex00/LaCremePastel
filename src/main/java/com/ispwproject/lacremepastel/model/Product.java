package com.ispwproject.lacremepastel.model;

import com.ispwproject.lacremepastel.other.SupportedProductCategory;

public class Product {
    private double price;
    private String name;
    private int id;
    private SupportedProductCategory category;
    private String owner;
    private boolean visible;

    public Product(int id, String name, double price, SupportedProductCategory category, String owner){
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.owner = owner;
        this.visible = true;
    }
    
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double modifiedPrice){
        this.price=modifiedPrice;
    }
    public void setName(String modifiedName){
        this.name=modifiedName;
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

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
