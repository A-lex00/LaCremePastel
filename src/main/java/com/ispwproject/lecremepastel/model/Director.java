package com.ispwproject.lecremepastel.model;

import com.ispwproject.lecremepastel.engineeringclasses.singleton.Configurations;
import org.json.JSONObject;

public class Director extends User{

    public Director(String username, String firstname, String surname, String email, String cfPiva){
        super(username, firstname, surname, email, cfPiva);
    }

    public Director(String username, String passwd, String firstname, String surname, String email, String cfPiva){
        super(username, passwd, firstname, surname, email, cfPiva);
    }

    @Override
    public String toString() {
        String s =  "Director{" +
                "username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", notices[";
        StringBuilder sb = new StringBuilder(s);
        for(Notice n : notices){
            sb.append("\n\t").append(n).append('\n');
        }
        sb.append("]}");
        return sb.toString();
    }

    @Override
    protected JSONObject toJson(){
        String usertype = Configurations.getInstance().getProperty("DIRECTOR");
        JSONObject jo = super.toJson();
        jo.put("usertype",usertype);
        return jo;
    }

    @Override
    public String toJsonString() {
        return toJson().toString();
    }
}
