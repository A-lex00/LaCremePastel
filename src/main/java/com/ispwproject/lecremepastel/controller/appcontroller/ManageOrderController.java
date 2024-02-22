package com.ispwproject.lecremepastel.controller.appcontroller;

import com.ispwproject.lecremepastel.engineeringclasses.bean.SimpleOrderBean;
import com.ispwproject.lecremepastel.engineeringclasses.dao.SimpleOrderDAO;

public class ManageOrderController {

    public void acceptOrder(SimpleOrderBean simpleOrderBean){
        if(simpleOrderBean != null){
            SimpleOrderDAO simpleOrderDAO = new SimpleOrderDAO();
            simpleOrderDAO.updatePendingOrder(simpleOrderBean.getId(),true);
        }
    }

    public void rejectOrder(SimpleOrderBean simpleOrderBean){
        if(simpleOrderBean != null){
            SimpleOrderDAO simpleOrderDAO = new SimpleOrderDAO();
            simpleOrderDAO.updatePendingOrder(simpleOrderBean.getId(),false);
        }
    }
}

