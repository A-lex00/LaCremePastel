package com.ispwproject.lacremepastel.engineeringclasses.dao;

import com.ispwproject.lacremepastel.engineeringclasses.query.OrderLineQuery;
import com.ispwproject.lacremepastel.engineeringclasses.query.OrderQuery;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Connector;
import com.ispwproject.lacremepastel.model.OrderLine;

import java.sql.SQLException;
import java.util.List;

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
        System.err.println("Cleaning orderlines on failed insert");
        OrderQuery.cleanOnFail(Connector.getConnection(), orderId);
    }

}
