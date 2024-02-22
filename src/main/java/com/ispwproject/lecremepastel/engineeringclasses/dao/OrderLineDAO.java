package com.ispwproject.lecremepastel.engineeringclasses.dao;

import com.ispwproject.lecremepastel.engineeringclasses.bean.OrderLineBean;
import com.ispwproject.lecremepastel.engineeringclasses.query.OrderLineQuery;
import com.ispwproject.lecremepastel.engineeringclasses.singleton.Connector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderLineDAO {

    public boolean saveOrderLine(OrderLineBean ol){
        try{
            OrderLineQuery.insertOrderLine(Connector.getConnection(),ol.getOrderId(),ol.getProductId(),ol.getAmount());
            return true;
        }catch(SQLException e){
            e.fillInStackTrace();
        }
        return false;
    }

    public List<OrderLineBean> loadOrderLines(int orderId){
        ArrayList<OrderLineBean> orderList = new ArrayList<>();
        try(ResultSet rs = OrderLineQuery.loadOrderLines(Connector.getConnection(), orderId)){
            while(rs.next()){
                int pid = rs.getInt("product");
                int amount = rs.getInt("amount");
                OrderLineBean orderLineBean = new OrderLineBean();
                orderLineBean.setOrderId(orderId);
                orderLineBean.setProductId(pid);
                orderLineBean.setAmount(amount);
                orderLineBean.setUnitPrice(0);
                orderList.add(orderLineBean);
            }
        } catch (SQLException e) {
            e.fillInStackTrace();
        }
        return orderList;
    }

    public boolean updateOrderLine(OrderLineBean ol){
        try {
            OrderLineQuery.updateOrderLine(Connector.getConnection(), ol.getOrderId(), ol.getProductId(), ol.getAmount());
            return true;
        }catch(SQLException e){
            e.fillInStackTrace();
        }
        return false;
    }

    public boolean deleteOrderLine(OrderLineBean ol){
        try{
            OrderLineQuery.deleteOrderLine(Connector.getConnection(), ol.getOrderId(), ol.getProductId());
            return true;
        } catch (SQLException e) {
            e.fillInStackTrace();
        }
        return false;
    }

}
