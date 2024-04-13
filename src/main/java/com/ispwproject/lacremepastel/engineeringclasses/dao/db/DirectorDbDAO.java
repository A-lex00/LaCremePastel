package com.ispwproject.lacremepastel.engineeringclasses.dao.db;

import com.ispwproject.lacremepastel.engineeringclasses.dao.DirectorDAO;
import com.ispwproject.lacremepastel.engineeringclasses.dao.UserDAO;
import com.ispwproject.lacremepastel.model.Register;

public class DirectorDbDAO implements DirectorDAO{
    @Override
    public boolean userRegister(Register register) {
        return false;
    }
}
