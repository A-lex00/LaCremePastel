package com.ispwproject.lacremepastel.controller.cli.states;

import com.ispwproject.lacremepastel.controller.app.LoginController;
import com.ispwproject.lacremepastel.controller.cli.machine.AbstractCLIStateMachine;
import com.ispwproject.lacremepastel.controller.cli.other.CLIMessages;
import com.ispwproject.lacremepastel.engineeringclasses.bean.LoginBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.SessionBean;

public class LoginState extends AbstractState {
    public LoginState() {
        super();
    }

    @Override
    public boolean doAction(AbstractCLIStateMachine contextSM) {
        LoginBean loginBean = loginGather(contextSM);
        LoginController loginController = new LoginController();
        SessionBean sessionData = loginController.login(loginBean);
        if(sessionData == null){
            contextSM.setMessage(CLIMessages.LOGIN_FAILED);
            contextSM.printMessage();
            contextSM.transition(contextSM.getPrevState());
        }else{
            contextSM.setMessage(CLIMessages.LOGIN_SUCCESS+"\n");
            contextSM.setSessionData(sessionData);
            contextSM.printMessage();
            contextSM.transition(this.getState(1));
        }

        return true;
    }

    private LoginBean loginGather(AbstractCLIStateMachine contextSM){
        contextSM.setMessage(
                CLIMessages.AUTH_PROMPT +
                        CLIMessages.PROMPT_EXPR
        );
        contextSM.printMessage();
        String authString = contextSM.readInput();

        contextSM.setMessage(
                CLIMessages.PASSWORD_PROMPT +
                        CLIMessages.PROMPT_EXPR
        );
        contextSM.printMessage();
        String password = contextSM.readInput();
        return new LoginBean(authString, password);
    }
}
