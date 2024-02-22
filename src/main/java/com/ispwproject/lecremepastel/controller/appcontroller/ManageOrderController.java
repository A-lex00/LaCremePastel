package com.ispwproject.lecremepastel.controller.appcontroller;

import com.ispwproject.lecremepastel.engineeringclasses.bean.SimpleOrderBean;
import com.ispwproject.lecremepastel.engineeringclasses.dao.SimpleOrderDAO;
import com.ispwproject.lecremepastel.engineeringclasses.exception.InvalidSessionException;
import com.ispwproject.lecremepastel.engineeringclasses.singleton.SessionManager;

import java.security.InvalidParameterException;

public class ManageOrderController {

    /**
     * This method sets as accepted the order identified by Order ID if it's still pending
     * @param simpleOrderBean Is necessary only the Order ID set
     */
    public void acceptOrder(String sid, SimpleOrderBean simpleOrderBean) throws InvalidSessionException, InvalidParameterException{
        if(sid != null && SessionManager.getInstance().getSession(sid) != null){
            if(simpleOrderBean != null){
                SimpleOrderDAO simpleOrderDAO = new SimpleOrderDAO();
                simpleOrderDAO.updatePendingOrder(simpleOrderBean.getId(),true);
            }else{
                throw new InvalidParameterException("ManageOrderController::acceptOrder: No order Specified!");
            }
        }else{
            throw new InvalidSessionException("ManageOrderController::acceptOrder: Invalid Session ID!");
        }
    }

    public void rejectOrder(String sid, SimpleOrderBean simpleOrderBean) throws InvalidSessionException, InvalidParameterException{
        if(sid != null && SessionManager.getInstance().getSession(sid) != null){
            if(simpleOrderBean != null){
                SimpleOrderDAO simpleOrderDAO = new SimpleOrderDAO();
                simpleOrderDAO.updatePendingOrder(simpleOrderBean.getId(),false);
            }else{
                throw new InvalidParameterException("ManageOrderController::acceptOrder: No order Specified!");
            }
        }else{
            throw new InvalidSessionException("ManageOrderController::acceptOrder: Invalid Session ID!");
        }
    }
}

