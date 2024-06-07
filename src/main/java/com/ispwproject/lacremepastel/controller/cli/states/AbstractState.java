package com.ispwproject.lacremepastel.controller.cli.states;

import com.ispwproject.lacremepastel.controller.cli.machine.AbstractCLIStateMachine;
import com.ispwproject.lacremepastel.controller.cli.other.SupportedStates;
import java.util.*;

public abstract class AbstractState {

    protected HashMap<Integer,AbstractState> availableStates;
    protected SupportedStates state;
    protected String stateName;

    protected AbstractState() {
        this.availableStates = new HashMap<>();
    }

    public List<AbstractState> getAvailableStates() {
        ArrayList<AbstractState> list = new ArrayList<>();
        for(int i = 0; i<availableStates.size(); i++){
            AbstractState availableState = this.availableStates.get(i);
            if(availableState != null) {
                list.add(availableState);
            }
        }
        return list;
    }

    public void addState(AbstractState state) {
        this.availableStates.put(this.availableStates.size()+1,state);
    }

    public void removeState(int id) {
        this.availableStates.remove(id);
    }

    public void clearStateLinks(){
        this.availableStates.clear();
    }

    public AbstractState getState(int id){
        return this.availableStates.get(id);
    }

    public String getState(){
        return state.toString();
    }

    public void setState(SupportedStates newName){
        this.state = newName;
    }

    public AbstractState getChosenState(int choose){
        return this.availableStates.get(choose);
    }

    public void entry(AbstractCLIStateMachine contextSM){}
    public void exit(AbstractCLIStateMachine contextSM){contextSM.setMessage("");}

    /**
     * @param contextSM Concrete instance AbstractCLIStateMachine
     * @return true if there is something to do, false otherwise
     */
    public boolean doAction(AbstractCLIStateMachine contextSM){
        contextSM.printMessage();
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractState that = (AbstractState) o;
        return state == that.state;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(state);
    }

    @Override
    public String toString() {
        return "AbstractState{" +
                "availableStates=" + availableStates +
                ", stateName=" + state +
                '}';
    }

    public String prettifyAvailableStates(){
        StringBuilder builder = new StringBuilder();
        for(int i = 1; i<= this.availableStates.size(); i++){
            builder.append(i).append(") ").append(this.availableStates.get(i).state.toString()).append("\n");
        }
        return builder.toString();
    }
}
