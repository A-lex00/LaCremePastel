package com.ispwproject.lecremepastel.engineeringclasses.factory.persistence;

import com.ispwproject.lecremepastel.engineeringclasses.dao.db.CustomerDAOdb;
import com.ispwproject.lecremepastel.engineeringclasses.dao.UserDAO;

public class CustomerDbFactory extends UserDbFactory{
    @Override
    public UserDAO createDAO() {
        return new CustomerDAOdb();
    }
}
