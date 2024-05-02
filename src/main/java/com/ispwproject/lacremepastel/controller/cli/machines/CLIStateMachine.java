package com.ispwproject.lacremepastel.controller.cli.machines;

import com.ispwproject.lacremepastel.controller.cli.states.AbstractState;
import com.ispwproject.lacremepastel.engineeringclasses.dao.StateDAO;
import com.ispwproject.lacremepastel.engineeringclasses.exception.InvalidParameterException;

import java.util.Scanner;
import java.util.logging.Logger;

public class CLIStateMachine extends StateMachine {

    private AbstractState currentState;
    private Scanner scanner;

    public CLIStateMachine() {
        this.currentState = new StateDAO().loadInitialState();
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void transition(AbstractState newState) {
        try {
            this.currentState.exit(this);
            this.currentState = newState;
            this.currentState.entry(this);
        }catch (InvalidParameterException e){
            Logger.getLogger(CLIStateMachine.class.getName()).info("Invalid input");
        }
    }

    public void printMenu(String menu){
        System.out.println(menu);
    }

    public String readUserInput(){
        return scanner.nextLine();
    }

}
