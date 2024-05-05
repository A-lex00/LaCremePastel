package com.ispwproject.lacremepastel.engineeringclasses.factory;

import com.ispwproject.lacremepastel.controller.cli.other.SupportedStates;
import com.ispwproject.lacremepastel.controller.cli.states.AbstractState;
import com.ispwproject.lacremepastel.controller.cli.states.InitialState;
import com.ispwproject.lacremepastel.controller.cli.states.LoginState;
import com.ispwproject.lacremepastel.controller.cli.states.RegisterState;
import com.ispwproject.lacremepastel.engineeringclasses.exception.InvalidParameterException;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Configurations;

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
                default -> throw new InvalidParameterException("Invalid state: " + stateName);
            }
            abstractState.setStateName(state);
        }catch (IllegalArgumentException e){
            Logger.getLogger(Configurations.getInstance().getProperty("LOGGER_NAME")).severe("Invalid state: " + stateName);
        }
        return abstractState;
    }

}
