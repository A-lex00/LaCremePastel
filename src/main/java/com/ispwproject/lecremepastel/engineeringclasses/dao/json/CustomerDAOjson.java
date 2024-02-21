package com.ispwproject.lecremepastel.engineeringclasses.dao.json;

import com.ispwproject.lecremepastel.other.JsonDaoUtils;
import com.ispwproject.lecremepastel.engineeringclasses.dao.UserDAO;
import com.ispwproject.lecremepastel.model.Customer;
import com.ispwproject.lecremepastel.model.User;
import org.json.JSONObject;
import java.io.*;
import java.nio.file.Path;

public class CustomerDAOjson implements UserDAO {
    @Override
    public boolean registerUser(User u) {
        Customer c = (Customer) u;
        JsonDaoUtils utils = new JsonDaoUtils();
        //Check UserDir
        Path userDir = utils.checkUserdataDir(u.getUsername());
        //Write user data on file userInfo.json
        try{
            utils.writeUserFile(Path.of(userDir.toString(),"userInfo.json"),c.toJsonString());
            return true;
        }catch(IOException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User getUser(String username){

        JsonDaoUtils utils = new JsonDaoUtils();
        try{
            String userJson = utils.loadJsonString(username);
            JSONObject jo = new JSONObject(userJson);
            return new Customer(
                    username,
                    jo.getString("passwd"),
                    jo.getString("firstname"),
                    jo.getString("lastname"),
                    jo.getString("email"),
                    jo.getString("cfPiva"),
                    jo.getString("billingAddress")
            );
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
