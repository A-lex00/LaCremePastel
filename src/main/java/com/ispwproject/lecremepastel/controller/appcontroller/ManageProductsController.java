package com.ispwproject.lecremepastel.controller.appcontroller;

import com.ispwproject.lecremepastel.engineeringclasses.bean.ProductBean;
import com.ispwproject.lecremepastel.engineeringclasses.bean.SessionBean;
import com.ispwproject.lecremepastel.engineeringclasses.dao.ProductDAO;
import com.ispwproject.lecremepastel.engineeringclasses.exception.IncorrectParametersException;
import com.ispwproject.lecremepastel.engineeringclasses.exception.InvalidSessionException;
import com.ispwproject.lecremepastel.engineeringclasses.singleton.SessionManager;
import com.ispwproject.lecremepastel.model.Product;
import java.sql.SQLException;

public class ManageProductsController {

    public Product addProduct(ProductBean productBean, String sid) throws SQLException, InvalidSessionException, IncorrectParametersException {
        //retrieve current logged username
        SessionBean sessionBean = SessionManager.getInstance().getSession(sid);
        if(sessionBean == null){
            throw new InvalidSessionException("ManageProductController.addProduct: Invalid Session ID");
        }
        String username = sessionBean.getUsername();

        //Persistence
        ProductDAO productDAO = new ProductDAO();
        return productDAO.createProduct(productBean, username);
    }

    public boolean updateProduct(int pid){
        throw new UnsupportedOperationException();
    }

    public boolean removeProduct(int pid){
        throw new UnsupportedOperationException();
    }

    public void addImage(){
        throw new UnsupportedOperationException();
    }

    public void updateImage(){
        throw new UnsupportedOperationException();
    }

    public void removeImage(){
        throw new UnsupportedOperationException();
    }
}
