package com.ispwproject.lecremepastel.controller.appcontroller;

import com.ispwproject.lecremepastel.engineeringclasses.bean.SimpleOrderBean;
import com.ispwproject.lecremepastel.engineeringclasses.dao.SimpleOrderDAO;
import com.ispwproject.lecremepastel.engineeringclasses.exception.InvalidSessionException;
import com.ispwproject.lecremepastel.engineeringclasses.singleton.SessionManager;

import java.security.InvalidParameterException;

public class ManageOrderController {

    /**
     * This method sets the order identified by Order ID as accepted or rejected if still pending
     * @param simpleOrderBean Is necessary only the Order ID set
     */
    public void finalizeOrder(String sid, SimpleOrderBean simpleOrderBean) throws InvalidSessionException, InvalidParameterException{
        if(sid != null && SessionManager.getInstance().getSession(sid) != null){
            if(simpleOrderBean != null){
                SimpleOrderDAO simpleOrderDAO = new SimpleOrderDAO();
                simpleOrderDAO.updatePendingOrder(simpleOrderBean.getId(), simpleOrderBean.isAccepted());
            }else{
                throw new InvalidParameterException("ManageOrderController::finalizeOrder: No order Specified!");
            }
        }else{
            throw new InvalidSessionException("ManageOrderController::finalizeOrder: Invalid Session ID!");
        }
    }
}