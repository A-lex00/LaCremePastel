package com.ispwproject.lacremepastel.engineeringclasses.bean;

import com.ispwproject.lacremepastel.model.OrderLine;

import java.util.ArrayList;
import java.util.List;

public class OrderBean {

    private ArrayList<OrderLine> cart;
    private String customerName;

    public OrderBean(String customerName) {
        this.cart = new ArrayList<>();
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void addLine(OrderLine orderLine){
        this.cart.add(orderLine);
    }

    public OrderLine getLine(int index){
        return this.cart.get(index);
    }

    public void deleteLine(OrderLine orderLine){
        this.cart.remove(orderLine);
    }


    public ArrayList<OrderLine> getAllOrder() {
        return this.cart;
    }
    public void setCart(List<OrderLine> orderLine){
        this.cart = (ArrayList<OrderLine>) orderLine;
    }
    public int getLength(){
        return this.cart.size();
    }


}
