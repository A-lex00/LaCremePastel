package com.ispwproject.lacremepastel.engineeringclasses.bean;

import com.ispwproject.lacremepastel.model.OrderLine;

import java.util.ArrayList;
import java.util.List;

public class OrderBean {
    //falla vedere a Michael, serve per far autoincrementare la variabile
    private static int idOrder;
    private String user;
    private List<OrderLine> currentCart;
    public void OrderBean(){
        this.idOrder=++idOrder;
        this.currentCart=new ArrayList<>();
    }
    public void setUser(String actualUser){
        this.user=user;
    }
    public String getUser(){
        return user;
    }
    public void removeProduct(OrderLine actualOrderLine){
        currentCart.remove(actualOrderLine);
    }
    public void addProduct(OrderLine actualorderLine){
        this.currentCart.add(actualorderLine);
    }
    public List<OrderLine> getOrder(){
        return currentCart;
    }

}
