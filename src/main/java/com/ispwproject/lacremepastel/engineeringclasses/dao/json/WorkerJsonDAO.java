package com.ispwproject.lacremepastel.engineeringclasses.dao.json;

import com.ispwproject.lacremepastel.engineeringclasses.dao.WorkerDAO;
import com.ispwproject.lacremepastel.model.Register;

import java.util.List;

public class WorkerJsonDAO implements WorkerDAO {
    @Override
    public boolean userRegister(Register register) {
        return false;
    }

    @Override
    public List<String> getAllCustomer() {
        return null;
    }
}
