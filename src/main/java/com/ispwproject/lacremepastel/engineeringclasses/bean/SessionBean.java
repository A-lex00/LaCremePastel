package com.ispwproject.lacremepastel.engineeringclasses.bean;

import com.ispwproject.lacremepastel.engineeringclasses.exception.InvalidParameterException;

public class SessionBean {

    private String sid;

    public SessionBean(String sid){
        if(isSidValid(sid)){
            this.sid = sid;
        }else{
            throw new InvalidParameterException("Invalid SId");
        }
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
