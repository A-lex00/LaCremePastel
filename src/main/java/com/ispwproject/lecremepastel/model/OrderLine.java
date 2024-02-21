package com.ispwproject.lecremepastel.model;

import java.io.IOException;
// COMPONENT --> AKA: Consumption
public class OrderLine {
    private Product product;
    private int amount;

    public OrderLine(Product p, int amount) throws IOException, ClassNotFoundException{
        this.amount = amount;
        this.product = p.deepCopy();
    }

    public Product getProduct() throws IOException, ClassNotFoundException{
        return product.deepCopy();
    }

    public void setProduct(Product product) throws IOException, ClassNotFoundException{
        this.product = product.deepCopy();
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    @Override
    public String toString() {
        return "OrderLine{" +
                "product=" + product +
                ", amount=" + amount +
                '}';
    }
}
