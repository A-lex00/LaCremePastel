package com.ispwproject.lacremepastel.controller.cli.states;

import com.ispwproject.lacremepastel.controller.app.LoginController;
import com.ispwproject.lacremepastel.controller.cli.machine.AbstractCLIStateMachine;
import com.ispwproject.lacremepastel.controller.cli.other.CLIMessages;
import com.ispwproject.lacremepastel.engineeringclasses.bean.RegisterBean;
import com.ispwproject.lacremepastel.engineeringclasses.exception.InvalidParameterException;
import com.ispwproject.lacremepastel.engineeringclasses.exception.UserAlreadyExistentException;
import com.ispwproject.lacremepastel.other.SupportedRoleTypes;
import com.ispwproject.lacremepastel.other.SupportedUserTypes;

public class RegisterState extends AbstractState{
    public RegisterState() {
        super();
    }

    @Override
    public boolean doAction(AbstractCLIStateMachine contextSM) {
        SupportedUserTypes userType = userTypeGather(contextSM);
        RegisterBean registerBean = registerGather(contextSM, userType);
        LoginController loginController = new LoginController();
        try {
            loginController.register(registerBean);
        }catch (UserAlreadyExistentException e){
            contextSM.setMessage("User " + registerBean.getUsername() + " already exists");
        }
        contextSM.transition(contextSM.getPrevState());
        return true;
    }

    private String prettifyUserTypes(){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i< SupportedUserTypes.values().length;i++){
            sb.append(i).append(") ").append(SupportedUserTypes.values()[i].toString()).append("\n");
        }
        return sb.toString();
    }

    private String prettifyRoleTypes(){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i< SupportedRoleTypes.values().length;i++){
            sb.append(i).append(") ").append(SupportedRoleTypes.values()[i].toString()).append("\n");
        }
        return sb.toString();
    }

    private SupportedUserTypes userTypeGather(AbstractCLIStateMachine contextSM){
        StringBuilder sb = new StringBuilder(CLIMessages.CHOOSE_EXPR);
        sb.append(prettifyUserTypes()).append(CLIMessages.PROMPT_EXPR);
        try{
            contextSM.setMessage(sb.toString());
            contextSM.printMessage();
            String userTypeIndex = contextSM.readInput();
            return SupportedUserTypes.values()[Integer.parseInt(userTypeIndex)];
        }catch (ArrayIndexOutOfBoundsException e){
            throw new InvalidParameterException("Invalid user type");
        }
    }

    private SupportedRoleTypes roleGather(AbstractCLIStateMachine contextSM){
        StringBuilder sb = new StringBuilder(CLIMessages.CHOOSE_EXPR);
        sb.append(prettifyRoleTypes()).append(CLIMessages.PROMPT_EXPR);
        System.out.println("Messaggio Ruolo Creato");
        try{
            contextSM.setMessage(sb.toString());
            contextSM.printMessage();
            String userRoleIndex = contextSM.readInput();
            return SupportedRoleTypes.values()[Integer.parseInt(userRoleIndex)];
        }catch (ArrayIndexOutOfBoundsException e){
            throw new InvalidParameterException("Invalid user type");
        }
    }

    private RegisterBean registerGather(AbstractCLIStateMachine contextSM, SupportedUserTypes userType) {
        contextSM.setMessage(
                CLIMessages.FIRSTNAME_PROMPT+
                        CLIMessages.PROMPT_EXPR
        );
        contextSM.printMessage();
        String firstName = contextSM.readInput();

        contextSM.setMessage(
                CLIMessages.LASTNAME_PROMPT+
                        CLIMessages.PROMPT_EXPR
        );
        contextSM.printMessage();
        String lastName = contextSM.readInput();

        contextSM.setMessage(
                CLIMessages.EMAIL_PROMPT+
                        CLIMessages.PROMPT_EXPR
        );
        contextSM.printMessage();
        String email = contextSM.readInput();

        contextSM.setMessage(
                CLIMessages.USERNAME_PROMPT+
                        CLIMessages.PROMPT_EXPR
        );
        contextSM.printMessage();
        String username = contextSM.readInput();

        contextSM.setMessage(
                CLIMessages.PASSWORD_PROMPT+
                        CLIMessages.PROMPT_EXPR
        );
        contextSM.printMessage();
        String password = contextSM.readInput();

        contextSM.setMessage(
                CLIMessages.CF_PIVA_PROMPT+
                        CLIMessages.PROMPT_EXPR
        );
        contextSM.printMessage();
        String cfPiva = contextSM.readInput();
        RegisterBean registerBean;
        try {
            registerBean = new RegisterBean(
                    username,
                    cfPiva,
                    password,
                    firstName,
                    lastName,
                    email,
                    userType.toString()
            );
        }catch (InvalidParameterException e){
            contextSM.transition(contextSM.getPrevState());
            throw e;
        }
        switch (userType){
            case WORKER:
                //Get Role
                SupportedRoleTypes roleType = roleGather(contextSM);
                registerBean.setRole(roleType.toString());
                break;
            case CUSTOMER:
                //Get Billing Address
                contextSM.setMessage(
                        CLIMessages.BILLING_ADDRESS_PROMPT+
                                CLIMessages.PROMPT_EXPR
                );
                contextSM.printMessage();
                String billingAddress = contextSM.readInput();
                registerBean.setBillingAddress(billingAddress);
                break;
            case DIRECTOR:
                break;
            default:
                throw new InvalidParameterException("Invalid User Type");
        }
        return registerBean;
    }
}
