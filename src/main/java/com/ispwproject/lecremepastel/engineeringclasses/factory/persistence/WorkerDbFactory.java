package com.ispwproject.lecremepastel.engineeringclasses.factory.persistence;

import com.ispwproject.lecremepastel.engineeringclasses.dao.UserDAO;
import com.ispwproject.lecremepastel.engineeringclasses.dao.db.WorkerDAOdb;

public class WorkerDbFactory extends UserDbFactory{
    @Override
    public UserDAO createDAO() {
        return new WorkerDAOdb();
    }
}
