package com.ispwproject.lacremepastel.controller.cli.machine;

import com.ispwproject.lacremepastel.controller.cli.states.AbstractState;
import com.ispwproject.lacremepastel.engineeringclasses.dao.StateDAO;
import com.ispwproject.lacremepastel.engineeringclasses.exception.InvalidParameterException;
import java.util.Scanner;

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
    public void changeState(int choose){
        AbstractState chosenState = this.state.getChosenState(choose);
        if(chosenState == null){
            throw new InvalidParameterException("Invalid input: "+choose);
        }
        transition(chosenState);
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
