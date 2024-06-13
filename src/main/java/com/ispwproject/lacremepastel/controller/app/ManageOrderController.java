package com.ispwproject.lacremepastel.controller.app;

import com.ispwproject.lacremepastel.engineeringclasses.bean.OrderBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.OrderLineBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.ProductBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.SessionBean;
import com.ispwproject.lacremepastel.engineeringclasses.dao.OrderDAO;
import com.ispwproject.lacremepastel.model.Order;
import com.ispwproject.lacremepastel.model.OrderLine;
import com.ispwproject.lacremepastel.model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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

    public List<OrderBean> getAllOrders(SessionBean sessionBean) {
        LoginController loginController = new LoginController();
        loginController.checkLogin(sessionBean);
        List<Order> order;
        List<OrderBean> orderBeans = new ArrayList<>();
        OrderDAO orderDAO = new OrderDAO();
        order =  orderDAO.getAllOrder(sessionBean);

       //Conversione Model --> Bean
        for(Order orderIndex : order) {
            OrderBean orderBean = new OrderBean(orderIndex.getCustomerName(), orderIndex.getIdOrder());
            orderBeans.add(orderBean);
        }
        return orderBeans;
    }

    public ObservableList<OrderLineBean> getOrderById(SessionBean sessionBean, int idOrder) {
        LoginController loginController = new LoginController();
        loginController.checkLogin(sessionBean);
        List<OrderLine> orderLines;
        List<OrderLineBean> orderLineBeans = new ArrayList<>();
        OrderDAO orderDAO = new OrderDAO();

        orderLines = orderDAO.getOrderLinesByID(idOrder);

        //Conversione Model --> Bean
        for (OrderLine line : orderLines){
            ProductBean productBean = new ProductBean(line.getProduct().getName());
            OrderLineBean orderLineBean = new OrderLineBean(productBean,line.getAmount());
        }
        ObservableList<OrderLineBean> observableList = FXCollections.observableList(orderLineBeans);
        return observableList;
    }
}
