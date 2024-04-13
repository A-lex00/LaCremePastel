package com.ispwproject.lacremepastel.controller.cli.states;

import com.ispwproject.lacremepastel.controller.cli.machines.StateMachine;

public abstract class AbstractState {

    public static AbstractState getInitialState(){
        return new LandingPage();
    }

    public void entry(StateMachine contextSM){}
    public void exit(StateMachine contextSM){}
}
