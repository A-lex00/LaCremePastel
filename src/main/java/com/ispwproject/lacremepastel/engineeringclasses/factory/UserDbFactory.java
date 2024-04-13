package com.ispwproject.lacremepastel.engineeringclasses.factory;

import com.ispwproject.lacremepastel.engineeringclasses.dao.CustomerDAO;
import com.ispwproject.lacremepastel.engineeringclasses.dao.DirectorDAO;
import com.ispwproject.lacremepastel.engineeringclasses.dao.UserDAO;
import com.ispwproject.lacremepastel.engineeringclasses.dao.WorkerDAO;
import com.ispwproject.lacremepastel.engineeringclasses.dao.db.CustomerDbDAO;
import com.ispwproject.lacremepastel.engineeringclasses.dao.db.DirectorDbDAO;
import com.ispwproject.lacremepastel.engineeringclasses.dao.db.WorkerDbDAO;
import com.ispwproject.lacremepastel.other.SupportedUserTypes;

public class UserDbFactory extends UserDAOFactory{
    @Override
    public UserDAO getFactory(SupportedUserTypes type) {
        UserDAO dao = null;
        switch (type){
            case CUSTOMER -> dao = createCustomerDAO();
            case DIRECTOR -> dao = createDirectorDAO();
            case WORKER -> dao = createWorkerDAO();
        }
        return dao;
    }

    @Override
    public DirectorDAO createDirectorDAO() {
        return new DirectorDbDAO();
    }

    @Override
    public CustomerDAO createCustomerDAO() {
        return new CustomerDbDAO();
    }

    @Override
    public WorkerDAO createWorkerDAO() {
        return new WorkerDbDAO();
    }
}
