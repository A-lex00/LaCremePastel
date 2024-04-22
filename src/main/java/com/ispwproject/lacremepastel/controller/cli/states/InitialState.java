package com.ispwproject.lacremepastel.controller.cli.states;

import com.ispwproject.lacremepastel.controller.cli.machines.StateMachine;

import java.util.List;

public class InitialState extends AbstractState{
    protected InitialState(List<AbstractState> availableStates) {
        super(availableStates);
    }

    @Override
    public void entry(StateMachine contextSM) {
        super.entry(contextSM);
    }

    @Override
    public void exit(StateMachine contextSM) {
        super.exit(contextSM);
    }
}
