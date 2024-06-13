package com.ispwproject.lacremepastel.engineeringclasses.bean;

import com.ispwproject.lacremepastel.engineeringclasses.exception.InvalidParameterException;

public class OrderLineBean {
    private ProductBean productBean;
    private int amount;

    public OrderLineBean(ProductBean productBean, int amount) {
        if(productBean == null || amount < 0) {
            throw new InvalidParameterException("OrderLineBean: Invalid data");
        }
        this.productBean = productBean;
        this.amount = amount;
    }

    public ProductBean getProductBean() {
        return productBean;
    }

    public String getProductName(){
        return this.productBean.getProductName();
    }

    public  double getPrice(){
        return  this.productBean.getPrice();
    }

    public void setProductBean(ProductBean productBean) {
        this.productBean = productBean;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return productBean.toString() + " Amount: " + amount + " Final Price: " + productBean.getPrice()*amount;
    }
}
