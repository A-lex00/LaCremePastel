package com.ispwproject.lacremepastel.engineeringclasses.dao;

import com.ispwproject.lacremepastel.engineeringclasses.exception.InvalidParameterException;
import com.ispwproject.lacremepastel.engineeringclasses.exception.UserAlreadyExistentException;
import com.ispwproject.lacremepastel.engineeringclasses.query.DirectorQuery;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Configurations;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Connector;
import com.ispwproject.lacremepastel.model.Register;
import com.ispwproject.lacremepastel.other.SupportedUserTypes;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

public class DirectorDAO implements UserDAO{
    @Override
    public boolean userRegister(Register register) throws UserAlreadyExistentException, InvalidParameterException {
        if(register != null) {
            try{
                DirectorQuery.addDirector(
                        Connector.getConnection(),
                        register.getUsername(),
                        BCrypt.hashpw(register.getPasswd(),BCrypt.gensalt()),
                        register.getFirstname(),
                        register.getLastname(),
                        register.getEmail(),
                        register.getCfPiva(),
                        SupportedUserTypes.DIRECTOR.toString()
                );
                return true;
            }catch (SQLException e) {
                Logger.getLogger(Configurations.getInstance().getProperty("LOGGER_NAME")).severe(e.getMessage());
                if(e.getMessage().contains("Duplicate entry")) {
                    throw new UserAlreadyExistentException("User " + register.getUsername() + " already exists");
                }else{
                    throw new InvalidParameterException("Invalid Parameters");
                }
            }
        }
        return false;
    }

    @Override
    public List<String> getAllCustomer() {
        return null;
    }
}
