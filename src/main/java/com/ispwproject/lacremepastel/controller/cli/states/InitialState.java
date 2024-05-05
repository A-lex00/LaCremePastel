package com.ispwproject.lacremepastel.controller.cli.states;

import com.ispwproject.lacremepastel.controller.cli.machine.AbstractCLIStateMachine;
import com.ispwproject.lacremepastel.controller.cli.other.CLIMessages;

public class InitialState extends AbstractState{
    public InitialState() {
        super();
    }

    @Override
    public void entry(AbstractCLIStateMachine contextSM) {
        String message = CLIMessages.welcome + "\n" +
                CLIMessages.landingMenu + "\n" +
                CLIMessages.promptExpr;
        contextSM.setMessage(message);
    }

    @Override
    public void exit(AbstractCLIStateMachine contextSM) {
        System.out.println("InitialState: exit");
        if(!this.isStateAvailable(contextSM.getNextState())){
            throw new IllegalStateException("Invalid next state: "+contextSM.getNextState());
        }
    }
}
