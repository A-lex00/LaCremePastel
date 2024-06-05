package com.ispwproject.lacremepastel.controller.cli.states;

import com.ispwproject.lacremepastel.controller.cli.machine.AbstractCLIStateMachine;
import com.ispwproject.lacremepastel.controller.cli.other.CLIMessages;

public class MakeOrderState extends AbstractState{

    @Override
    public void entry(AbstractCLIStateMachine contextSM) {
        StringBuilder sb = new StringBuilder(CLIMessages.CHOOSE_EXPR);
        sb.append(prettifyAvailableStates());
        sb.append(CLIMessages.PROMPT_EXPR);
        contextSM.setMessage(sb.toString());
    }
}
