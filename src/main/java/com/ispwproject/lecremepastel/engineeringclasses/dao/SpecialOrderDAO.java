package com.ispwproject.lecremepastel.engineeringclasses.dao;

import com.ispwproject.lecremepastel.engineeringclasses.query.SpecialOrderQuery;
import com.ispwproject.lecremepastel.engineeringclasses.singleton.Configurations;
import com.ispwproject.lecremepastel.engineeringclasses.singleton.Connector;
import com.ispwproject.lecremepastel.model.SpecialOrder;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SpecialOrderDAO{

    private static final int ORDERTYPE = Integer.parseInt(Configurations.getInstance().getProperty("SPECIAL"));

    public boolean saveOrder(SpecialOrder so) {
        try{
            SpecialOrderQuery.insertOrder(Connector.getConnection(),so.getId(),so.getContent(),so.getCustomer(),ORDERTYPE);
            return true;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public SpecialOrder getOrder(int orderId, String username) {
        try(ResultSet rs = SpecialOrderQuery.selectOrder(Connector.getConnection(),orderId,username);){
            if(rs.next()){
                String content = rs.getString("content");
                return new SpecialOrder(orderId,username,content);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public List<SpecialOrder> getAllOrders(String username) {
        ArrayList<SpecialOrder> list = new ArrayList<>();
        try(ResultSet rs = SpecialOrderQuery.selectAllOrders(Connector.getConnection(),username,ORDERTYPE)){
            while(rs.next()) {
                int orderId = rs.getInt("id");
                String content = rs.getString("content");
                list.add(new SpecialOrder(orderId, username, content));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    public List<SpecialOrder> getAllOrders() {
        ArrayList<SpecialOrder> list = new ArrayList<>();
        try(ResultSet rs = SpecialOrderQuery.selectAllOrders(Connector.getConnection(),ORDERTYPE)){
            while(rs.next()) {
                int orderId = rs.getInt("id");
                String content = rs.getString("content");
                String username = rs.getString("customer");
                list.add(new SpecialOrder(orderId, username, content));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
}
