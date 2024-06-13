package com.ispwproject.lacremepastel.engineeringclasses.bean;

import java.util.ArrayList;
import java.util.List;

public class OrderBean {

    private ArrayList<OrderLineBean> cart;
    private String customerName;
    private int idOrder;

    public OrderBean(String customerName, int idOrder ){
        this(idOrder,customerName,null);
    }
    public OrderBean(String customerName ) {
        this(0,customerName,null);
    }

    public OrderBean(String customerName, List<OrderLineBean> cart) {
        this(0,customerName,cart);
    }

    public OrderBean(int idOrder, String customerName, List<OrderLineBean> cart){
        if(idOrder < 0){
            this.idOrder = 0;
        }else {
            this.idOrder = idOrder;
        }

        if(customerName != null){
            this.customerName = customerName;
        }else {
            this.customerName = "";
        }

        if(cart != null) {
            this.cart = new ArrayList<>(cart);
        }else{
            this.cart = new ArrayList<>();
        }
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
