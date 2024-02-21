package com.ispwproject.lecremepastel.model;

public class SpecialOrder{

    private int id;
    private String customer;
    private String content;

    public SpecialOrder(int id, String customer, String content){
        this.id = id;
        this.customer = customer;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomer(){
        return customer;
    }

    public void setCustomer(String customer){
        this.customer = customer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
