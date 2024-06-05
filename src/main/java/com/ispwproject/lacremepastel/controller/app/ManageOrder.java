package com.ispwproject.lacremepastel.controller.app;

import com.ispwproject.lacremepastel.engineeringclasses.bean.OrderBean;
import com.ispwproject.lacremepastel.engineeringclasses.dao.OrderDAO;
import com.ispwproject.lacremepastel.engineeringclasses.factory.NoticeFactory;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Configurations;
import com.ispwproject.lacremepastel.model.Order;
import com.ispwproject.lacremepastel.model.OrderLine;

import java.util.List;

public class ManageOrder {
    public void manage(List<OrderLine> currentCart, String customer){
        OrderBean orderBean = new OrderBean(customer);
        orderBean.setCart(currentCart);

    }
    public void finalizeOrder(OrderBean orderBean){
        String value=null;
        value= Configurations.getInstance().getProperty("PERSISTENCE_TYPE");
        if(value=="MARIADB") {
            OrderDAO orderDAO= new OrderDAO();
            Order order = new Order(orderBean.getCustomerName(), true, false,false, orderBean.getAllOrder());
            orderDAO.saveOrder(order);
        }else{
            //scrivere qui persistenza json
        }
        //Qui ho lanciato l'idea di una factory, ma credo sia meglio chiamare la classe "NoticeGenerator" come era prima.
        NoticeFactory noticeFactory=new NoticeFactory();
        noticeFactory.createdOrderNotice(orderBean.getCustomerName(),"nuovo ordine");

    }
}
