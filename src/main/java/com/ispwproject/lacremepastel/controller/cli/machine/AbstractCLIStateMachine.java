package com.ispwproject.lacremepastel.controller.cli.machine;

import com.ispwproject.lacremepastel.controller.cli.states.AbstractState;

public abstract class AbstractCLIStateMachine {

    protected String message;
    protected AbstractState state;
    protected AbstractState nextState;

    protected abstract void transition(AbstractState newState);

    public AbstractState getState() {
        return state;
    }
    public AbstractState getNextState() {
        return nextState;
    }
    public String getMessage(){return message;}
    public void setMessage(String message){this.message = message;}

    public abstract void printMessage();
    public abstract String readInput();

}
