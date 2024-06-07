package com.ispwproject.lacremepastel.model;

public class Product {
    private double price;
    private String name;
    private int id;


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
}
