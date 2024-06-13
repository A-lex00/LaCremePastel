package com.ispwproject.lacremepastel.engineeringclasses.dao;

import com.ispwproject.lacremepastel.engineeringclasses.query.OrderLineQuery;
import com.ispwproject.lacremepastel.engineeringclasses.query.OrderQuery;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Configurations;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Connector;
import com.ispwproject.lacremepastel.model.OrderLine;

import java.sql.SQLException;
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
            OrderQuery.cleanOnFail(Connector.getConnection(), orderId);
        }catch (SQLException e){
            Logger.getLogger(Configurations.LOGGER_NAME).severe(e.getMessage());
        }
    }

}
