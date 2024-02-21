package com.ispwproject.lecremepastel.model;

import java.util.ArrayList;
import java.util.List;

public class SimpleOrder{
    private int id;
    private String customer;
    private final ArrayList<OrderLine> productList;
    private boolean pending;
    private boolean accepted;
    private boolean done;


    public SimpleOrder(String customer, boolean pending, boolean accepted, boolean done){
        this(-1,customer,pending,accepted,done);
    }

    public SimpleOrder(int id, String customer, boolean pending, boolean accepted, boolean done){
        this.id = id;
        this.customer = customer;
        productList = new ArrayList<>();
        this.pending = pending;
        this.accepted = accepted;
        this.done = done;
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
        this.customer = customer;
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

    public boolean isDone(){
        return done;
    }

    public void setDone(boolean done){
        this.done = done;
    }

    public void addProduct(OrderLine o){
        productList.add(o);
    }

    public OrderLine getProduct(int index){
        return productList.get(index);
    }

    public List<OrderLine> getAllProducts(){
        return productList.stream().toList();
    }

    public boolean delProduct(OrderLine o){
        return productList.remove(o);
    }

    public void delAllProducts(){
        productList.clear();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SimpleOrder{id='").append(id).append('\'');
        if(this.pending){
            sb.append(", pending=true'");
        }else{
            sb.append(", accepted=").append(accepted).append('\'');
        }
        if(!productList.isEmpty()){
            sb.append(", productList=[\n");
            for(OrderLine o : productList){
                sb.append('\t').append(o).append('\n');
            }
            sb.append("]}");
        }else{
            sb.append(", productList= empty}");
        }
        return sb.toString();
    }
}
