package com.ispwproject.lacremepastel.controller.cli.machines;

import com.ispwproject.lacremepastel.controller.cli.other.SupportedStates;
import com.ispwproject.lacremepastel.controller.cli.states.AbstractState;

public abstract class StateMachine {

    protected abstract void transition(SupportedStates e);

    protected abstract void doAction(AbstractState newState);


}
