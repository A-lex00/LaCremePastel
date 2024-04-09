package com.ispwproject.lacremepastel.engineeringclasses.bean;

import com.ispwproject.lacremepastel.engineeringclasses.exception.InvalidParameterException;
import org.apache.commons.validator.routines.EmailValidator;

public class RegisterBean {

    private String username;
    private String cfPiva;
    private String passwd;
    private String firstname;
    private String lastname;
    private String email;
    private String billingAddress;
    private String role;
    private String userType;

    public RegisterBean(String username, String cfPiva, String passwd, String firstname, String lastname, String email, String userType) throws InvalidParameterException {
        if(isUsernameValid(username) &&
            isCfPivaValid(cfPiva) &&
            isPasswdValid(passwd) &&
            isFirstnameValid(firstname) &&
            isLastnameValid(lastname) &&
            isEmailValid(email)
        ){
            this.username = username;
            this.cfPiva = cfPiva;
            this.passwd = passwd;
            this.firstname = firstname;
            this.lastname = lastname;
            this.email = email;
        }else{
            throw new InvalidParameterException("Invalid Parameters");
        }
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if(isUsernameValid(username)) {
            this.username = username;
        }
    }

    public String getCfPiva() {
        return cfPiva;
    }

    public void setCfPiva(String cfPiva) {
        if(isCfPivaValid(cfPiva)) {
            this.cfPiva = cfPiva;
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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        if(isFirstnameValid(firstname)) {
            this.firstname = firstname;
        }
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        if(isLastnameValid(lastname)) {
            this.lastname = lastname;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(isEmailValid(email)) {
            this.email = email;
        }
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        if(billingAddress != null && !billingAddress.isBlank()){
            this.billingAddress = billingAddress;
        }
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        if(role != null && !role.isBlank()) {
            this.role = role;
        }
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        if(userType != null && !userType.isBlank()) {
            this.userType = userType;
        }
    }

    private boolean isUsernameValid(String username){
        return (username != null && !username.isBlank());
    }

    private boolean isPasswdValid(String passwd){
        return (passwd != null && !passwd.isBlank());
    }

    private boolean isFirstnameValid(String firstname){
        return (firstname != null && !firstname.isBlank());
    }

    private boolean isLastnameValid(String lastname){
        return (lastname != null && !lastname.isBlank());
    }

    private boolean isEmailValid(String email){
        return EmailValidator.getInstance().isValid(email);
    }

    private boolean isCfPivaValid(String cfPiva){
        //P.Iva length is 11 and CF length is 16
        return (cfPiva != null && (cfPiva.length() == 11 || cfPiva.length() == 16));
    }

}
