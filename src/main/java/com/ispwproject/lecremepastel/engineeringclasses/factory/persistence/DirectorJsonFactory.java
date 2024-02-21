package com.ispwproject.lecremepastel.engineeringclasses.factory.persistence;

import com.ispwproject.lecremepastel.engineeringclasses.dao.json.DirectorDAOjson;
import com.ispwproject.lecremepastel.engineeringclasses.dao.UserDAO;

public class DirectorJsonFactory extends UserJsonFactory{
    @Override
    public UserDAO createDAO() {
        return new DirectorDAOjson();
    }
}
