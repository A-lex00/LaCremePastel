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
        
        //non mi convince
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
        if(value=="MARIADB") {
            OrderDbDAO orderDbDAO=new OrderDbDAO();
            orderDbDAO.saveOrder(orderBean);
        }
        NoticeFactory noticeFactory=new NoticeFactory();
    }
}
