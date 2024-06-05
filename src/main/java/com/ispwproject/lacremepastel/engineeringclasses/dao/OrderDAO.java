package com.ispwproject.lacremepastel.engineeringclasses.dao;

import com.ispwproject.lacremepastel.engineeringclasses.query.OrderQuery;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Connector;
import com.ispwproject.lacremepastel.model.Order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDAO {
    public void saveOrder(Order order) {
        int idOrder, isPending, isAccepted, isClosed;
        if(order.isPending()) {
            isPending = 1;
        }
        if( order.isAccepted()){
            isAccepted = 1;
            isPending = 0;
        }else {
            isPending = 0;
            isAccepted = 0;
        }
        if(order.isClosed()) {
            isClosed = 1;
        }
        else {
            isClosed = 0;
        }
        try(ResultSet rs =  OrderQuery.createSimpleOrder(Connector.getConnection(), isPending, isAccepted, isClosed, order.getCustomerName())) {
            if(rs.next()){
                idOrder = rs.getInt("id");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

