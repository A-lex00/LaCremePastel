package com.ispwproject.lecremepastel.controller.appcontroller;

import com.ispwproject.lecremepastel.engineeringclasses.bean.OrderLineBean;
import com.ispwproject.lecremepastel.engineeringclasses.bean.SessionBean;
import com.ispwproject.lecremepastel.engineeringclasses.bean.SimpleOrderBean;
import com.ispwproject.lecremepastel.engineeringclasses.dao.OrderLineDAO;
import com.ispwproject.lecremepastel.engineeringclasses.dao.ProductDAO;
import com.ispwproject.lecremepastel.engineeringclasses.dao.SimpleOrderDAO;
import com.ispwproject.lecremepastel.engineeringclasses.exception.IncorrectParametersException;
import com.ispwproject.lecremepastel.engineeringclasses.exception.InvalidSessionException;
import com.ispwproject.lecremepastel.engineeringclasses.singleton.ObservablePendingOrderList;
import com.ispwproject.lecremepastel.engineeringclasses.singleton.SessionManager;
import com.ispwproject.lecremepastel.model.OrderLine;
import com.ispwproject.lecremepastel.model.SimpleOrder;
import java.io.IOException;
import java.sql.SQLException;

public class MakeOrderController{
    public void createSimpleOrder(String sid, SimpleOrderBean simpleOrderBean) throws IncorrectParametersException, InvalidSessionException, SQLException, IOException, ClassNotFoundException {
        //Various checks
        if(sid == null) {
            throw new InvalidSessionException("MakeOrderController:createSimpleOrder: Invalid Session ID!");
        }
        SessionBean sessionBean = SessionManager.getInstance().getSession(sid);
        if(sessionBean == null) {
            throw new InvalidSessionException("MakeOrderController:createSimpleOrder: Invalid Session ID!");
        }
        if(simpleOrderBean == null) {
            throw new IncorrectParametersException("MakeOrderController::createSimpleOrder: No Order Specified!");
        }

        //Creating new Empty Order and getting the generated ID
        String username = sessionBean.getUsername();
        SimpleOrder simpleOrder = new SimpleOrder(username,true,false,false);
        SimpleOrderDAO simpleOrderDAO = new SimpleOrderDAO();
        simpleOrder = simpleOrderDAO.createSimpleOrder(simpleOrder);

        //Saving all the OrderLines and loading all product info
        OrderLineDAO orderLineDAO = new OrderLineDAO();
        ProductDAO productDAO = new ProductDAO();
        for(OrderLineBean orderLineBean : simpleOrderBean.getProductList()){
            orderLineBean.setOrderId(simpleOrder.getId());
            orderLineDAO.saveOrderLine(orderLineBean);

            simpleOrder.addProduct(new OrderLine(
                    productDAO.getProduct(orderLineBean.getProductId()),
                    orderLineBean.getAmount()
            ));
        }

        //Update with new Pending Order
        ObservablePendingOrderList orderList = ObservablePendingOrderList.getInstance();
        orderList.addSimpleOrder(simpleOrder);
    }
}