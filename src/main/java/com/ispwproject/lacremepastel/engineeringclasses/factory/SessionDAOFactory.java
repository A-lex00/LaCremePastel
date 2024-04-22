package com.ispwproject.lacremepastel.engineeringclasses.factory;

import com.ispwproject.lacremepastel.engineeringclasses.dao.SessionDAO;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Configurations;
import com.ispwproject.lacremepastel.other.SupportedPersistenceTypes;

public abstract class SessionDAOFactory {

    private static SessionDAOFactory instance = null;

    protected SessionDAOFactory(){}

    public static synchronized SessionDAOFactory getInstance(){
        if(instance == null){
            String persistence = Configurations.getInstance().getProperty("PERSISTENCE_TYPE");
            switch (SupportedPersistenceTypes.valueOf(persistence)){
                case MARIADB -> instance = new SessionDbFactory();
               // case JSON -> instance = new SessionJsonFactory();
                default -> throw new IllegalStateException("SessionDAOFactory: Unsupported Persistence Type: " + persistence);
            }
        }
        return instance;
    }

    public abstract SessionDAO createSessionDAO();
}
