package com.ispwproject.lacremepastel.model;

import java.util.ArrayList;


public class Order {
    private ArrayList<OrderLine> order;
    private boolean isCompleted=false;
    private boolean isPending=true;
    private int idOrder;
    private String customerName;

    public void setCompleted(int id){
        this.isCompleted=true;
    }
    public void leavePending(int id){
        this.isPending=false;
    }
   public void setCustomerName(String customer){
        this.customerName=customer;
   }

}