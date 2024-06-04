package com.ispwproject.lacremepastel.engineeringclasses.dao;

import com.ispwproject.lacremepastel.engineeringclasses.bean.OrderBean;
import com.ispwproject.lacremepastel.model.Order;

import java.util.List;

public interface OrderDAO {
    boolean saveOrder(OrderBean orderBean);
    List<OrderBean> retriveOrder(OrderBean orderBean);


}
