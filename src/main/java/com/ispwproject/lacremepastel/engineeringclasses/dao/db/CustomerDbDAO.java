package com.ispwproject.lacremepastel.engineeringclasses.dao.db;

import com.ispwproject.lacremepastel.engineeringclasses.dao.CustomerDAO;
import com.ispwproject.lacremepastel.engineeringclasses.dao.UserDAO;
import com.ispwproject.lacremepastel.model.Register;

public class CustomerDbDAO implements CustomerDAO{

    @Override
    public boolean userRegister(Register register) {
        return false;
    }
}
