package com.ispwproject.lecremepastel.engineeringclasses.factory.persistence;

import com.ispwproject.lecremepastel.engineeringclasses.dao.LoginDAO;
import com.ispwproject.lecremepastel.engineeringclasses.dao.db.LoginDAOdb;

public class LoginDbFactory extends LoginDAOFactory{
    @Override
    public LoginDAO createDAO() {
        return new LoginDAOdb();
    }
}
