package com.ispwproject.lecremepastel.engineeringclasses.factory.persistence;

import com.ispwproject.lecremepastel.engineeringclasses.dao.LoginDAO;
import com.ispwproject.lecremepastel.engineeringclasses.exception.IncorrectParametersException;
import com.ispwproject.lecremepastel.engineeringclasses.singleton.Configurations;

public abstract class LoginDAOFactory {

    private static final String MARIADB = "MARIADB";
    private static final String JSON = "JSON";

    public static LoginDAOFactory getFactory() throws IncorrectParametersException {
        String persistence = Configurations.getInstance().getProperty("PERSISTENCE_TYPE");
        if(persistence.equals(MARIADB)){
            return new LoginDbFactory();
        }else if(persistence.equals(JSON)){
            return new LoginJsonFactory();
        }else{
            throw new IncorrectParametersException("LoginDAOFactory: Invalid Persistence Type: " + persistence);
        }
    }

    public abstract LoginDAO createDAO();
}
