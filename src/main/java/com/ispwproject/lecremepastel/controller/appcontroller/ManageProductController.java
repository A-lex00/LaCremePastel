package com.ispwproject.lecremepastel.controller.appcontroller;

import com.ispwproject.lecremepastel.engineeringclasses.bean.ProductBean;
import com.ispwproject.lecremepastel.engineeringclasses.dao.ProductDAO;
import com.ispwproject.lecremepastel.engineeringclasses.exception.IncorrectParametersException;
import com.ispwproject.lecremepastel.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ManageProductController {

    public List<ProductBean> loadProducts() throws IncorrectParametersException {
        ArrayList<ProductBean> productBeanList = new ArrayList<>();

        //Load all products available in database
        ProductDAO productDAO = new ProductDAO();
        List<Product> productList = productDAO.getAllProducts();
        for(Product p : productList){
            productBeanList.add(new ProductBean(
                    p.getId(),
                    p.getProductName(),
                    p.getCategory(),
                    p.getPrice()
            ));
        }

        return productBeanList;
    }

}
