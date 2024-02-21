package com.ispwproject.lecremepastel.controller.appcontroller;

import com.ispwproject.lecremepastel.engineeringclasses.bean.OrderLineBean;
import com.ispwproject.lecremepastel.engineeringclasses.bean.SessionBean;
import com.ispwproject.lecremepastel.engineeringclasses.dao.OrderLineDAO;
import com.ispwproject.lecremepastel.engineeringclasses.dao.SimpleOrderDAO;
import com.ispwproject.lecremepastel.engineeringclasses.exception.IncorrectParametersException;
import com.ispwproject.lecremepastel.engineeringclasses.exception.InvalidSessionException;
import com.ispwproject.lecremepastel.engineeringclasses.singleton.SessionManager;
import com.ispwproject.lecremepastel.model.SimpleOrder;

import java.sql.SQLException;

public class MakeOrderController {

    /**
     *
     * @param sid A String representing the User Session ID
     * @return The integer value representing the Order ID
     * @throws SQLException If a database error occurs
     * @throws InvalidSessionException If Session ID is not found by SessionManager
     */
    public int createSimpleOrder(String sid) throws SQLException, InvalidSessionException, IncorrectParametersException {
        //Init variables
        SessionBean sessionBean = SessionManager.getInstance().getSession(sid);
        if(sessionBean == null){
            throw new InvalidSessionException("MakeOrderController.createSimpleOrder: Invalid Session ID");
        }
        String username = sessionBean.getUsername();
        SimpleOrder so = new SimpleOrder(username,true,false,false);
        SimpleOrderDAO simpleOrderDAO = new SimpleOrderDAO();

        //Creating new Order in persistence
        //TODO: Is it better to return a SimpleOrder instance?
        simpleOrderDAO.createSimpleOrder(so);
        return so.getId();
    }

    //TODO: Define how a SpecialOrder it is created
    public void newSpecialOrder(){
        throw new UnsupportedOperationException();
    }

    //TODO: I think that this method is dangeorus
    public int deleteOrder(){
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param orderLineBean
     * @return true if the operation is executed correctly, false otherwise
     */
    public boolean addOrderLine(OrderLineBean orderLineBean){
        OrderLineDAO orderLineDAO = new OrderLineDAO();
        return orderLineDAO.saveOrderLine(orderLineBean);
    }

    /**
     *
     * @param orderLineBean
     * @return true if the operation is executed correctly, false otherwise
     */
    public boolean removeOrderLine(OrderLineBean orderLineBean){
        OrderLineDAO orderLineDAO = new OrderLineDAO();
        return orderLineDAO.deleteOrderLine(orderLineBean);
    }

}
