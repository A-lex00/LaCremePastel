package com.ispwproject.lacremepastel.engineeringclasses.bean;

import com.ispwproject.lacremepastel.engineeringclasses.dao.CustomerDAO;

import java.util.List;

public class CustomerBean {
    public CustomerBean(){}
    private List<String> allCustomer;
    public  void  loadCustomers(List<String> customers){
        this.allCustomer=customers;
    }
    public List<String> getAllCustomers(){
        return allCustomer;
    }
}
