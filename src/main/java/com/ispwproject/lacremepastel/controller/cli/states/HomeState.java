package com.ispwproject.lacremepastel.controller.cli.states;

import com.ispwproject.lacremepastel.controller.cli.machine.AbstractCLIStateMachine;
import com.ispwproject.lacremepastel.controller.cli.other.CLIMessages;

public class HomeState extends AbstractState{
    public HomeState() {super();}

    @Override
    public void entry(AbstractCLIStateMachine contextSM) {
        StringBuilder message = new StringBuilder();
        String username = contextSM.getSessionData().getUsername();
        message.append("Hi ").append(username).append('\n');
        message.append(CLIMessages.CHOOSE_EXPR);
        message.append(prettifyAvailableStates());
        message.append(CLIMessages.PROMPT_EXPR);
        contextSM.setMessage(message.toString());
    }

}
