package com.ispwproject.lacremepastel.engineeringclasses.dao;

import com.ispwproject.lacremepastel.model.Register;

public interface CustomerDAO extends UserDAO{
    @Override
    default boolean userRegister(Register register) {
        return false;
    }
}
