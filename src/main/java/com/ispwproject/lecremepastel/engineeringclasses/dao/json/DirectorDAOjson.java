package com.ispwproject.lecremepastel.engineeringclasses.dao.json;

import com.ispwproject.lecremepastel.other.JsonDaoUtils;
import com.ispwproject.lecremepastel.engineeringclasses.dao.UserDAO;
import com.ispwproject.lecremepastel.model.Director;
import com.ispwproject.lecremepastel.model.User;
import org.json.JSONObject;

import java.io.*;
import java.nio.file.Path;

public class DirectorDAOjson implements UserDAO {
    @Override
    public boolean registerUser(User u) {
        Director d = (Director) u;
        JsonDaoUtils utils = new JsonDaoUtils();
        //Check UserDir
        Path userDir = utils.checkUserdataDir(u.getUsername());
        //Write user data on file userInfo.json
        try{
            utils.writeUserFile(Path.of(userDir.toString(),"userInfo.json"),d.toJsonString());
            return true;
        }catch(IOException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User getUser(String username) {
        JsonDaoUtils utils = new JsonDaoUtils();
        try{
            String userJson = utils.loadJsonString(username);
            JSONObject jo = new JSONObject(userJson);
            return new Director(
                    username,
                    jo.getString("passwd"),
                    jo.getString("firstname"),
                    jo.getString("lastname"),
                    jo.getString("email"),
                    jo.getString("cfPiva")
            );
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
