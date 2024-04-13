package com.ispwproject.lacremepastel.controller.cli.machines;

import com.ispwproject.lacremepastel.controller.cli.states.AbstractState;
import com.ispwproject.lacremepastel.controller.cli.states.LoginPage;
import com.ispwproject.lacremepastel.controller.cli.states.RegisterPage;
import com.ispwproject.lacremepastel.controller.cli.other.Events;

public class CLIStateMachine implements StateMachine {

    private AbstractState currentState;

    public CLIStateMachine() {
        this.currentState = AbstractState.getInitialState();
        this.currentState.entry(this);
    }

    @Override
    public void doAction(AbstractState newState){
        this.currentState.exit(this);
        this.currentState = newState;
        this.currentState.entry(this);
    }

    @Override
    public void transition(Events e) {
        switch (e){
            case LOGIN -> this.doAction(new LoginPage());
            case REGISTER -> this.doAction(new RegisterPage());
        }
    }
}
