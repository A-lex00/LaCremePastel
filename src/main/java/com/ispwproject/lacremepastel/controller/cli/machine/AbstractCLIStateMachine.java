package com.ispwproject.lacremepastel.controller.cli.machine;

import com.ispwproject.lacremepastel.controller.cli.states.AbstractState;
import com.ispwproject.lacremepastel.engineeringclasses.bean.ProductBean;
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
    //Va aggiornata con OrderLineBean
    protected ArrayList<ProductBean> cart;
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

    public void addProductToCart(ProductBean productBean){
        this.cart.add(productBean);
    }

    public void delProductFromCart(ProductBean productBean){
        this.cart.remove(productBean);
    }

    public ProductBean delProductFromCart(int index){
        return this.cart.remove(index);
    }

    public void clearCart(){
        this.cart.clear();
    }

    public List<ProductBean> getCart(){
        return this.cart.stream().toList();
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