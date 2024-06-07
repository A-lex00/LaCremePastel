package com.ispwproject.lacremepastel.engineeringclasses.factory;

import com.ispwproject.lacremepastel.controller.cli.other.SupportedStates;
import com.ispwproject.lacremepastel.controller.cli.states.*;
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
                case HOME -> abstractState = new HomeState();
                case MAKE_ORDER -> abstractState = new MakeOrderState();
                case MANAGE_ORDERS -> abstractState = new ManageOrdersState();
                case REFUND -> abstractState = new RefundState();
                case NOTICES -> abstractState = new NoticesState();
                case ADD_TO_CART -> abstractState = new AddToCartState();
                case SHOW_CART -> abstractState = new ShowCartState();
                case SAVE_ORDER -> abstractState = new SaveOrderState();
                default -> throw new InvalidParameterException("Invalid state: " + stateName);
            }
            abstractState.setState(state);
        }catch (IllegalArgumentException e){
            Logger.getLogger(Configurations.getInstance().getProperty("LOGGER_NAME")).severe("Invalid state: " + stateName);
        }
        return abstractState;
    }

}
