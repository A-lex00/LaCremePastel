package com.ispwproject.lecremepastel.model;

import java.io.*;

public class Product implements Serializable {

    private int id;
    private String productName;
    private String category;
    private double price;
    private String pathPreview;
    private String username;

    public Product(int id, String productName, String category, double price, String pathPreview, String username){
        this.id = id;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.pathPreview = pathPreview;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPathPreview() {
        return pathPreview;
    }

    public void setPathPreview(String pathPreview) {
        this.pathPreview = pathPreview;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Product p){
            return this.id == p.id;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + productName + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", pathPreview='" + pathPreview + '\'' +
                '}';
    }

    //Is this the right place for this method?
    public Product deepCopy() throws IOException, ClassNotFoundException{
        //Serialization
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bos);
        out.writeObject(this);

        //De-serialization in brand-new object
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream in = new ObjectInputStream(bis);
        return (Product) in.readObject();
    }
}
