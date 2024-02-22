package com.ispwproject.lecremepastel.engineeringclasses.dao;

import com.ispwproject.lecremepastel.engineeringclasses.query.SimpleOrderQuery;
import com.ispwproject.lecremepastel.engineeringclasses.singleton.Configurations;
import com.ispwproject.lecremepastel.engineeringclasses.singleton.Connector;
import com.ispwproject.lecremepastel.model.SimpleOrder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SimpleOrderDAO{

    private static final int ORDERTYPE = Integer.parseInt(Configurations.getInstance().getProperty("SIMPLE"));
    private static final String PENDING_COLUMN = "pending";
    private static final String ACCEPTED_COLUMN = "accepted";
    private static final String DONE_COLUMN = "done";
    private static final String CUSTOMER_COLUMN = "customer";
    private static final String ID_COLUMN = "id";

    /**
     * This method creates a new SimpleOrder in database.
     * Note that the original SimpleOrder <strong>will be updated with the generated Order ID</strong>
     *
     * @param simpleOrder SimpleOrder Model instance
     * @return The same simpleOrder passed as parameter
     * @throws SQLException Thrown only if a database error occurs
     */
    public SimpleOrder createSimpleOrder(SimpleOrder simpleOrder) throws SQLException{
        try(ResultSet rs = SimpleOrderQuery.insertOrder(
                Connector.getConnection(),
                simpleOrder.getCustomer(),
                simpleOrder.isPending()?1:0,
                simpleOrder.isAccepted()?1:0,
                simpleOrder.isDone()?1:0,
                ORDERTYPE
        )){
            if(rs.next()){
                simpleOrder.setId(rs.getInt(1));
            }
        }
        return simpleOrder;
    }

    public SimpleOrder getOrder(int orderId, String username) {
        try(ResultSet rs = SimpleOrderQuery.selectOrder(Connector.getConnection(),orderId,username)){
            if(rs.next()) {
                boolean pending = rs.getBoolean(PENDING_COLUMN);
                boolean accepted = rs.getBoolean(ACCEPTED_COLUMN);
                boolean done = rs.getBoolean(DONE_COLUMN);
                return new SimpleOrder(orderId,username,pending,accepted,done);
            }
        }catch(SQLException e){
            e.fillInStackTrace();
        }
        return null;
    }

    public List<SimpleOrder> getAllOrders(String username) {
        ArrayList<SimpleOrder> list = new ArrayList<>();
        try(ResultSet rs = SimpleOrderQuery.selectAllOrders(Connector.getConnection(),username,ORDERTYPE)){
            while(rs.next()) {
                int orderId = rs.getInt("id");
                boolean pending = rs.getBoolean(PENDING_COLUMN);
                boolean accepted = rs.getBoolean(ACCEPTED_COLUMN);
                boolean done = rs.getBoolean(DONE_COLUMN);
                list.add(new SimpleOrder(orderId, username, pending, accepted, done));
            }
        }catch(SQLException e){
            e.fillInStackTrace();
        }
        return list;
    }

    public List<SimpleOrder> getAllOrders(boolean onlyPending) {
        ArrayList<SimpleOrder> list = new ArrayList<>();
        try(ResultSet rs = SimpleOrderQuery.selectAllOrders(Connector.getConnection(),ORDERTYPE,onlyPending)){
            while(rs.next()) {
                int orderId = rs.getInt(ID_COLUMN);
                boolean pending = rs.getBoolean(PENDING_COLUMN);
                boolean accepted = rs.getBoolean(ACCEPTED_COLUMN);
                boolean done = rs.getBoolean(DONE_COLUMN);
                String customer = rs.getString(CUSTOMER_COLUMN);
                list.add(new SimpleOrder(orderId, customer, pending, accepted, done));
            }
        }catch(SQLException e){
            e.fillInStackTrace();
        }
        return list;
    }

    public void updatePendingOrder(int orderId, boolean accepted){
        try{
            SimpleOrderQuery.updatePendingOrder(Connector.getConnection(), orderId, accepted);
        }catch(SQLException e){
            e.fillInStackTrace();
        }
    }
}
