package com.ispwproject.lacremepastel.controller.cli.utils;

import com.ispwproject.lacremepastel.controller.cli.states.AbstractState;
import com.ispwproject.lacremepastel.controller.cli.states.LoginPage;
import com.ispwproject.lacremepastel.controller.cli.states.RegisterPage;

public class CLIStateMachine implements StateMachine{

    private AbstractState currentState;

    public CLIStateMachine() {
        this.currentState = AbstractState.getInitialState();
        this.currentState.entry(this);
    }

    @Override
    public void goNext(Events e) {
        switch (e){
            case LOGIN -> this.changeState(new LoginPage());
            case REGISTER -> this.changeState(new RegisterPage());
        }
    }

    public void changeState(AbstractState newState){
        this.currentState.exit(this);
        this.currentState = newState;
        this.currentState.entry(this);
    }
}
