package com.ispwproject.lecremepastel.engineeringclasses.bean;

import com.ispwproject.lecremepastel.engineeringclasses.exception.IncorrectParametersException;

public class SessionBean {
    private String username;
    private final String hashedPasswd;
    private int userType;

    public SessionBean(String username, String hashedPasswd, int userType) throws IncorrectParametersException {
        if(username != null && !username.isBlank() && hashedPasswd != null && !hashedPasswd.isBlank() && userType >= 0){
            this.username = username;
            this.hashedPasswd = hashedPasswd;
            this.userType = userType;
        }else{
            throw new IncorrectParametersException("UserBean: Invalid username");
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if(username != null){
            this.username = username;
        }
    }

    public String getHashedPasswd(){
        return hashedPasswd;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof SessionBean ub){
            return this.username.equals(ub.username);
        }
        return false;
    }
}
