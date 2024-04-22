package com.ispwproject.lacremepastel.controller.cli.machines;

import com.ispwproject.lacremepastel.controller.cli.states.AbstractState;
import com.ispwproject.lacremepastel.controller.cli.other.SupportedStates;

public class CLIStateMachine extends StateMachine {

    private AbstractState currentState;

    public CLIStateMachine() {
        this.currentState = AbstractState.getInitialState();
    }

    @Override
    public void doAction(AbstractState newState){
        this.currentState.exit(this);
        this.currentState = newState;
        this.currentState.entry(this);
    }

    @Override
    public void transition(SupportedStates e) {
    }

}
