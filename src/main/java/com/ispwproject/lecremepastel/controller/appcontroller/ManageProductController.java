package com.ispwproject.lecremepastel.controller.appcontroller;

import com.ispwproject.lecremepastel.engineeringclasses.bean.ProductBean;
import com.ispwproject.lecremepastel.engineeringclasses.dao.ProductDAO;
import com.ispwproject.lecremepastel.engineeringclasses.exception.IncorrectParametersException;
import com.ispwproject.lecremepastel.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ManageProductController {

    public List<ProductBean> loadProducts(){
        ArrayList<ProductBean> productBeanList = new ArrayList<>();

        //Load all products available in database
        ProductDAO productDAO = new ProductDAO();
        List<Product> productList = productDAO.getAllProducts();
        for(Product p : productList){
            try{
                productBeanList.add(new ProductBean(
                        p.getId(),
                        p.getProductName(),
                        p.getCategory(),
                        p.getPrice()
                ));
            }catch(IncorrectParametersException e){
                e.fillInStackTrace();
                System.err.println("Error loading product: "+p.getId());
            }
        }

        return productBeanList;
    }

}
