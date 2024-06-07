package com.ispwproject.lacremepastel.controller.app;

import com.ispwproject.lacremepastel.engineeringclasses.bean.ProductBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.ProductFilterBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.SessionBean;
import com.ispwproject.lacremepastel.engineeringclasses.dao.ProductDAO;
import com.ispwproject.lacremepastel.engineeringclasses.exception.InvalidParameterException;
import com.ispwproject.lacremepastel.engineeringclasses.exception.SessionNotFoundException;
import com.ispwproject.lacremepastel.engineeringclasses.factory.ProductDAOFactory;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Configurations;
import com.ispwproject.lacremepastel.model.Product;
import com.ispwproject.lacremepastel.model.ProductFilter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class ManageProductController {

    public Map<Integer,ProductBean> loadAllProducts(SessionBean sessionBean) throws SessionNotFoundException{
        //Check sessione
        LoginController loginController = new LoginController();
        if(sessionBean == null){
            throw  new SessionNotFoundException("Session is null");
        }
        loginController.checkLogin(sessionBean);

        ProductDAO productDAO = ProductDAOFactory.getInstance().createProductDAO();

        List<Product> productList = productDAO.getAllProducts();

        return processProducts(productList);
    }

    public Map<Integer,ProductBean> loadProducts(SessionBean sessionBean, ProductFilterBean filter) {
        //Check sessione
        LoginController loginController = new LoginController();
        loginController.checkLogin(sessionBean);

        ProductDAO productDAO = ProductDAOFactory.getInstance().createProductDAO();

        //Check filtro
        List<Product> productList;
        if(filter != null){
            productList = productDAO.getProducts(
                    new ProductFilter(
                            filter.getCategory()
                    )
            );
        }else{
            productList = productDAO.getAllProducts();
        }
        return processProducts(productList);
    }

    private Map<Integer,ProductBean> processProducts(List<Product> productList) {
        //Conversione Model -> Bean
        HashMap<Integer,ProductBean> productBeanList = new HashMap<>();

        for (Product p : productList) {
            try {
                productBeanList.put(
                        p.getId(),
                        new ProductBean(
                                p.getId(),
                                p.getName(),
                                p.getPrice()
                ));
            } catch (InvalidParameterException e) {
                Logger logger = Logger.getLogger(Configurations.getInstance().getProperty("LOGGER_NAME"));
                logger.info(e.getMessage());
                System.err.println("Error loading product");
            }
        }
        return productBeanList;
    }
}
