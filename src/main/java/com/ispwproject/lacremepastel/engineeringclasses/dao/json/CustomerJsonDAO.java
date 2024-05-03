package com.ispwproject.lacremepastel.engineeringclasses.dao.json;

import com.ispwproject.lacremepastel.engineeringclasses.dao.CustomerDAO;
import com.ispwproject.lacremepastel.engineeringclasses.exception.UserAlreadyExistentException;
import com.ispwproject.lacremepastel.model.Register;

import java.util.ArrayList;
import java.util.List;

public class CustomerJsonDAO implements CustomerDAO {
    @Override
    public boolean userRegister(Register register) throws UserAlreadyExistentException {
        return false;
    }

    @Override
    public List<String> getAllCustomer() {
        return null;
    }

}
