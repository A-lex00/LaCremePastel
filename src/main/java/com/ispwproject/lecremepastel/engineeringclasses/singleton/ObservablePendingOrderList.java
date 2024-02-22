package com.ispwproject.lecremepastel.engineeringclasses.singleton;

import com.ispwproject.lecremepastel.engineeringclasses.bean.OrderLineBean;
import com.ispwproject.lecremepastel.engineeringclasses.dao.OrderLineDAO;
import com.ispwproject.lecremepastel.engineeringclasses.dao.ProductDAO;
import com.ispwproject.lecremepastel.engineeringclasses.dao.SimpleOrderDAO;
import com.ispwproject.lecremepastel.engineeringclasses.observer.Subject;
import com.ispwproject.lecremepastel.model.OrderLine;
import com.ispwproject.lecremepastel.model.Product;
import com.ispwproject.lecremepastel.model.SimpleOrder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ObservablePendingOrderList extends Subject {

    private final ArrayList<SimpleOrder> orderList = new ArrayList<>();
    private static ObservablePendingOrderList instance = null;

    private ObservablePendingOrderList(){

    }

    public static ObservablePendingOrderList getInstance(){
        if(instance == null){
            initialize();
        }
        return instance;
    }


    public void addSimpleOrder(SimpleOrder simpleOrder){
        synchronized (this){
            int index = orderList.indexOf(simpleOrder);
            if(index >= 0){
                orderList.remove(index);
            }
            orderList.add(simpleOrder);
        }
        notifyObservers();
    }

    public void removeSimpleOrder(SimpleOrder simpleOrder){
        boolean ret;
        synchronized (this) {
            ret = orderList.remove(simpleOrder);
        }
        if(ret){
            notifyObservers();
        }
    }

    public SimpleOrder removeSimpleOrder(int index){
        SimpleOrder ret;
        synchronized (this) {
            ret = orderList.remove(index);
        }
        if(ret != null){
            notifyObservers();
        }
        return ret;
    }

    public List<SimpleOrder> getState(){
        synchronized (this){
            return this.orderList;
        }
    }

    private static void initialize(){
        instance = new ObservablePendingOrderList();

        SimpleOrderDAO simpleOrderDAO = new SimpleOrderDAO();
        OrderLineDAO orderLineDAO = new OrderLineDAO();
        ProductDAO productDAO = new ProductDAO();

        //Organizing all data
        try {
            ArrayList<SimpleOrder> orderList = (ArrayList<SimpleOrder>) simpleOrderDAO.getAllOrders(true);
            for (SimpleOrder order : orderList) {
                ArrayList<OrderLineBean> lineList = (ArrayList<OrderLineBean>) orderLineDAO.loadOrderLines(order.getId());
                for (OrderLineBean line : lineList) {
                    Product p = productDAO.getProduct(line.getProductId());
                    order.addProduct(new OrderLine(
                            p,
                            line.getAmount()
                    ));
                }
                instance.addSimpleOrder(order);
            }
        }catch(IOException | ClassNotFoundException e){
            e.fillInStackTrace();
            System.err.println(e.getMessage());
        }
    }
}