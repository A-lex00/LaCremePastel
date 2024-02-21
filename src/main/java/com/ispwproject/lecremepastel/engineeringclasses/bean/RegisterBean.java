package com.ispwproject.lecremepastel.engineeringclasses.bean;

import com.ispwproject.lecremepastel.engineeringclasses.exception.IncorrectParametersException;
import java.util.regex.Pattern;

public class RegisterBean {
    private String email;
    private String cnfEmail;
    private String username;
    private String firstname;
    private String surname;
    private String password;
    private String cnfPass;
    private String cfPiva;
    private boolean worker;
    private boolean director;
    private boolean customer;
    private String billingAddress;
    private String role;
    private int userType;

    public RegisterBean(

            String email,
            String cnfEmail,
            String username,
            String firstname,
            String surname,
            String password,
            String cnfPass,
            String cfPiva,
            String role,
            String billingAddress,
            boolean worker,
            boolean director,
            boolean customer

    ) throws IncorrectParametersException {
        boolean isEmailValid = checkEmail(email);
        boolean isUsernameValid = username != null && !username.isBlank();
        boolean isFirstnameValid = firstname != null && !firstname.isBlank();
        boolean isSurnameValid = surname != null && !surname.isBlank();
        boolean isPasswdValid = password != null && cnfPass != null && !password.isBlank() && !cnfPass.isBlank();
        boolean isUserSelected = (worker || customer || director);

        if(isEmailValid && isUsernameValid && isFirstnameValid && isSurnameValid && isPasswdValid && isUserSelected){
            this.email = email;
            this.cnfEmail=cnfEmail;
            this.username = username;
            this.firstname = firstname;
            this.surname = surname;
            this.password = password;

            this.cnfPass=cnfPass;
            this.cfPiva= cfPiva;

            this.role =role;
            this.billingAddress =billingAddress;

            this.worker = worker;
            this.customer = customer;
            this.director = director;

            this.setUserType();
        }else{
            throw new IncorrectParametersException("Invalid User Parameters");
        }
    }
    private boolean checkEmail(String email){
        //Check Email format
        if(email != null){
            String regexPattern = "^(.+)@(\\S+)$";
            return Pattern.compile(regexPattern).matcher(email).matches();
        }
        return false;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(this.checkEmail(email)){
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

    public void setUserType(){
        if(worker){
            userType = 3;
        }else if(customer){
            userType = 2;
        }else{
            userType = 1;
        }
    }

    public String getCnfEmail() {
        return cnfEmail;
    }

    public void setCnfEmail(String cnfEmail) {
        if(cnfEmail != null){
            this.cnfEmail = cnfEmail;
        }
    }

    public String getCnfPass() {
        return cnfPass;
    }

    public void setCnfPass(String cnfPass) {
        if(cnfPass != null){
            this.cnfPass = cnfPass;
        }
    }

    public void checkAll() throws IncorrectParametersException{
        if(!email.equals(cnfEmail)){
            throw new IncorrectParametersException("Email not matching");
        }else if(!password.equals(cnfPass)){
            throw new IncorrectParametersException("Password not matching");
        }
    }
}
