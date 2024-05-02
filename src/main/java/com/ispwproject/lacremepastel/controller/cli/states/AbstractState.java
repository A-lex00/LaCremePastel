package com.ispwproject.lacremepastel.controller.cli.states;

import com.ispwproject.lacremepastel.controller.cli.machines.StateMachine;
import com.ispwproject.lacremepastel.controller.cli.other.SupportedStates;
import com.ispwproject.lacremepastel.engineeringclasses.exception.InvalidParameterException;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractState {

    protected ArrayList<AbstractState> availableStates;
    protected SupportedStates stateName;

    protected AbstractState() {
        this.availableStates = new ArrayList<>();
    }

    public List<AbstractState> getAvailableStates() {
        return availableStates.stream().toList();
    }

    public void addState(AbstractState state) {
        this.availableStates.add(state);
    }

    public void removeState(AbstractState state) {
        this.availableStates.remove(state);
    }

    public String getStateName(){
        return stateName.toString();
    }

    public void setStateName(SupportedStates newName){
        this.stateName = newName;
    }

    public void entry(StateMachine contextSM){}
    public void exit(StateMachine contextSM) throws InvalidParameterException {}
}
