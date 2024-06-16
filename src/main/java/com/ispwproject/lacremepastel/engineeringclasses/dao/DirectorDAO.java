package com.ispwproject.lacremepastel.engineeringclasses.dao;

import com.ispwproject.lacremepastel.engineeringclasses.exception.InvalidParameterException;
import com.ispwproject.lacremepastel.engineeringclasses.exception.UserAlreadyExistentException;
import com.ispwproject.lacremepastel.engineeringclasses.query.DirectorQuery;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Configurations;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Connector;
import com.ispwproject.lacremepastel.model.Register;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DirectorDAO extends UserDAO{

    @Override
    public void userRegister(Register register) throws UserAlreadyExistentException, InvalidParameterException {
        super.userRegister(register);
        if(register != null) {
            try{
                DirectorQuery.saveAdditionalInfo(
                        Connector.getConnection(),
                        register.getFirstname(),
                        register.getLastname(),
                        register.getCfPiva(),
                        register.getUsername()
                );
            }catch (SQLException e) {
                Logger.getLogger(Configurations.LOGGER_NAME).severe(e.getMessage());
                if(e.getMessage().contains("Duplicate entry")) {
                    throw new UserAlreadyExistentException("User " + register.getUsername() + " already exists");
                }else{
                    throw new InvalidParameterException("Invalid Parameters");
                }
            }
        }
    }
}
