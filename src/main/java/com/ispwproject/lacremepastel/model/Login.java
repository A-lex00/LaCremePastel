package com.ispwproject.lacremepastel.model;

public class Login {
    private String authString;
    private String passwd;

    public Login(String authString, String passwd){
        this.authString = authString;
        this.passwd = passwd;
    }

    public String getAuthString() {
        return authString;
    }

    public void setAuthString(String authString) {
        this.authString = authString;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
