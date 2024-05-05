package com.ispwproject.lacremepastel.controller.cli.machine;

import com.ispwproject.lacremepastel.controller.cli.states.AbstractState;
import com.ispwproject.lacremepastel.engineeringclasses.dao.StateDAO;

public abstract class AbstractCLIStateMachine {

    protected String message;
    protected AbstractState state;
    protected AbstractState nextState;
    protected boolean running;

    protected AbstractCLIStateMachine(){
        state = new StateDAO().loadInitialState();
        if(this.state == null){
            throw new IllegalStateException("Failed to initialize the state machine");
        }
        nextState = null;
        message = "";
        running = true;
        state.entry(this);
    }

    protected abstract void transition(AbstractState newState);

    public AbstractState getState() {
        return state;
    }
    public AbstractState getNextState() {
        return nextState;
    }
    public String getMessage(){return message;}
    public void setMessage(String message){this.message = message;}
    public boolean isRunning(){return running;}
    public void toggleRunning(){this.running = !this.running;}

    public abstract void printMessage();
    public abstract void processInput(String input);
}
