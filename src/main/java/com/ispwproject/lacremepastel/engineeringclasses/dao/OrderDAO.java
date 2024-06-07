package com.ispwproject.lacremepastel.engineeringclasses.dao;

import com.ispwproject.lacremepastel.engineeringclasses.query.OrderQuery;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Configurations;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Connector;
import com.ispwproject.lacremepastel.model.Order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class OrderDAO {
    public boolean saveOrder(Order order) {
        if(order == null){
            return false;
        }
        int idOrder, isPending, isAccepted, isClosed;
        if(order.isPending()) {
            isPending = 1;
            isAccepted = 0;
        }else{
            if( order.isAccepted()){
                isAccepted = 1;
                isPending = 0;
            }else {
                isPending = 0;
                isAccepted = 0;
            }
        }

        if(order.isClosed()) {
            isClosed = 1;
        }
        else {
            isClosed = 0;
        }
        OrderLineDAO orderLineDAO = new OrderLineDAO();
        try(ResultSet rs =  OrderQuery.createSimpleOrder(Connector.getConnection(), isPending, isAccepted, isClosed, order.getCustomerName())) {
            if(rs.next()){
                idOrder = rs.getInt("insert_id");
                orderLineDAO.saveOrderLines(idOrder,order.getCart());
                return true;
            }
        } catch (SQLException e) {
            Logger.getLogger(Configurations.getInstance().getProperty("LOGGER_NAME")).severe(e.getMessage());
            orderLineDAO.cleanOnFail(order.getIdOrder());
            this.cleanOnFail(order);
        }
        return false;
    }

    private void cleanOnFail(Order order){
        System.err.println("Cleaning order on failed insert");
        OrderQuery.cleanOnFail(Connector.getConnection(), order.getIdOrder());
    }
}

