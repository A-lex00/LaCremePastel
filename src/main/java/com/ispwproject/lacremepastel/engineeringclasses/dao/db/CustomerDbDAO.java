package com.ispwproject.lacremepastel.engineeringclasses.dao.db;

import com.ispwproject.lacremepastel.engineeringclasses.dao.CustomerDAO;
import com.ispwproject.lacremepastel.engineeringclasses.exception.InvalidParameterException;
import com.ispwproject.lacremepastel.engineeringclasses.exception.UserAlreadyExistentException;
import com.ispwproject.lacremepastel.engineeringclasses.query.CustomerQuery;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Configurations;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Connector;
import com.ispwproject.lacremepastel.model.Customer;
import com.ispwproject.lacremepastel.model.Register;
import com.ispwproject.lacremepastel.other.SupportedUserTypes;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CustomerDbDAO implements CustomerDAO {

    @Override
    public boolean userRegister(Register register) throws UserAlreadyExistentException, InvalidParameterException {
        if (register != null) {
            try {
                CustomerQuery.addCustomer(
                        Connector.getConnection(),
                        register.getUsername(),
                        BCrypt.hashpw(register.getPasswd(), BCrypt.gensalt()),
                        register.getFirstname(),
                        register.getLastname(),
                        register.getEmail(),
                        register.getCfPiva(),
                        register.getBillingAddress(),
                        SupportedUserTypes.CUSTOMER.toString()
                );
                return true;
            } catch (SQLException e) {
                Logger.getLogger(Configurations.getInstance().getProperty("LOGGER_NAME")).severe(e.getMessage());
                if (e.getMessage().contains("Duplicate entry")) {
                    throw new UserAlreadyExistentException("User " + register.getUsername() + " already exists");
                } else {
                    throw new InvalidParameterException("Invalid Parameters");
                }
            }
        }
        return false;
    }

    @Override
    public List<String> getAllCustomer() {
        List<String> customerList = new ArrayList<>();
        customerList=CustomerQuery.getAllCustomer(Connector.getConnection());
        return customerList;
    }
}

