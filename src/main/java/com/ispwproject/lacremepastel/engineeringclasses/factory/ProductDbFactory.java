package com.ispwproject.lacremepastel.engineeringclasses.factory;

import com.ispwproject.lacremepastel.engineeringclasses.dao.ProductDAO;
import com.ispwproject.lacremepastel.engineeringclasses.dao.db.ProductDbDAO;

public class ProductDbFactory extends ProductDAOFactory{

    @Override
    public ProductDAO createProductDAO() {
        return new ProductDbDAO();
    }
}
