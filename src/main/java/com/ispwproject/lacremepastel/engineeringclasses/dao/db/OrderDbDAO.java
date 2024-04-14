package com.ispwproject.lacremepastel.engineeringclasses.dao.db;

import com.ispwproject.lacremepastel.engineeringclasses.bean.OrderBean;
import com.ispwproject.lacremepastel.engineeringclasses.dao.OrderDAO;
import com.ispwproject.lacremepastel.model.Order;

public class OrderDbDAO implements OrderDAO {
    @Override
    public boolean saveOrder(OrderBean orderBean) {
        return false;
    }
}
