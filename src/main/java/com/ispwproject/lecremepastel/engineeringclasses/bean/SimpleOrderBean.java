package com.ispwproject.lecremepastel.engineeringclasses.bean;

import java.util.List;
import java.security.InvalidParameterException;
import java.util.ArrayList;

public class SimpleOrderBean {
    private int id;
    private String customer;
    private final ArrayList<OrderLineBean> productList;
    private boolean pending;
    private boolean accepted;
    private boolean done;

    public SimpleOrderBean(boolean pending, boolean accepted, boolean done){
        this(-1,"",pending,accepted,done);
    }

    public SimpleOrderBean(int id, String customer, boolean pending, boolean accepted, boolean done) throws InvalidParameterException {
        this.id = id;
        this.customer = customer;
        this.pending = pending;
        this.accepted = accepted;
        this.done = done;
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

    public boolean isPending() {
        return pending;
    }

    public void setPending(boolean pending) {
        this.pending = pending;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
