package com.ispwproject.lecremepastel.engineeringclasses.bean;

import java.util.List;
import java.security.InvalidParameterException;
import java.util.ArrayList;

public class SimpleOrderBean {
    private int id;
    private String customer;
    private final ArrayList<OrderLineBean> productList;

    public SimpleOrderBean(){
        this(-1,"");
    }

    public SimpleOrderBean(int id, String customer) throws InvalidParameterException {
        if(customer == null) {
            throw new InvalidParameterException();
        }
        this.id = id;
        this.customer = customer;
        this.productList = new ArrayList<>();
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
