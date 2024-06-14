package com.ispwproject.lacremepastel.controller.app;

import com.ispwproject.lacremepastel.engineeringclasses.bean.ProductBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.ProductFilterBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.SessionBean;
import com.ispwproject.lacremepastel.engineeringclasses.dao.ProductDAO;
import com.ispwproject.lacremepastel.engineeringclasses.exception.InvalidParameterException;
import com.ispwproject.lacremepastel.engineeringclasses.factory.ProductDAOFactory;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Configurations;
import com.ispwproject.lacremepastel.model.Product;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class ManageProductController {

    private List<Product> loadProducts(ProductFilterBean filter){
        ProductDAO productDAO = ProductDAOFactory.getInstance().createProductDAO();
        List<Product> productList = new ArrayList<>();
        if(filter != null){
            if(filter.getCategory() != null){
                productList = productDAO.getProductsByCategory(filter.getCategory());
            }else if(filter.getName() != null){
                productList = productDAO.getProductsByName(filter.getName());
            }
        }else{
            productList = productDAO.getAllProducts();
        }
        return productList;
    }

    public Map<Integer,ProductBean> getProductMap(SessionBean sessionBean, ProductFilterBean filter) {

        this.loginCheck(sessionBean);

        HashMap<Integer,ProductBean> productBeanList = new HashMap<>();
        List<Product> productList = this.loadProducts(filter);

        //Conversione Model -> Bean
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
            }
        }
        return productBeanList;
    }

    public  List<ProductBean> getProductList(SessionBean sessionBean, ProductFilterBean filter){
        this.loginCheck(sessionBean);
        ArrayList<ProductBean> converted = new ArrayList<>();
        List<Product> productList = this.loadProducts(filter);

        //Conversione Model -> Bean
        for(Product p : productList){
            try {
                converted.add(
                        new ProductBean(
                                p.getId(),
                                p.getName(),
                                p.getPrice(),
                                p.getCategory().toString()
                        )
                );
            }catch (InvalidParameterException e){
                Logger logger = Logger.getLogger(Configurations.LOGGER_NAME);
                logger.info(e.getMessage());
            }
        }
        return converted;
    }
    public void addProduct(ProductBean productBean, SessionBean sessionBean){
        this.loginCheck(sessionBean);
        Product product = new Product(productBean.getId(), productBean.getProductName(), productBean.getPrice());
        ProductDAO productDAO = ProductDAOFactory.getInstance().createProductDAO();
        productDAO.addProduct(product, sessionBean.getUsername());
    }
    public boolean updateProduct(ProductBean productBean, SessionBean sessionBean){
        this.loginCheck(sessionBean);
        ProductDAO productDAO = ProductDAOFactory.getInstance().createProductDAO();
        Product product = new Product(productBean.getId(), productBean.getProductName(), productBean.getPrice());
        boolean flag = productDAO.modifyProduct(product, sessionBean.getUsername());
        if(!flag){
            Logger logger = Logger.getLogger(Configurations.LOGGER_NAME);
            logger.info("Errore nell'inserimento del prodotto!");
        }
        return flag;
    }
    public boolean removeProduct(ProductBean productBean, SessionBean sessionBean){
        this.loginCheck(sessionBean);
        ProductDAO productDAO = ProductDAOFactory.getInstance().createProductDAO();
        boolean flag = productDAO.deleteProduct(productBean.getId(),sessionBean.getUsername());
        if(!flag){
            Logger logger = Logger.getLogger(Configurations.LOGGER_NAME);
            logger.info("Errore nella cancellazione  del prodotto!");
        }
        return flag;
    }

    private void loginCheck(SessionBean sessionBean){
        //Check sessione
        LoginController loginController = new LoginController();
        if(sessionBean == null){
            throw new InvalidParameterException("Session is null");
        }
        loginController.checkLogin(sessionBean);
    }
}
//update, remove