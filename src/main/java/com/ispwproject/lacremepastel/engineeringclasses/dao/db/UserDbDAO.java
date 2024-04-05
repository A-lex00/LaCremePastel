package com.ispwproject.lacremepastel.engineeringclasses.dao.db;

import com.ispwproject.lacremepastel.engineeringclasses.dao.UserDAO;
import com.ispwproject.lacremepastel.engineeringclasses.query.UserQuery;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Connector;
import com.ispwproject.lacremepastel.model.Register;

import java.sql.SQLException;
import java.util.logging.Logger;

public abstract class UserDbDAO implements UserDAO {
    @Override
    public boolean userRegister(Register register) {
        if(register != null){
            try {
                UserQuery.addUser(
                        Connector.getConnection(),
                        register.getUsername(),
                        register.getPasswd(),
                        register.getFirstname(),
                        register.getLastname(),
                        register.getEmail(),
                        register.getCfPiva(),
                        register.getUserType().toString()
                );
                return true;
            }catch (SQLException e){
                Logger.getLogger(UserDbDAO.class.getName()).severe(e.getMessage());
            }
        }
        return false;
    }
}
