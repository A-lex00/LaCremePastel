package com.ispwproject.lecremepastel.engineeringclasses.dao.json;

import com.ispwproject.lecremepastel.engineeringclasses.dao.LoginDAO;
import com.ispwproject.lecremepastel.model.Session;
import com.ispwproject.lecremepastel.other.JsonDaoUtils;
import org.json.JSONObject;

import java.io.IOException;

public class LoginDAOjson implements LoginDAO {
    @Override
    public Session loginUser(String username) {
        JsonDaoUtils utils = new JsonDaoUtils();
        try{
            String authJson = utils.loadJsonString(username);
            if(authJson != null){
                JSONObject jo = new JSONObject(authJson);
                return new Session(
                        jo.getString("username"),
                        jo.getString("passwd"),
                        jo.getInt("usertype")
                );
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return null;
    }
}
