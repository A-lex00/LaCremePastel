package com.ispwproject.lacremepastel.controller.app;

import com.ispwproject.lacremepastel.engineeringclasses.bean.OrderBean;
import com.ispwproject.lacremepastel.engineeringclasses.dao.OrderDAO;
import com.ispwproject.lacremepastel.engineeringclasses.factory.NoticeFactory;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Configurations;
import com.ispwproject.lacremepastel.model.Order;
import com.ispwproject.lacremepastel.model.OrderLine;

import java.util.List;



public class ManageOrderController {
    public void manage(){
    }
    public void finalizeOrder(OrderBean orderBean){

            OrderDAO orderDAO= new OrderDAO();
            Order order = new Order(orderBean.getCustomerName(), true, false,false, orderBean.getAllOrder());
            orderDAO.saveOrder(order);

        NoticeFactory noticeFactory =  new NoticeFactory();
        noticeFactory.createdOrderNotice(orderBean.getCustomerName(),"nuovo ordine");
    }
}
