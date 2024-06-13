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

    public Order (int id){
        this(id,"",new ArrayList<>(),false,false,false);
    }

    public Order(int id, String customer){
        this(id,customer,new ArrayList<>(),false,false,false);
    }
    public Order(String customerName, boolean pending, boolean accepted, boolean closed, List<OrderLine> cart ){
        this(0,customerName,cart,pending,accepted,closed);
    }

    public Order(int idOrder, String customerName, List<OrderLine> cart, boolean pending, boolean accepted, boolean closed){
        this.idOrder = idOrder;
        this.customerName = customerName;
        this.pending = pending;
        this.accepted = accepted;
        this.closed = closed;
        this.cart = new ArrayList<>(cart);
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

    public void setIdCustomer(int idOrder, String customerName){
      this.idOrder =idOrder;
      this.customerName =customerName;
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

}
