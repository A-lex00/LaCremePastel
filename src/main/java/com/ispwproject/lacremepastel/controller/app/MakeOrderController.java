package com.ispwproject.lacremepastel.controller.app;

import com.ispwproject.lacremepastel.engineeringclasses.bean.OrderBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.OrderLineBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.SessionBean;
import com.ispwproject.lacremepastel.engineeringclasses.dao.OrderDAO;
import com.ispwproject.lacremepastel.engineeringclasses.exception.InvalidParameterException;
import com.ispwproject.lacremepastel.model.Order;
import com.ispwproject.lacremepastel.model.OrderLine;
import com.ispwproject.lacremepastel.model.Product;

import java.util.ArrayList;
import java.util.List;

public class MakeOrderController {

    public void createOrder(SessionBean sessionData, OrderBean orderBean) {
        //Check sessione
        LoginController loginController = new LoginController();
        loginController.checkLogin(sessionData);

        //Check orderBean
        if(orderBean == null){
            throw new InvalidParameterException("OrderBean can't be null");
        }else if(orderBean.getLength() == 0){
            throw new InvalidParameterException("Cart is empty!");
        }

        //Conversione Bean -> Model
        Order order = convertBean(orderBean);

        //Salvataggio dell'ordine
        OrderDAO orderDAO = new OrderDAO();
        orderDAO.saveOrder(order);
    }

    private Order convertBean(OrderBean orderBean) {
        List<OrderLineBean> cart = orderBean.getAllOrder();
        ArrayList<OrderLine> convertedCart = new ArrayList<>();
        for(OrderLineBean orderLineBean : cart){
            Product p = new Product(
                    orderLineBean.getProductBean().getId(),
                    orderLineBean.getProductBean().getProductName(),
                    orderLineBean.getProductBean().getPrice()
            );
            OrderLine o = new OrderLine(
                    p,
                    orderLineBean.getAmount()
            );
            convertedCart.add(o);
        }

        return new Order(
                orderBean.getCustomerName(),
                true,
                false,
                false,
                convertedCart
        );
    }

}
