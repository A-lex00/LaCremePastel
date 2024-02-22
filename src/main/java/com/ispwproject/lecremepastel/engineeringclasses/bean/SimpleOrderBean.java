package com.ispwproject.lecremepastel.engineeringclasses.bean;

import java.util.List;
import java.security.InvalidParameterException;
import java.util.ArrayList;

public class SimpleOrderBean {
    private int id;
    private String customer;
    private final ArrayList<OrderLineBean> productList;
    private boolean accepted;
    private boolean pending;

    public SimpleOrderBean(){
        this(-1,"",false,true);
    }

    public SimpleOrderBean(int id, String customer, boolean accepted, boolean pending) throws InvalidParameterException {
        if(customer == null) {
            throw new InvalidParameterException();
        }
        this.id = id;
        this.customer = customer;
        this.productList = new ArrayList<>();
        this.pending = pending;
        this.accepted = accepted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        if(customer != null){
            this.customer = customer;
        }
    }

    public List<OrderLineBean> getProductList() {
        return productList;
    }

    public void addOrderLine(OrderLineBean orderLineBean){
        if(orderLineBean != null){
            productList.add(orderLineBean);
        }
    }

    public void delOrderLine(OrderLineBean orderLineBean){
        productList.remove(orderLineBean);
    }
}
