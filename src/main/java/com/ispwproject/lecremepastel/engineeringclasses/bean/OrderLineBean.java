package com.ispwproject.lecremepastel.engineeringclasses.bean;

import java.util.Objects;

public class OrderLineBean {

    private int orderId;
    private int productId;
    private int amount;
    private double unitPrice;

    public OrderLineBean(){
        orderId = -1;
        productId = -1;
        amount = 0;
        unitPrice=0;
    }

    public OrderLineBean(int orderId, int productId, int amount, double unitPrice){
        this.orderId = orderId;
        this.productId = productId;
        this.amount = amount;
        this.unitPrice=unitPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getTotalPrice(){
        return amount*unitPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderLineBean that = (OrderLineBean) o;
        return orderId == that.orderId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId);
    }
}
