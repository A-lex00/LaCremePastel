package com.ispwproject.lacremepastel.engineeringclasses.factory;

import com.ispwproject.lacremepastel.engineeringclasses.dao.CustomerDAO;
import com.ispwproject.lacremepastel.engineeringclasses.dao.DirectorDAO;
import com.ispwproject.lacremepastel.engineeringclasses.dao.UserDAO;
import com.ispwproject.lacremepastel.engineeringclasses.dao.WorkerDAO;
import com.ispwproject.lacremepastel.other.SupportedUserTypes;

public class UserDAOFactory {

    public UserDAO getFactory(SupportedUserTypes type){
        UserDAO userDAO;
        switch (type){
            case CUSTOMER -> userDAO = new CustomerDAO();
            case DIRECTOR -> userDAO = new DirectorDAO();
            case WORKER -> userDAO = new WorkerDAO();
            default -> throw new IllegalStateException("UserDAOFactory: not a valid type: "+type);
        }
        return userDAO;
    }
}
