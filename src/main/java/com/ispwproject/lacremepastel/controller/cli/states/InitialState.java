package com.ispwproject.lacremepastel.controller.cli.states;

import com.ispwproject.lacremepastel.controller.cli.machine.AbstractCLIStateMachine;
import com.ispwproject.lacremepastel.controller.cli.other.CLIMessages;

public class InitialState extends AbstractState{
    public InitialState() {
        super();
    }

    @Override
    public void entry(AbstractCLIStateMachine contextSM) {
        StringBuilder message = new StringBuilder();
        message.append(CLIMessages.welcome);
        message.append(CLIMessages.chooseExpr);
        for(int i = 1; i<= this.availableStates.size(); i++){
            message.append(i).append(") ").append(this.availableStates.get(i).stateName.toString()).append("\n");
        }
        message.append(CLIMessages.promptExpr);
        contextSM.setMessage(message.toString());
    }
}
