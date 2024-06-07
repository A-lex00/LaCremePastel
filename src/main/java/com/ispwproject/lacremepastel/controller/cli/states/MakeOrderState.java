package com.ispwproject.lacremepastel.controller.cli.states;

import com.ispwproject.lacremepastel.controller.cli.machine.AbstractCLIStateMachine;
import com.ispwproject.lacremepastel.controller.cli.other.CLIMessages;
import com.ispwproject.lacremepastel.engineeringclasses.exception.InvalidParameterException;

public class MakeOrderState extends AbstractState{

    @Override
    public boolean doAction(AbstractCLIStateMachine contextSM) {
        StringBuilder sb = new StringBuilder(CLIMessages.CHOOSE_EXPR);
        sb.append(CLIMessages.REWIND);
        sb.append(prettifyAvailableStates());
        sb.append(CLIMessages.PROMPT_EXPR);
        contextSM.setMessage(sb.toString());
        contextSM.printMessage();
        try {
            int choose = Integer.parseInt(contextSM.readInput());
            if(choose == 0){
                contextSM.rewind();
            }else{
                contextSM.changeState(choose);
            }
        }catch (NumberFormatException e){
            throw new InvalidParameterException("Invalid Input");
        }
        return true;
    }
}
