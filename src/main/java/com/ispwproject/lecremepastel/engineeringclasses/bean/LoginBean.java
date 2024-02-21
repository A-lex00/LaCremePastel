package com.ispwproject.lecremepastel.engineeringclasses.bean;

import com.ispwproject.lecremepastel.engineeringclasses.exception.IncorrectParametersException;

public class LoginBean {

    String authString;
    String passwd;

    public LoginBean(String authString, String passwd) throws IncorrectParametersException {
        if(authString != null && !authString.isBlank() && passwd != null && !passwd.isBlank()){
            this.authString = authString;
            this.passwd = passwd;
        }else{
            throw new IncorrectParametersException("Invalid parameters");
        }
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
