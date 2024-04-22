package com.ispwproject.lacremepastel.controller.cli.states;

import com.ispwproject.lacremepastel.controller.cli.machines.StateMachine;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractState {

    protected ArrayList<AbstractState> availableStates;

    public static AbstractState getInitialState(){
        return null;
    }

    protected AbstractState(List<AbstractState> availableStates) {
        this.availableStates = (ArrayList<AbstractState>) availableStates;
    }

    public List<AbstractState> getAvailableStates() {
        return availableStates.stream().toList();
    }

    public void entry(StateMachine contextSM){}
    public void exit(StateMachine contextSM){}
}
