package com.ispwproject.lacremepastel.engineeringclasses.dao.json;

import com.ispwproject.lacremepastel.engineeringclasses.dao.WorkerDAO;
import com.ispwproject.lacremepastel.model.Register;

public class WorkerJsonDAO implements WorkerDAO {
    @Override
    public boolean userRegister(Register register) {
        return false;
    }
}
