package com.ispwproject.lacremepastel.controller.app;

import com.ispwproject.lacremepastel.engineeringclasses.bean.OrderBean;
import com.ispwproject.lacremepastel.engineeringclasses.dao.OrderDAO;
import com.ispwproject.lacremepastel.engineeringclasses.dao.db.OrderDbDAO;
import com.ispwproject.lacremepastel.engineeringclasses.factory.NoticeFactory;
import com.ispwproject.lacremepastel.model.Order;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.PropertyResourceBundle;

public class ManageOrder {
    public void finalizeOrder(OrderBean orderBean){
        
        // non mi convince
        // Esiste la classe Configurations apposta per non farti leggere il file ogni volta.
        String value=null;
        Properties prop=new Properties();
        try{
            FileInputStream file= new FileInputStream("config.properties");
            prop.load(file);
            value=prop.getProperty("PERSISTENCE_TYPE");
            file.close();
        }catch(IOException ex){
            ex.printStackTrace();;
        }
        //Per questa situazione qui, esiste la DAOFactory apposta, così te ne devi sbattere il cazzo del tipo
        if(value=="MARIADB") {
            OrderDbDAO orderDbDAO=new OrderDbDAO();
            orderDbDAO.saveOrder(orderBean);
        }
        //Qui ho lanciato l'idea di una factory, ma credo sia meglio chiamare la classe "NoticeGenerator" come era prima.
        NoticeFactory noticeFactory=new NoticeFactory();
    }
}
