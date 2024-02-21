package com.ispwproject.lecremepastel.engineeringclasses.factory.persistence;

import com.ispwproject.lecremepastel.engineeringclasses.dao.LoginDAO;
import com.ispwproject.lecremepastel.engineeringclasses.dao.json.LoginDAOjson;

public class LoginJsonFactory extends LoginDAOFactory{
    @Override
    public LoginDAO createDAO() {
        return new LoginDAOjson();
    }
}
