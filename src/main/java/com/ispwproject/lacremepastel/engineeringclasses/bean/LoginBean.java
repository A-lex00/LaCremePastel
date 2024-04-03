package com.ispwproject.lacremepastel.engineeringclasses.bean;

import com.ispwproject.lacremepastel.engineeringclasses.exception.InvalidParameterException;
import com.ispwproject.lacremepastel.other.SupportedUserTypes;

public class LoginBean {

    private String authString;
    private String passwd;

    public LoginBean(String authString, String passwd) throws InvalidParameterException {
        if(isAuthStringValid(authString) && isPasswdValid(passwd)){
            this.authString = authString;
            this.passwd = passwd;
        }else{
            throw new InvalidParameterException("Invalid parameters");
        }
    }

    public String getAuthString() {
        return authString;
    }

    public void setAuthString(String authString) {
        if(isAuthStringValid(authString)) {
            this.authString = authString;
        }
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        if(isPasswdValid(passwd)) {
            this.passwd = passwd;
        }
    }

    private boolean isAuthStringValid(String authString){
        return (authString != null && !authString.isBlank());
    }

    private boolean isPasswdValid(String passwd){
        return (passwd != null && !passwd.isBlank());
    }

}
