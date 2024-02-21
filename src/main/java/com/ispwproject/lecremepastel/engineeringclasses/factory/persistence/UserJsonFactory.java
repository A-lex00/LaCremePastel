package com.ispwproject.lecremepastel.engineeringclasses.factory.persistence;

import com.ispwproject.lecremepastel.engineeringclasses.exception.IncorrectParametersException;

public abstract class UserJsonFactory extends UserDAOFactory{

    public static UserJsonFactory getFactory(int type) throws IncorrectParametersException {
        if(type == DIRECTOR){
            return new DirectorJsonFactory();
        }else if(type == CUSTOMER){
            return new CustomerJsonFactory();
        }else if(type == WORKER){
            return new WorkerJsonFactory();
        }else{
            throw new IncorrectParametersException("UserJsonFactory: Invalid User Type: " + type);
        }
    }
}
