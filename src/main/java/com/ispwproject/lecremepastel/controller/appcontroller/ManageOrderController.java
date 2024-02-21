package com.ispwproject.lecremepastel.controller.appcontroller;

import com.ispwproject.lecremepastel.engineeringclasses.bean.SimpleOrderBean;
import com.ispwproject.lecremepastel.engineeringclasses.bean.OrderLineBean;
import com.ispwproject.lecremepastel.engineeringclasses.dao.OrderLineDAO;
import com.ispwproject.lecremepastel.engineeringclasses.dao.SimpleOrderDAO;
import com.ispwproject.lecremepastel.model.SimpleOrder;
import java.util.ArrayList;
import java.util.List;

public class ManageOrderController {

    public List<SimpleOrderBean> loadSimpleOrders(){
        //TODO
        SimpleOrderDAO simpleOrderDAO = new SimpleOrderDAO();
        OrderLineDAO orderLineDAO = new OrderLineDAO();
        ArrayList<SimpleOrder> orderList = (ArrayList<SimpleOrder>) simpleOrderDAO.getAllOrders();
        for(SimpleOrder order : orderList){
            ArrayList<OrderLineBean> lineList = (ArrayList<OrderLineBean>) orderLineDAO.loadOrderLines(order.getId());
//            for(OrderLineBean line : lineList){
//
//            }
        }
        return null;
    }

    public void acceptOrder(SimpleOrderBean simpleOrderBean){
        //TODO
    }
    public void rejectOrder(SimpleOrderBean simpleOrderBean){
        //TODO
    }





    
}

