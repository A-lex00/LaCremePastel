package com.ispwproject.lacremepastel.controller.cli.states;

import com.ispwproject.lacremepastel.controller.cli.utils.StateMachine;

public abstract class AbstractState {

    public static AbstractState getInitialState(){
        return new LandingPage();
    }

    public void entry(StateMachine contextSM){}
    public void exit(StateMachine contextSM){}
}
