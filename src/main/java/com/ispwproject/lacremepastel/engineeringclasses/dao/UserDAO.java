package com.ispwproject.lacremepastel.engineeringclasses.dao;

import com.ispwproject.lacremepastel.engineeringclasses.exception.InvalidParameterException;
import com.ispwproject.lacremepastel.engineeringclasses.exception.UserAlreadyExistentException;
import com.ispwproject.lacremepastel.engineeringclasses.query.UserQuery;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Configurations;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Connector;
import com.ispwproject.lacremepastel.model.Register;
import com.ispwproject.lacremepastel.other.SupportedUserTypes;
import org.mindrot.jbcrypt.BCrypt;
import java.sql.SQLException;
import java.util.logging.Logger;

public abstract class UserDAO {

    public void userRegister(Register register) throws UserAlreadyExistentException, InvalidParameterException{
        if(register != null){
            try{
                UserQuery.addUser(
                        Connector.getConnection(),
                        register.getUsername(),
                        BCrypt.hashpw(register.getPasswd(),BCrypt.gensalt()),
                        register.getEmail(),
                        SupportedUserTypes.WORKER.toString()
                );
            } catch (SQLException e) {
                Logger.getLogger(Configurations.LOGGER_NAME).severe(e.getMessage());
                if(e.getMessage().contains("Duplicate entry")){
                    throw new UserAlreadyExistentException("User " + register.getUsername() + " already exists");
                }else{
                    throw new InvalidParameterException("Invalid Parameters");
                }
            }
        }
    }
}
