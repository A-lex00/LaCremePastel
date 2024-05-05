package com.ispwproject.lacremepastel.controller.cli.machine;

import com.ispwproject.lacremepastel.controller.cli.states.AbstractState;
import com.ispwproject.lacremepastel.engineeringclasses.dao.StateDAO;
import com.ispwproject.lacremepastel.engineeringclasses.exception.InvalidParameterException;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Configurations;

import java.util.logging.Logger;

public class ConcreteCLI extends AbstractCLIStateMachine {

    public ConcreteCLI() {
        super();
    }

    @Override
    public void transition(AbstractState newState) {
        if(newState == null){
            return;
        }
        try {
            this.nextState = newState;
            this.state.exit(this);
            this.state = this.nextState;
            this.state.entry(this);
        }catch (InvalidParameterException e){
            Logger.getLogger(Configurations.getInstance().getProperty("LOGGER_NAME")).info("Invalid input");
        }
        this.nextState = null;
    }

    @Override
    public void printMessage(){
        System.out.print(message);
    }

    @Override
    public void processInput(String input) throws InvalidParameterException{
        StateDAO stateDAO = new StateDAO();
        AbstractState requestedState;
        try {
            requestedState = stateDAO.loadStateInfo(Integer.parseInt(input));
            transition(requestedState);
        }catch (NumberFormatException e){
            throw new InvalidParameterException("Invalid Input");
        }
    }

}
