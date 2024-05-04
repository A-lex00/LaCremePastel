package com.ispwproject.lacremepastel.engineeringclasses.dao.json;

import com.ispwproject.lacremepastel.engineeringclasses.dao.DirectorDAO;
import com.ispwproject.lacremepastel.model.Register;

import java.util.List;

public class DirectorJsonDAO implements DirectorDAO {
    @Override
    public boolean userRegister(Register register) {
        return false;
    }

    @Override
    public List<String> getAllCustomer() {
        return null;
    }
}
