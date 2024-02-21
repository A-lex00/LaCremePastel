package com.ispwproject.lecremepastel.engineeringclasses.factory.persistence;

import com.ispwproject.lecremepastel.engineeringclasses.dao.db.DirectorDAOdb;
import com.ispwproject.lecremepastel.engineeringclasses.dao.UserDAO;

public class DirectorDbFactory extends UserDbFactory{
    @Override
    public UserDAO createDAO() {
        return new DirectorDAOdb();
    }
}
