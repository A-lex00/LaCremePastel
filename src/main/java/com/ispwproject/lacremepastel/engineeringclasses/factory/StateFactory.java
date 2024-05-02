package com.ispwproject.lacremepastel.engineeringclasses.factory;

import com.ispwproject.lacremepastel.controller.cli.other.SupportedStates;
import com.ispwproject.lacremepastel.controller.cli.states.AbstractState;
import com.ispwproject.lacremepastel.controller.cli.states.InitialState;
import com.ispwproject.lacremepastel.controller.cli.states.LoginState;
import com.ispwproject.lacremepastel.controller.cli.states.RegisterState;

import java.util.logging.Logger;

public class StateFactory {

    private static StateFactory instance = null;

    private StateFactory () {}

    public static StateFactory getInstance() {
        if(instance == null){
            instance = new StateFactory();
        }
        return instance;
    }

    public AbstractState createState(String stateName) {
        AbstractState abstractState = null;
        try {
            stateName = stateName.toUpperCase();
            SupportedStates state = SupportedStates.valueOf(stateName);
            switch (state) {
                case INITIAL -> abstractState = new InitialState();
                case LOGIN -> abstractState = new LoginState();
                case REGISTER -> abstractState = new RegisterState();
            }
        }catch (IllegalArgumentException e){
            Logger.getLogger(StateFactory.class.getName()).severe("Invalid state: " + stateName);
        }
        return abstractState;
    }

}
