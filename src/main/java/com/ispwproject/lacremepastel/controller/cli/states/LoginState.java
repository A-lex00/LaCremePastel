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
            contextSM.setMessage(CLIMessages.loginFailed);
        }else{
            contextSM.setMessage(CLIMessages.loginSuccess);
            contextSM.setSessionData(sessionData);
        }
        contextSM.printMessage();
        contextSM.setMessage("");
        return true;
    }

    private LoginBean loginGather(AbstractCLIStateMachine contextSM){
        contextSM.setMessage(
                CLIMessages.authPrompt +
                        CLIMessages.promptExpr
        );
        contextSM.printMessage();
        String authString = contextSM.readInput();

        contextSM.setMessage(
                CLIMessages.passwordPrompt+
                        CLIMessages.promptExpr
        );
        contextSM.printMessage();
        String password = contextSM.readInput();
        return new LoginBean(authString, password);
    }
}
