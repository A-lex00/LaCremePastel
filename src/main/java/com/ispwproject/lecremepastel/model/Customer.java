package com.ispwproject.lecremepastel.model;

import com.ispwproject.lecremepastel.engineeringclasses.singleton.Configurations;
import org.json.JSONObject;

public class Customer extends User{
    private String billingAddress;

    public Customer(String username, String hashedPasswd, String firstname, String surname, String email, String cfPiva, String billingAddress){
        super(username,hashedPasswd,firstname,surname,email,cfPiva);
        this.billingAddress = billingAddress;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    @Override
    public String toString() {
        String s = "Customer{username=" + username +
                ", firstname=" + firstname +
                ", lastname=" + lastname +
                ", email=" + email +
                ", cf/Piva=" + cfPiva +
                ", billingAddress=" + billingAddress +
                ", notices[\n";
        StringBuilder sb = new StringBuilder(s);
        for(Notice n : notices){
            sb.append('\t').append(n).append('\n');
        }
        sb.append("]}");
        return sb.toString();
    }

    @Override
    protected JSONObject toJson(){
        String usertype = Configurations.getInstance().getProperty("CUSTOMER");
        JSONObject jo = super.toJson();
        jo.put("billingAddress",billingAddress);
        jo.put("usertype",usertype);
        return jo;
    }

    @Override
    public String toJsonString() {
        return toJson().toString();
    }
}
