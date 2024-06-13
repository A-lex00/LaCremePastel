package com.ispwproject.lacremepastel.engineeringclasses.bean;

import java.util.ArrayList;
import java.util.List;

public class OrderBean {

    private ArrayList<OrderLineBean> cart;
    private String customerName;
    private int idOrder;

    public OrderBean(String customerName, int idOrder ){
        this.customerName = customerName;
        this.idOrder = idOrder;
    }
    public OrderBean(String customerName ) {
        this.cart = new ArrayList<>();
        this.customerName = customerName;
    }

    public OrderBean(String customerName, List<OrderLineBean> cart) {
        this.cart = new ArrayList<>(cart);
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void addLine(OrderLineBean orderLine){
        this.cart.add(orderLine);
    }

    public OrderLineBean getLine(int index){
        return this.cart.get(index);
    }

    public void deleteLine(OrderLineBean orderLine){
        this.cart.remove(orderLine);
    }


    public List<OrderLineBean> getAllOrder() {
        return this.cart.stream().toList();
    }

    public void setCart(List<OrderLineBean> cart){
        this.cart = new ArrayList<>(cart);
    }

    public int getLength(){
        return this.cart.size();
    }


    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }
}
