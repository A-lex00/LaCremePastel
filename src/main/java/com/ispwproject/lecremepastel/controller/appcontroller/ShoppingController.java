package com.ispwproject.lecremepastel.controller.appcontroller;

import com.ispwproject.lecremepastel.engineeringclasses.bean.OrderLineBean;
import com.ispwproject.lecremepastel.model.OrderLine;

import java.io.IOException;

public class ShoppingController {

    public void setShoppingCart(OrderLineBean orderLineBean){
        try {
            OrderLine orderLine=new OrderLine(orderLineBean.ge);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    }
}
