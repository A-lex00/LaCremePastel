package com.ispwproject.lacremepastel.engineeringclasses.dao;

import com.ispwproject.lacremepastel.engineeringclasses.factory.ProductDAOFactory;
import com.ispwproject.lacremepastel.engineeringclasses.query.OrderLineQuery;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Configurations;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Connector;
import com.ispwproject.lacremepastel.model.OrderLine;
import com.ispwproject.lacremepastel.model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class OrderLineDAO {

    public void saveOrderLines(int orderId, List<OrderLine> orderLines) throws SQLException {
        if(orderLines == null || orderLines.isEmpty()) {
            return;
        }
        for (OrderLine orderLine : orderLines) {
            OrderLineQuery.saveOrderLine(
                    Connector.getConnection(),
                    orderId,
                    orderLine.getProduct().getId(),
                    orderLine.getAmount()
            );
        }
    }

    public void cleanOnFail(int orderId){
        try {
            OrderLineQuery.cleanOnFail(Connector.getConnection(), orderId);
        }catch (SQLException e){
            Logger.getLogger(Configurations.LOGGER_NAME).severe(e.getMessage());
        }
    }

    public List<OrderLine> getOrderCartById(int orderId){
        ArrayList<OrderLine> orderLines = new ArrayList<>();
        ProductDAO productDAO = ProductDAOFactory.getInstance().createProductDAO();
        try(ResultSet rs = OrderLineQuery.getOrderLinesByOrderId(Connector.getConnection(),orderId)){
            while(rs.next()){
                Product product = productDAO.getProductById(rs.getInt("product"));
                OrderLine orderLine = new OrderLine(
                        product,
                        rs.getInt("amount")
                );
                orderLines.add(orderLine);
            }
        }catch (SQLException e){
            Logger.getLogger(Configurations.LOGGER_NAME).severe(e.getMessage());
        }
        return orderLines;
    }
}
