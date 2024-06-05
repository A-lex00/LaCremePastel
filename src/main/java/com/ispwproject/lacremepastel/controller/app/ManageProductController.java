package com.ispwproject.lacremepastel.controller.app;

import com.ispwproject.lacremepastel.engineeringclasses.bean.ProductBean;
import com.ispwproject.lacremepastel.engineeringclasses.dao.ProductDAO;
import com.ispwproject.lacremepastel.engineeringclasses.dao.db.ProductDbDAO;
import com.ispwproject.lacremepastel.engineeringclasses.exception.InvalidParameterException;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Configurations;
import com.ispwproject.lacremepastel.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ManageProductController {

    public List<ProductBean> loadProducts() {
        ArrayList<ProductBean> productBeanList = new ArrayList<>();

        if (Configurations.getInstance().getProperty("PERSISTENCE_TYPE").equals("MARIADB")) {
            ProductDbDAO productDbDAO = new ProductDbDAO();
            List<Product> productList = productDbDAO.getAllProducts();
            for (Product p : productList) {
                try {
                    productBeanList.add(new ProductBean(
                            p.getName(),
                            p.getPrice()
                    ));
                } catch (InvalidParameterException e) {
                    e.fillInStackTrace();
                    System.err.println("Error loading product");
                }
            }
            return productBeanList;
        }
        else{
            //persistenza JSON
            return null;
        }
    }
}
