package com.ispwproject.lecremepastel.engineeringclasses.dao.db;

import com.ispwproject.lecremepastel.engineeringclasses.dao.UserDAO;
import com.ispwproject.lecremepastel.engineeringclasses.query.CustomerQuery;
import com.ispwproject.lecremepastel.engineeringclasses.singleton.Configurations;
import com.ispwproject.lecremepastel.engineeringclasses.singleton.Connector;
import com.ispwproject.lecremepastel.model.Customer;
import com.ispwproject.lecremepastel.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAOdb implements UserDAO {

    private final int USERTYPE = Integer.parseInt(Configurations.getInstance().getProperty("CUSTOMER"));

    @Override
    public boolean registerUser(User u) {
        Customer c = (Customer) u;
        try {
            CustomerQuery.insertCustomer(
                    Connector.getConnection(),
                    c.getUsername(),
                    c.getCfPiva(),
                    c.getPasswd(),
                    c.getFirstname(),
                    c.getLastname(),
                    c.getEmail(),
                    c.getBillingAddress(),
                    USERTYPE
            );
            return true;
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public User getUser(String username) {
        try (ResultSet rs = CustomerQuery.selectCustomer(Connector.getConnection(), username)) {
            if (rs.next()) {
                String hashedPasswd = rs.getString("password");
                String firstname = rs.getString("firstname");
                String surname = rs.getString("lastname");
                String email = rs.getString("email");
                String cfPiva = rs.getString("cf-piva");
                String billingAddress = rs.getString("billing");
                return new Customer(
                        username,
                        hashedPasswd,
                        firstname,
                        surname,
                        email,
                        cfPiva,
                        billingAddress
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
