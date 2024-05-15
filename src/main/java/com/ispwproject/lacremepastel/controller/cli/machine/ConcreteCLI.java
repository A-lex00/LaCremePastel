package com.ispwproject.lacremepastel.controller.cli.machine;

import com.ispwproject.lacremepastel.controller.cli.states.AbstractState;
import com.ispwproject.lacremepastel.engineeringclasses.dao.StateDAO;
import com.ispwproject.lacremepastel.engineeringclasses.exception.InvalidParameterException;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Configurations;
import java.util.Scanner;
import java.util.logging.Logger;

public class ConcreteCLI extends AbstractCLIStateMachine {

    private final Scanner scanner;

    public ConcreteCLI(StateDAO stateDAO) {
        super(stateDAO);
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void printMessage(){
        System.out.print(message);
    }

    @Override
    public void changeState() throws InvalidParameterException{
        String input = readInput();
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

    @Override
    public boolean doAction() {
        return this.state.doAction(this);
    }

    @Override
    public String readInput(){
        return this.scanner.nextLine();
    }

}
