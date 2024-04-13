package com.ispwproject.lacremepastel.controller.cli.machines;

import com.ispwproject.lacremepastel.controller.cli.other.Events;
import com.ispwproject.lacremepastel.controller.cli.states.AbstractState;

public interface StateMachine {
    void transition(Events e);
    void doAction(AbstractState newState);
}
