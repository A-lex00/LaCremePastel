package com.ispwproject.lacremepastel.model;

public class OrderLine {

    private Product product;
    private int amount;

    public OrderLine(Product product, int amount){
        this.product = product;
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
