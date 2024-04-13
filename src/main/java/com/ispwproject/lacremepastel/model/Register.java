package com.ispwproject.lacremepastel.model;

import com.ispwproject.lacremepastel.other.SupportedRoleTypes;
import com.ispwproject.lacremepastel.other.SupportedUserTypes;

public class Register {

    private String username;
    private String cfPiva;
    private String passwd;
    private String firstname;
    private String lastname;
    private String email;
    private String billingAddress;
    private SupportedRoleTypes role;
    private SupportedUserTypes userType;

    public Register(String username, String cfPiva, String passwd, String firstname, String lastname, String email, SupportedUserTypes userType){
        this.username = username;
        this.cfPiva = cfPiva;
        this.passwd = passwd;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.userType = userType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCfPiva() {
        return cfPiva;
    }

    public void setCfPiva(String cfPiva) {
        this.cfPiva = cfPiva;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
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

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public SupportedRoleTypes getRole() {
        return role;
    }

    public void setRole(SupportedRoleTypes role) {
        this.role = role;
    }

    public SupportedUserTypes getUserType() {
        return userType;
    }

    public void setUserType(SupportedUserTypes userType) {
        this.userType = userType;
    }
}
