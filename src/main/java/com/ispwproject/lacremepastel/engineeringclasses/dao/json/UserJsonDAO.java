package com.ispwproject.lacremepastel.engineeringclasses.dao.json;

import com.ispwproject.lacremepastel.engineeringclasses.dao.UserDAO;
import com.ispwproject.lacremepastel.model.Register;

public abstract class UserJsonDAO implements UserDAO {
    @Override
    public boolean userRegister(Register register) {
        return false;
    }
}
