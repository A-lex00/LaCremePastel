package com.ispwproject.lecremepastel.engineeringclasses.factory.persistence;

import com.ispwproject.lecremepastel.engineeringclasses.dao.json.CustomerDAOjson;
import com.ispwproject.lecremepastel.engineeringclasses.dao.UserDAO;

public class CustomerJsonFactory extends UserJsonFactory{
    @Override
    public UserDAO createDAO() {
        return new CustomerDAOjson();
    }
}
