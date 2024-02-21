package com.ispwproject.lecremepastel.model;

public class Register {

    private String email;
    private String username;
    private String firstname;
    private String surname;
    private String password;
    private String cfPiva;
    private String billingAddress;
    private String role;
    private int userType;

    public Register(
            String email,
            String username,
            String firstname,
            String surname,
            String password,
            String cfPiva,
            String role,
            String billingAddress,
            int userType
    ){
        this.email = email;
        this.username = username;
        this.firstname = firstname;
        this.surname = surname;
        this.password = password;
        this.cfPiva= cfPiva;
        this.role = role;
        this.billingAddress = billingAddress;
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCfPiva() {
        return cfPiva;
    }

    public void setCfPiva(String cfPiva) {
        this.cfPiva = cfPiva;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
}
