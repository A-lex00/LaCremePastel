package com.ispwproject.lacremepastel.engineeringclasses.factory;

import com.ispwproject.lacremepastel.engineeringclasses.dao.ProductDAO;
import com.ispwproject.lacremepastel.engineeringclasses.dao.json.ProductJsonDAO;

public class ProductJsonFactory extends ProductDAOFactory{

    @Override
    public ProductDAO createProductDAO() {
        return new ProductJsonDAO();
    }
}
