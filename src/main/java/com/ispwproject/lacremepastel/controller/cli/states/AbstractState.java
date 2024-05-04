package com.ispwproject.lacremepastel.controller.cli.states;

import com.ispwproject.lacremepastel.controller.cli.machine.AbstractCLIStateMachine;
import com.ispwproject.lacremepastel.controller.cli.other.SupportedStates;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    protected boolean isStateAvailable(AbstractState state){
        for(AbstractState s : availableStates){
            if(s.equals(state)){
                return true;
            }
        }
        return false;
    }

    public void entry(AbstractCLIStateMachine contextSM){}
    public void exit(AbstractCLIStateMachine contextSM) throws IllegalStateException{}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractState that = (AbstractState) o;
        return stateName == that.stateName;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(stateName);
    }

    @Override
    public String toString() {
        return "AbstractState{" +
                "availableStates=" + availableStates +
                ", stateName=" + stateName +
                '}';
    }
}
