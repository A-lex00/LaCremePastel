package com.ispwproject.lacremepastel.controller.cli.machine;

import com.ispwproject.lacremepastel.controller.cli.states.AbstractState;
import com.ispwproject.lacremepastel.engineeringclasses.exception.InvalidParameterException;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Configurations;

import java.util.logging.Logger;

public class ConcreteCLI extends AbstractCLIStateMachine {

    public ConcreteCLI() {
        super();
    }

    @Override
    public void transition(AbstractState newState) {
        this.state.exit(this);
        this.state = newState;
        this.state.entry(this);
    }

    @Override
    public void printMessage(){
        System.out.print(message);
    }

    @Override
    public void processInput(String input) throws InvalidParameterException{
        int choose;
        try {
            choose = Integer.parseInt(input);
            AbstractState chosenState = this.state.getChosenState(choose);
            if(chosenState == null){
                throw new InvalidParameterException("Invalid input: "+input);
            }
            transition(chosenState);
        }catch (NumberFormatException e){
            Logger.getLogger(Configurations.getInstance().getProperty("LOGGER_NAME")).info(e.getMessage());
            throw new InvalidParameterException("Invalid input: "+input);
        }
    }

}
