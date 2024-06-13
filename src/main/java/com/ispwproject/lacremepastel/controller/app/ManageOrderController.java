package com.ispwproject.lacremepastel.controller.app;

import com.ispwproject.lacremepastel.engineeringclasses.bean.OrderBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.OrderLineBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.ProductBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.SessionBean;
import com.ispwproject.lacremepastel.engineeringclasses.dao.OrderDAO;
import com.ispwproject.lacremepastel.model.Order;
import com.ispwproject.lacremepastel.model.OrderLine;
import java.util.ArrayList;
import java.util.List;


public class ManageOrderController {

    private void manageOrder(Order order) {
        OrderDAO orderDAO = new OrderDAO();
        orderDAO.updateOrder(order);
    }

    public void acceptOrder(SessionBean sessionBean, OrderBean orderBean){
        LoginController loginController = new LoginController();
        loginController.checkLogin(sessionBean);

        Order order = new Order(
                orderBean.getIdOrder(),
                orderBean.getCustomerName()
        );
        order.setPending(false);
        order.setAccepted(true);
        order.setClosed(false);
        this.manageOrder(order);
    }

    public void rejectOrder(SessionBean sessionBean, OrderBean orderBean){
        LoginController loginController = new LoginController();
        loginController.checkLogin(sessionBean);

        Order order = new Order(
                orderBean.getIdOrder(),
                orderBean.getCustomerName()
        );
        order.setPending(false);
        order.setAccepted(false);
        order.setClosed(true);
        this.manageOrder(order);
    }

    public List<OrderBean> getPendingOrders(SessionBean sessionBean) {
        LoginController loginController = new LoginController();
        loginController.checkLogin(sessionBean);
        List<Order> order;
        List<OrderBean> orderBeans = new ArrayList<>();
        OrderDAO orderDAO = new OrderDAO();
        order =  orderDAO.getPendingOrders();

       //Conversione Model --> Bean
        for(Order orderIndex : order) {
            OrderBean orderBean = new OrderBean(orderIndex.getCustomerName(), orderIndex.getIdOrder());
            orderBeans.add(orderBean);
        }
        return orderBeans;
    }

    public OrderBean getOrderById(SessionBean sessionBean, int idOrder) {
        LoginController loginController = new LoginController();
        loginController.checkLogin(sessionBean);

        OrderDAO orderDAO = new OrderDAO();
        Order order = orderDAO.getOrderById(idOrder);
        return this.convertModel(order);
    }

    private OrderBean convertModel(Order order){
        ArrayList<OrderLineBean> convertedCart = new ArrayList<>();

        //Conversione Model --> Bean
        for(OrderLine orderLine : order.getCart()){
            ProductBean productBean = new ProductBean(
                    orderLine.getProduct().getId(),
                    orderLine.getProduct().getName(),
                    orderLine.getProduct().getPrice()
            );
            OrderLineBean orderLineBean = new OrderLineBean(productBean,orderLine.getAmount());
            convertedCart.add(orderLineBean);
        }

        return new OrderBean(
                order.getIdOrder(),
                order.getCustomerName(),
                convertedCart
        );
    }
}
