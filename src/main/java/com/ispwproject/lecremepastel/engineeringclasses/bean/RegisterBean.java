package com.ispwproject.lecremepastel.engineeringclasses.bean;

import com.ispwproject.lecremepastel.engineeringclasses.exception.IncorrectParametersException;
import com.ispwproject.lecremepastel.engineeringclasses.exception.IncorrectUserSetupException;
import com.ispwproject.lecremepastel.other.EmailUtils;

public class RegisterBean {
    private String email;
    private String username;
    private String firstname;
    private String surname;
    private String password;
    private String cfPiva;
    private boolean worker;
    private boolean director;
    private boolean customer;
    private String billingAddress;
    private String role;
    private int userType;

    public RegisterBean(
            String email,
            String username,
            String password,
            boolean worker,
            boolean director,
            boolean customer

    ) throws IncorrectParametersException, IncorrectUserSetupException {
        EmailUtils emailUtils = new EmailUtils();
        boolean isEmailValid = emailUtils.checkEmail(email);
        boolean isUsernameValid = username != null && !username.isBlank();
        boolean isPasswdValid = password != null && !password.isBlank();
        boolean isUserSelected = (worker || customer || director);

        if(isEmailValid && isUsernameValid && isPasswdValid && isUserSelected){
            this.email = email;
            this.username = username;
            this.firstname = "";
            this.surname = "";
            this.password = password;
            this.cfPiva= "";

            this.role = "";
            this.billingAddress = "";

            this.worker = worker;
            this.customer = customer;
            this.director = director;

            this.setUserType();
        }else{
            throw new IncorrectParametersException("Invalid User Parameters");
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if(username != null) {
            this.username = username;
        }
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        if(firstname != null) {
            this.firstname = firstname;
        }
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if(surname != null) {
            this.surname = surname;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if(password != null) {
            this.password = password;
        }
    }

    public boolean isWorker() {
        return worker;
    }

    public void setWorker(boolean worker) {
        this.worker = worker;
    }

    public boolean isDirector() {
        return director;
    }

    public void setDirector(boolean director) {
        this.director = director;
    }

    public boolean isCustomer() {
        return customer;
    }

    public void setCustomer(boolean customer) {
        this.customer = customer;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        if(billingAddress != null) this.billingAddress = billingAddress;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        if(role != null) this.role = role;
    }

    public String getCfPiva(){
        return cfPiva;
    }

    public void setCfPiva(String cfPiva){
        if(cfPiva != null) this.cfPiva = cfPiva;
    }

    public int getUserType(){
        return userType;
    }

    public void setUserType() throws IncorrectUserSetupException{
        if(worker && !customer && !director){
            userType = 3;
        }else if(!worker && customer && !director){
            userType = 2;
        }else if(!worker && !customer && director){
            userType = 1;
        }else{
            throw new IncorrectUserSetupException("Invalid User Setup");
        }
    }
}
