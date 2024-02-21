package com.ispwproject.lecremepastel.engineeringclasses.factory.persistence;

import com.ispwproject.lecremepastel.engineeringclasses.dao.UserDAO;
import com.ispwproject.lecremepastel.engineeringclasses.exception.IncorrectParametersException;
import com.ispwproject.lecremepastel.engineeringclasses.singleton.Configurations;

public abstract class UserDAOFactory {

    protected static final int DIRECTOR = Integer.parseInt(Configurations.getInstance().getProperty("DIRECTOR"));
    protected static final int CUSTOMER = Integer.parseInt(Configurations.getInstance().getProperty("CUSTOMER"));
    protected static final int WORKER = Integer.parseInt(Configurations.getInstance().getProperty("WORKER"));
    private static final String MARIADB = "MARIADB";
    private static final String JSON = "JSON";

    public static UserDAOFactory getFactory(int type) throws IncorrectParametersException {
        String persistence = Configurations.getInstance().getProperty("PERSISTENCE_TYPE");
        if(persistence.equals(MARIADB)){
            return UserDbFactory.getFactory(type);
        }else if(persistence.equals(JSON)){
            return UserJsonFactory.getFactory(type);
        }else{
            throw new IncorrectParametersException("UserDAOFactory: Invalid Persistence Type: " + persistence);
        }
    }

    public abstract UserDAO createDAO();
}
