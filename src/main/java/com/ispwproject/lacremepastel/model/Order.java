package com.ispwproject.lacremepastel.model;

import java.util.ArrayList;

public class Order {
    private ArrayList<Product> cart;
    private int idOrder;

    public void addOrder(Product product){
        cart.add(product);
    }
    public ArrayList<Product> getOrder(int idOrder){
        return cart;
    }
}
