package com.ispwproject.lacremepastel.controller.app;

import com.ispwproject.lacremepastel.engineeringclasses.bean.OrderBean;

public class ManageOrderController {
    public void manage(){

    }
    public void finalizeOrder(OrderBean orderBean){
        /*String value=null;
        value= Configurations.getInstance().getProperty("PERSISTENCE_TYPE");
        //Per questa situazione qui, esiste la DAOFactory apposta, così te ne devi sbattere il cazzo del tipo
        if(value=="MARIADB") {
            OrderDAO orderDbDAO=new OrderDAO();
            orderDbDAO.saveOrder(orderBean);
        }else{
            //scrivere qui persistenza json
        }
        //Qui ho lanciato l'idea di una factory, ma credo sia meglio chiamare la classe "NoticeGenerator" come era prima.
        NoticeFactory noticeFactory=new NoticeFactory();
        noticeFactory.createdOrderNotice(orderBean.getUser(),"nuovo ordine");
         */
    }
}
