package com.ispwproject.lecremepastel.engineeringclasses.factory.users;

import com.ispwproject.lecremepastel.engineeringclasses.dao.db.DirectorDAOdb;
import com.ispwproject.lecremepastel.engineeringclasses.dao.UserDAO;
import com.ispwproject.lecremepastel.model.Director;
import com.ispwproject.lecremepastel.model.Register;
import com.ispwproject.lecremepastel.model.User;

public class DirectorFactory extends UserFactory{

    @Override
    public User createUser(Register register) {
        return new Director(
          register.getUsername(),
          register.getPassword(),
          register.getFirstname(),
          register.getSurname(),
          register.getEmail(),
          register.getCfPiva()
        );
    }

    @Override
    public User loadUser(String username) {
        DirectorDAOdb dd = new DirectorDAOdb();
        return dd.getUser(username);
    }

    @Override
    public UserDAO getDAO() {
        return new DirectorDAOdb();
    }
}
