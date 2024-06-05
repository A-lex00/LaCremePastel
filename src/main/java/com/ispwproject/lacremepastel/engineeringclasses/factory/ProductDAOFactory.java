package com.ispwproject.lacremepastel.engineeringclasses.factory;

import com.ispwproject.lacremepastel.engineeringclasses.dao.ProductDAO;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Configurations;
import com.ispwproject.lacremepastel.other.SupportedPersistenceTypes;

public abstract class ProductDAOFactory {

    private static ProductDAOFactory instance = null;

    protected ProductDAOFactory() {}

    public static synchronized ProductDAOFactory getInstance() {
        if (instance == null) {
            String persistence = Configurations.getInstance().getProperty("PERSISTENCE_TYPE");
            switch (SupportedPersistenceTypes.valueOf(persistence)){
                case MARIADB -> instance = new ProductDbFactory();
                case JSON -> instance = new ProductJsonFactory();
                default -> throw new IllegalStateException("ProductDAOFactory: Unsupported Persistence Type: " + persistence);
            }
        }
        return instance;
    }

    public abstract ProductDAO createProductDAO();
}
