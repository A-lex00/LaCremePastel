package com.ispwproject.lacremepastel.engineeringclasses.dao;

import com.ispwproject.lacremepastel.engineeringclasses.exception.InvalidParameterException;
import com.ispwproject.lacremepastel.engineeringclasses.exception.UserAlreadyExistentException;
import com.ispwproject.lacremepastel.model.Register;

import java.util.List;

public interface UserDAO {
    boolean userRegister(Register register) throws UserAlreadyExistentException, InvalidParameterException;
    List<String> getAllCustomer();
}
