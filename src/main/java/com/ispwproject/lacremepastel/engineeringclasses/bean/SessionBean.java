package com.ispwproject.lacremepastel.engineeringclasses.bean;

import com.ispwproject.lacremepastel.engineeringclasses.exception.InvalidParameterException;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.SessionManager;

public class SessionBean {

    private String sid;
    private String role;
    private String username;

    public SessionBean(String sid){
        if(isSidValid(sid)){
            this.sid = sid;
        }else{
            throw new InvalidParameterException("Invalid SId");
        }
    }
    public String getRole(){
        return role;
    }
    public String getUsername(){
        return username;
    }
    public void setRole(String role){
        this.role=role;
    }
    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        if(isSidValid(sid)){
            this.sid = sid;
        }
    }

    private boolean isSidValid(String sid){
        return (sid != null && !sid.isBlank());
    }
}
