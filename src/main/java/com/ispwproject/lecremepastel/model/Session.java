package com.ispwproject.lecremepastel.model;

public class Session {

    private String username;
    private final String hashedPasswd;
    private int userType;

    public Session(String username, String hashedPasswd, int userType){
        this.username = username;
        this.hashedPasswd = hashedPasswd;
        this.userType = userType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashedPasswd() {
        return hashedPasswd;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
}
