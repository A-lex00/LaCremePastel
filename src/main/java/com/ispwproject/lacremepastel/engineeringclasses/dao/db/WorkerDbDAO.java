package com.ispwproject.lacremepastel.engineeringclasses.dao.db;

import com.ispwproject.lacremepastel.engineeringclasses.dao.UserDAO;
import com.ispwproject.lacremepastel.engineeringclasses.dao.WorkerDAO;
import com.ispwproject.lacremepastel.model.Register;

public class WorkerDbDAO implements WorkerDAO{
    @Override
    public boolean userRegister(Register register) {
        return false;
    }
}
