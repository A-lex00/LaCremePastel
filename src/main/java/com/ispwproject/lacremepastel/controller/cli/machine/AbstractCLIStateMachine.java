package com.ispwproject.lacremepastel.controller.cli.machine;

import com.ispwproject.lacremepastel.controller.cli.states.AbstractState;
import com.ispwproject.lacremepastel.engineeringclasses.bean.SessionBean;
import com.ispwproject.lacremepastel.engineeringclasses.dao.StateDAO;

public abstract class AbstractCLIStateMachine {

    protected String message;
    protected AbstractState state;
    protected AbstractState nextState;
    protected boolean running;
    protected SessionBean sessionData;

    protected AbstractCLIStateMachine(){
        state = new StateDAO().loadInitialState();
        if(this.state == null){
            throw new IllegalStateException("Failed to initialize the state machine");
        }
        message = "";
        running = true;
        state.entry(this);
    }

    protected abstract void transition(AbstractState newState);

    public AbstractState getState() {
        return state;
    }
    public AbstractState getPrevState() {
        return nextState;
    }
    public String getMessage(){return message;}
    public void setMessage(String message){this.message = message;}
    public boolean isRunning(){return running;}
    public void toggleRunning(){this.running = !this.running;}
    public SessionBean getSessionData(){return this.sessionData;}
    public void setSessionData(SessionBean sessionData){this.sessionData = sessionData;}

    public abstract void printMessage();
    public abstract void changeState();
    public abstract boolean doAction();
    public abstract String readInput();
}
