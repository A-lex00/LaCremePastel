package com.ispwproject.lacremepastel.model;

import java.util.ArrayList;
import java.util.List;

public class Worker extends User{

    private ArrayList<Product> production;
    private String role;

    public Worker(String username, String firstname, String lastname, String email){
        super(username, firstname, lastname, email);
        production = new ArrayList<>();
        role = "";
    }

    public List<Product> getProduction() {
        return production.stream().toList();
    }

    public void addProduction(Product product){
        this.production.add(product);
    }

    public Product delProduction(int index){
        return production.remove(index);
    }

    public void delProduction(Product product){
        production.remove(product);
    }

    public void delAllProduction(){
        production.clear();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
