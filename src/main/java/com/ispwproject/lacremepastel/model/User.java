package com.ispwproject.lacremepastel.model;

import java.util.ArrayList;
import java.util.List;

public abstract class User {
    protected String username;
    protected String firstname;
    protected String lastname;
    protected String email;
    protected ArrayList<Notice> notices;

    protected User(String username, String firstname, String lastname, String email){
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.notices = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public void addNotice(Notice notice){
        notices.add(notice);
    }

    public Notice delNotice(int index){
        return notices.remove(index);
    }

    public void delNotice(Notice notice){
        notices.remove(notice);
    }

    public List<Notice> getNotices(){
        return notices.stream().toList();
    }

    public void delAllNotices(){
        notices.clear();
    }
}
