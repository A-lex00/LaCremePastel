package com.ispwproject.lecremepastel.engineeringclasses.factory.users;

import com.ispwproject.lecremepastel.engineeringclasses.dao.UserDAO;
import com.ispwproject.lecremepastel.engineeringclasses.dao.db.WorkerDAOdb;
import com.ispwproject.lecremepastel.model.Register;
import com.ispwproject.lecremepastel.model.User;
import com.ispwproject.lecremepastel.model.Worker;

public class WorkerFactory extends UserFactory{

    @Override
    public Worker createUser(Register register) {
        return new Worker(
          register.getUsername(),
          register.getPassword(),
          register.getFirstname(),
          register.getSurname(),
          register.getEmail(),
          register.getCfPiva(),
          register.getRole()
        );
    }

    @Override
    public User loadUser(String username) {
        WorkerDAOdb wd = new WorkerDAOdb();
        return wd.getUser(username);
    }

    @Override
    public UserDAO getDAO() {
        return new WorkerDAOdb();
    }

}
