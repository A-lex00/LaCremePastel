package com.ispwproject.lacremepastel.engineeringclasses.dao.json;

import com.ispwproject.lacremepastel.engineeringclasses.dao.SessionDAO;
import com.ispwproject.lacremepastel.model.Login;
import com.ispwproject.lacremepastel.model.Session;

public class SessionJsonDAO implements SessionDAO {
    @Override
    public Session userLogin(Login login) {
        Session ret = null;
        if(login != null){
            //Authenticating user
        }
        return ret;
    }
}
