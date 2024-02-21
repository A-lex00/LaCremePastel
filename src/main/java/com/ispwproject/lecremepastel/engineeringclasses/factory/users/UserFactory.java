package com.ispwproject.lecremepastel.engineeringclasses.factory.users;

import com.ispwproject.lecremepastel.engineeringclasses.dao.UserDAO;
import com.ispwproject.lecremepastel.engineeringclasses.exception.IncorrectParametersException;
import com.ispwproject.lecremepastel.engineeringclasses.singleton.Configurations;
import com.ispwproject.lecremepastel.model.Register;
import com.ispwproject.lecremepastel.model.User;

public abstract class UserFactory {

    private static final int DIRECTOR = Integer.parseInt(Configurations.getInstance().getProperty("DIRECTOR"));
    private static final int CUSTOMER = Integer.parseInt(Configurations.getInstance().getProperty("CUSTOMER"));
    private static final int WORKER = Integer.parseInt(Configurations.getInstance().getProperty("WORKER"));

    public static UserFactory getFactory(int type) throws IncorrectParametersException {
        if(type == DIRECTOR){
            return new DirectorFactory();
        }else if(type == CUSTOMER){
            return new CustomerFactory();
        }else if(type == WORKER){
            return new WorkerFactory();
        }else{
            throw new IncorrectParametersException("UserFactory: Invalid User Type: " + type);
        }

    }

    public abstract User createUser(Register register);
    public abstract User loadUser(String username);

    //Can I expose the DAO from the factory?
    public abstract UserDAO getDAO();
}
