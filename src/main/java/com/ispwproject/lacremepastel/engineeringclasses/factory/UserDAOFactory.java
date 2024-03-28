package com.ispwproject.lacremepastel.engineeringclasses.factory;

import com.ispwproject.lacremepastel.engineeringclasses.dao.CustomerDAO;
import com.ispwproject.lacremepastel.engineeringclasses.dao.DirectorDAO;
import com.ispwproject.lacremepastel.engineeringclasses.dao.WorkerDAO;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Configurations;
import com.ispwproject.lacremepastel.other.SupportedPersistenceTypes;

public abstract class UserDAOFactory {

    private static UserDAOFactory instance = null;

    protected UserDAOFactory(){

    }

    public static synchronized UserDAOFactory getInstance(){
        if(instance == null){
            String persistence = Configurations.getInstance().getProperty("PERSISTENCE_TYPE");
            switch (SupportedPersistenceTypes.valueOf(persistence)){
                case MARIADB -> instance = new UserDbFactory();
                case JSON -> instance = new UserJsonFactory();
                default -> throw new IllegalStateException("Unsupported Persistence Type: " + persistence);
            }
        }
        return instance;
    }

    public abstract DirectorDAO createDirectorDAO();
    public abstract CustomerDAO createCustomerDAO();
    public abstract WorkerDAO createWorkerDAO();
}
