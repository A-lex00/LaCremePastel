package com.ispwproject.lecremepastel.engineeringclasses.factory.persistence;

import com.ispwproject.lecremepastel.engineeringclasses.exception.IncorrectParametersException;
import com.ispwproject.lecremepastel.engineeringclasses.singleton.Configurations;

public abstract class UserDbFactory extends UserDAOFactory{

    private static final int DIRECTOR = Integer.parseInt(Configurations.getInstance().getProperty("DIRECTOR"));
    private static final int CUSTOMER = Integer.parseInt(Configurations.getInstance().getProperty("CUSTOMER"));
    private static final int WORKER = Integer.parseInt(Configurations.getInstance().getProperty("WORKER"));

    public static UserDbFactory getFactory(int type) throws IncorrectParametersException {
        if(type == DIRECTOR){
            return new DirectorDbFactory();
        }else if(type == CUSTOMER){
            return new CustomerDbFactory();
        }else if(type == WORKER){
            return new WorkerDbFactory();
        }else{
            throw new IncorrectParametersException("UserDbFactory: Invalid User Type: " + type);
        }
    }
}
