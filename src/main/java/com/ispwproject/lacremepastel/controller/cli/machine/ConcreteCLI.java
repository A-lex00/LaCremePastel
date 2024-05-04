package com.ispwproject.lacremepastel.controller.cli.machine;

import com.ispwproject.lacremepastel.controller.cli.states.AbstractState;
import com.ispwproject.lacremepastel.engineeringclasses.dao.StateDAO;
import com.ispwproject.lacremepastel.engineeringclasses.exception.InvalidParameterException;

import java.util.Scanner;
import java.util.logging.Logger;

public class ConcreteCLI extends AbstractCLIStateMachine {

    private final Scanner scanner;

    public ConcreteCLI() {
        this.state = new StateDAO().loadInitialState();
        if(this.state == null){
            throw new IllegalStateException("Failed to initialize the state machine");
        }
        this.nextState = null;
        this.scanner = new Scanner(System.in);
        this.state.entry(this);
    }

    @Override
    public void transition(AbstractState newState) {
        try {
            this.nextState = newState;
            this.state.exit(this);
            this.state = this.nextState;
            this.state.entry(this);
        }catch (InvalidParameterException e){
            Logger.getLogger(ConcreteCLI.class.getName()).info("Invalid input");
        }
        this.nextState = null;
    }

    @Override
    public void printMessage(){
        System.out.print(message);
    }

    @Override
    public String readInput(){
        return scanner.nextLine();
    }

}
