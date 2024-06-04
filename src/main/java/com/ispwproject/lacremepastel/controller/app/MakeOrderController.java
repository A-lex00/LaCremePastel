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

    public void saveOrder(SessionBean sessionData, OrderBean orderBean) {
        //Check validità sessione
        try{
            if(!SessionManager.getInstance().checkSession(sessionData.getSid())){
                throw new InvalidParameterException("Session expired");
            }else if(orderBean == null){
                throw new InvalidParameterException("");
            }
        }catch(SessionNotFoundException e){
            Logger logger = Logger.getLogger(Configurations.getInstance().getProperty("LOGGER_NAME"));
            logger.info(e.getMessage());
            throw new InvalidParameterException("Invalid session data");
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
