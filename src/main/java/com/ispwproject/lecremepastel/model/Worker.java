package com.ispwproject.lecremepastel.model;

import com.ispwproject.lecremepastel.engineeringclasses.singleton.Configurations;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Worker extends User{
    private String role;
    private final ArrayList<Product> production;

    public Worker(String username, String hashedPasswd, String firstname, String surname, String email, String cfPiva, String role){
        super(username, hashedPasswd, firstname,surname,email,cfPiva);
        this.role = role;
        production = new ArrayList<>();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean addProduct(Product p){
        return production.add(p);
    }

    public Product getProduct(int index){
        return production.get(index);
    }

    public List<Product> getAllProducts(){
        return production.stream().toList();
    }

    public Boolean delProduct(Product p){
        return production.remove(p);
    }

    public void delAllProducts(){
        production.clear();
    }

    @Override
    public String toString() {
        String s = "Worker{" +
                "username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", surname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", production[\n";
        StringBuilder sb = new StringBuilder(s);
        for(Product p : production){
            sb.append('\t').append(p).append('\n');
        }
        sb.append("], notices[\n");
        for(Notice n : notices){
            sb.append('\t').append(n).append('\n');
        }
        sb.append("]}");
        return sb.toString();
    }

    @Override
    protected JSONObject toJson(){
        String usertype = Configurations.getInstance().getProperty("WORKER");
        JSONObject jo = super.toJson();
        jo.put("role",role);
        jo.put("usertype",usertype);
        return jo;
    }

    @Override
    public String toJsonString() {
        return toJson().toString();
    }
}
