package com.ispwproject.lecremepastel.engineeringclasses.factory.users;

import com.ispwproject.lecremepastel.engineeringclasses.dao.db.CustomerDAOdb;
import com.ispwproject.lecremepastel.engineeringclasses.dao.UserDAO;
import com.ispwproject.lecremepastel.model.Customer;
import com.ispwproject.lecremepastel.model.Register;
import com.ispwproject.lecremepastel.model.User;

public class CustomerFactory extends UserFactory{


    @Override
    public User createUser(Register register) {
        return new Customer(
          register.getUsername(),
          register.getPassword(),
          register.getFirstname(),
          register.getSurname(),
          register.getEmail(),
          register.getCfPiva(),
          register.getBillingAddress()
        );
    }

    @Override
    public User loadUser(String username) {
        CustomerDAOdb cd = new CustomerDAOdb();
        return cd.getUser(username);
    }

    @Override
    public UserDAO getDAO() {
        return new CustomerDAOdb();
    }
}
