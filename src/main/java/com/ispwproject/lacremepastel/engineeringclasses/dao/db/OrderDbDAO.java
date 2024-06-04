package com.ispwproject.lacremepastel.engineeringclasses.dao.db;

import com.ispwproject.lacremepastel.engineeringclasses.bean.OrderBean;
import com.ispwproject.lacremepastel.engineeringclasses.dao.OrderDAO;
import com.ispwproject.lacremepastel.model.Order;

import java.util.List;

public class OrderDbDAO implements OrderDAO {
    @Override
    public boolean saveOrder(OrderBean orderBean) {
        return false;
    }


    @Override
    public List<OrderBean> retriveOrder() {

    }
}
