package com.ispwproject.lacremepastel.controller.app;

import com.ispwproject.lacremepastel.engineeringclasses.bean.OrderBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.SessionBean;
import com.ispwproject.lacremepastel.engineeringclasses.dao.OrderDAO;
import com.ispwproject.lacremepastel.engineeringclasses.exception.InvalidParameterException;
import com.ispwproject.lacremepastel.engineeringclasses.exception.SessionNotFoundException;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Configurations;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.SessionManager;
import com.ispwproject.lacremepastel.model.Order;

import java.util.logging.Logger;

public class MakeOrderController {

    public void createOrder(SessionBean sessionData, OrderBean orderBean) {
        //Check sessione
        LoginController loginController = new LoginController();
        loginController.checkLogin(sessionData);

        //Check orderBean
        if(orderBean == null){
            throw new InvalidParameterException("OrderBean can't be null");
        }else if(orderBean.getLength() == 0){
            throw new InvalidParameterException("Cart is empty!");
        }

        //Conversione Bean -> Model
        Order order = new Order(
                orderBean.getCustomerName(),
                true,
                false,
                false
        );

        //Salvataggio dell'ordine
        OrderDAO orderDAO = new OrderDAO();
        orderDAO.saveOrder(order);
    }

}
