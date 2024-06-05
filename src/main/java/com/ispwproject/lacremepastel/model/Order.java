package com.ispwproject.lacremepastel.model;

import java.util.ArrayList;
import java.util.List;


public class Order {

    private int idOrder;
    private ArrayList<OrderLine> cart;
    private String customerName;
    private boolean pending;
    private boolean accepted;
    private boolean closed;
    private Worker assignedWorker;

    public Order(String customerName, boolean pending, boolean accepted, boolean closed, ArrayList<OrderLine> cart ){
        this.customerName = customerName;
        this.pending = pending;
        this.accepted = accepted;
        this.closed = closed;
        this.cart = new ArrayList<>();
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public List<OrderLine> getCart(){
        //Torna una Deep Copy di cart
        return cart.stream().toList();
    }

    public void setCart(List<OrderLine> cart){
        this.cart = new ArrayList<>(cart);
    }

    public void addLine(OrderLine orderLine){
        cart.add(orderLine);
    }

    public void deleteLine(OrderLine orderLine){
        cart.remove(orderLine);
    }

    public OrderLine getLine(int index){
        return cart.get(index);
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public void setAssignedWorker(Worker assignedWorker){
        this.assignedWorker=assignedWorker;
    }

    public Worker getAssignedWorker(){
       return assignedWorker;
    }

}
