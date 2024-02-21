package com.ispwproject.lecremepastel.engineeringclasses.factory.persistence;

import com.ispwproject.lecremepastel.engineeringclasses.dao.UserDAO;
import com.ispwproject.lecremepastel.engineeringclasses.dao.json.WorkerDAOjson;

public class WorkerJsonFactory extends UserJsonFactory{

    @Override
    public UserDAO createDAO() {
        return new WorkerDAOjson();
    }
}
