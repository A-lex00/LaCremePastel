package com.ispwproject.lacremepastel.engineeringclasses.dao.json;

import com.ispwproject.lacremepastel.engineeringclasses.dao.DirectorDAO;
import com.ispwproject.lacremepastel.model.Register;

public class DirectorJsonDAO implements DirectorDAO {
    @Override
    public boolean userRegister(Register register) {
        return false;
    }
}
