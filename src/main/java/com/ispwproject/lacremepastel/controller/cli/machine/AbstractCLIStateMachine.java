package com.ispwproject.lacremepastel.controller.cli.machine;

import com.ispwproject.lacremepastel.controller.cli.states.AbstractState;
import com.ispwproject.lacremepastel.engineeringclasses.bean.OrderLineBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.SessionBean;
import com.ispwproject.lacremepastel.engineeringclasses.dao.StateDAO;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCLIStateMachine {

    protected String message;
    protected AbstractState state;
    protected AbstractState prevState;
    protected boolean running;

    protected SessionBean sessionData;
    protected ArrayList<OrderLineBean> cart;
    protected StateDAO stateDAO;

    protected AbstractCLIStateMachine(StateDAO stateDAO){
        cart = new ArrayList<>();
        this.stateDAO = stateDAO;
        state = this.stateDAO.loadInitialState();
        if(this.state == null){
            throw new IllegalStateException("Failed to initialize the state machine");
        }
        message = "";
        running = true;
        state.entry(this);
    }

    public AbstractState getState() {
        return state;
    }
    public AbstractState getPrevState() {
        return prevState;
    }
    public String getMessage(){return message;}

    public void setMessage(String message){this.message = message;}

    public boolean isRunning(){return running;}

    public void toggleRunning(){this.running = !this.running;}

    public SessionBean getSessionData(){return this.sessionData;}

    public void setSessionData(SessionBean sessionData){this.sessionData = sessionData;}

    public void addToCart(OrderLineBean productBean){
        this.cart.add(productBean);
    }

    public void delFromCart(OrderLineBean productBean){
        this.cart.remove(productBean);
    }

    public OrderLineBean delFromCart(int index){
        return this.cart.remove(index);
    }

    public OrderLineBean getFromCart(int index){
        return this.cart.get(index);
    }

    public void clearCart(){
        this.cart.clear();
    }

    public List<OrderLineBean> getCart(){
        return this.cart.stream().toList();
    }

    public int cartLength(){
        return this.cart.size();
    }

    public void transition(AbstractState nextState){
        this.state.exit(this);
        this.prevState = this.state;
        this.state = nextState;
        stateDAO.loadStateLinks(this.state);
        this.state.entry(this);
    }

    public abstract void printMessage();
    public abstract void changeState();
    public abstract boolean doAction();
    public abstract String readInput();
}