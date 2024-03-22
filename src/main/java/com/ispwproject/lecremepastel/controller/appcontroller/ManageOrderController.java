package com.ispwproject.lecremepastel.controller.appcontroller;

import com.ispwproject.lecremepastel.engineeringclasses.bean.SimpleOrderBean;
import com.ispwproject.lecremepastel.engineeringclasses.dao.NoticeDAO;
import com.ispwproject.lecremepastel.engineeringclasses.dao.SimpleOrderDAO;
import com.ispwproject.lecremepastel.engineeringclasses.exception.InvalidSessionException;
import com.ispwproject.lecremepastel.engineeringclasses.singleton.ObservablePendingOrderList;
import com.ispwproject.lecremepastel.engineeringclasses.singleton.SessionManager;
import com.ispwproject.lecremepastel.model.Notice;
import com.ispwproject.lecremepastel.model.SimpleOrder;
import com.ispwproject.lecremepastel.other.NoticeGenerator;

import java.security.InvalidParameterException;

public class ManageOrderController {

    /**
     * This method sets the order identified by Order ID as accepted or rejected if still pending
     * @param simpleOrderBean Is necessary only the Order ID
     */
    public void finalizeOrder(String sid, SimpleOrderBean simpleOrderBean) throws InvalidSessionException, InvalidParameterException{
        if(SessionManager.getInstance().getSession(sid) != null){
            if(simpleOrderBean != null){
                SimpleOrderDAO simpleOrderDAO = new SimpleOrderDAO();
                simpleOrderDAO.updatePendingOrder(simpleOrderBean.getId(), simpleOrderBean.isAccepted());

                //Update Pending Order List
                SimpleOrder simpleOrder = new SimpleOrder();
                simpleOrder.setId(simpleOrderBean.getId());
                ObservablePendingOrderList orderList = ObservablePendingOrderList.getInstance();
                orderList.removeSimpleOrder(simpleOrder);

                //Write a new Notice for the User target
                NoticeGenerator noticeGenerator = new NoticeGenerator();
                Notice n = noticeGenerator.finalizedOrderNotice(
                        simpleOrderBean.getId(),
                        simpleOrderBean.isAccepted()
                );
                NoticeDAO noticeDAO = new NoticeDAO();
                noticeDAO.saveNotice(n,simpleOrderBean.getCustomer());
            }else{
                throw new InvalidParameterException("ManageOrderController::finalizeOrder: No order Specified!");
            }
        }else{
            throw new InvalidSessionException("ManageOrderController::finalizeOrder: Invalid Session ID!");
        }
    }
}