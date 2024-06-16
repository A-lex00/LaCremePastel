package com.ispwproject.lacremepastel.model;

public class Customer extends User{

    private String billingAddress;
    private String cfPiva;


    public Customer(String username, String firstname, String lastname, String email){
        super(username, firstname, lastname, email);
        billingAddress = "";
        cfPiva = "";
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getCfPiva() {
        return cfPiva;
    }
    public void setCfPiva(String cfPiva) {
        this.cfPiva = cfPiva;
    }

}
