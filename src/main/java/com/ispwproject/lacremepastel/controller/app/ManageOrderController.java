package com.ispwproject.lacremepastel.controller.app;

import com.ispwproject.lacremepastel.engineeringclasses.bean.OrderLineBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.SessionBean;
import com.ispwproject.lacremepastel.engineeringclasses.dao.OrderDAO;
import com.ispwproject.lacremepastel.model.Order;
import com.ispwproject.lacremepastel.model.OrderLine;
import com.ispwproject.lacremepastel.model.Product;

import java.util.ArrayList;
import java.util.List;


public class ManageOrderController {
    public void manage(List<OrderLineBean> cart, SessionBean sessionBean){

        LoginController loginController = new LoginController();
        loginController.checkLogin(sessionBean);
        String customer = sessionBean.getUsername();
        /** Conversione Bean --> Model
         */
        List<OrderLine> actualCart = new ArrayList<>();
        for(OrderLineBean  o : cart){
            Product  p =new Product(o.getProductBean().getId(),o.getProductName(),o.getPrice());
            OrderLine orderLine = new OrderLine(p, o.getAmount());
            actualCart.add(orderLine);
            System.out.println("ManageOrderController "+ orderLine.getProduct().getId());
        }
        OrderDAO orderDAO = new OrderDAO();
        Order order = new Order(customer,true,false,false,actualCart);
        orderDAO.saveOrder(order);
    }

    public List<Order> getAllOrders(SessionBean sessionBean) {
        LoginController loginController = new LoginController();
        loginController.checkLogin(sessionBean);
        List<Order> order = new ArrayList<>();
        OrderDAO orderDAO = new OrderDAO();
        order =  orderDAO.getAllOrder(sessionBean);
        return order;
    }
}
