package com.ispwproject.lecremepastel.model;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class User {
    protected String username;
    protected String hashedPasswd;
    protected String firstname;
    protected String lastname;
    protected String email;
    protected String cfPiva;
    protected ArrayList<Notice> notices;

    public User(String username, String firstname, String lastname, String email, String cfPiva){
        this(username,"",firstname, lastname,email, cfPiva);
    }

    public User(String username, String hashedPasswd, String firstname, String lastname, String email, String cfPiva){
        this.username = username;
        this.hashedPasswd = hashedPasswd;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.cfPiva = cfPiva;
        notices = new ArrayList<>();
    }

    public String getUsername(){ return username;}

    public void setUsername(String username){ this.username = username;}

    public String getPasswd(){
        return hashedPasswd;
    }

    public void setPasswd(String hashedPasswd){
        this.hashedPasswd = hashedPasswd;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCfPiva(){
        return this.cfPiva;
    }

    public void setCfPiva(String cfPiva){
        this.cfPiva = cfPiva;
    }

    public void addNotice(Notice n){
        notices.add(n);
    }

    public Notice getNotice(int index){
        return notices.get(index);
    }

    public List<Notice> getNotices(){
        return notices.stream().toList();
    }

    public Boolean delNotice(Notice n){
        return notices.remove(n);
    }

    public void delAllNotices(){
        notices.clear();
    }

    protected JSONObject toJson(){
        JSONObject jo = new JSONObject();
        jo.put("username",username);
        jo.put("passwd",hashedPasswd);
        jo.put("firstname",firstname);
        jo.put("lastname",lastname);
        jo.put("email",email);
        jo.put("cfPiva",cfPiva);
        return jo;
    }

    public String toJsonString(){
        return toJson().toString();
    }
}
