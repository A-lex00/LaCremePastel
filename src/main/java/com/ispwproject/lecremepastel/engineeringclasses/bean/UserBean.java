package com.ispwproject.lecremepastel.engineeringclasses.bean;

import com.ispwproject.lecremepastel.engineeringclasses.exception.IncorrectParametersException;
import com.ispwproject.lecremepastel.other.EmailUtils;

public class UserBean {
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String role;
    private String billingAddress;

    public UserBean(String username, String firstname, String lastname, String email, String role, String billingAddress) throws IncorrectParametersException {
        if(username != null && firstname != null && lastname != null && email != null && role != null && billingAddress != null){
            this.username = username;
            this.firstname = firstname;
            this.lastname = lastname;
            this.email = email;
            this.role = role;
            this.billingAddress = billingAddress;
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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        if(firstname != null){
            this.firstname = firstname;
        }
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        if(lastname != null){
            this.lastname = lastname;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        EmailUtils emailUtils = new EmailUtils();
        if(emailUtils.checkEmail(email)){
            this.email = email;
        }
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        if(role != null){
            this.role = role;
        }

    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        if(billingAddress != null){
            this.billingAddress = billingAddress;
        }
    }
}
