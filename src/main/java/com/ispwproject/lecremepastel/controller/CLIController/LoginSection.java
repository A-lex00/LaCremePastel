package com.ispwproject.lecremepastel.controller.CLIController;

import com.ispwproject.lecremepastel.controller.appcontroller.LoginController;
import com.ispwproject.lecremepastel.engineeringclasses.bean.LoginBean;
import com.ispwproject.lecremepastel.engineeringclasses.exception.IncorrectParametersException;
import com.ispwproject.lecremepastel.engineeringclasses.singleton.Configurations;
import com.ispwproject.lecremepastel.other.CLIStrings;
import java.util.Scanner;

public class LoginSection implements CLSection{

    private static final String MARIADB = "MARIADB";
    private static final String JSON = "JSON";

    @Override
    public void doAction(CLContext clContext) {
        clContext.setSection(this);
        Scanner scanner = new Scanner(System.in);
        CLSection next = null;
        LoginBean loginBean;
        String persistence = Configurations.getInstance().getProperty("PERSISTENCE_TYPE");

        do {
            if (persistence.equals(MARIADB)) {
                System.out.print(CLIStrings.LOGIN_SQL_AUTH);
            } else if (persistence.equals(JSON)) {
                System.out.println(CLIStrings.LOGIN_JSON_AUTH);
            } else {
                System.err.println("LoginSection: Invalid persistence configuration value");
                System.exit(1);
            }
            String authString = scanner.nextLine();
            System.out.print(CLIStrings.LOGIN_PASSWD);
            String passwd = scanner.nextLine();

            //Processing Login
            try {
                loginBean = new LoginBean(authString, passwd);
                LoginController loginController = new LoginController();
                String sessionID = loginController.login(loginBean);
                if(sessionID != null){
                    System.out.println(CLIStrings.LOGIN_SUCCESSFUL);
                    clContext.setSessionID(sessionID);
                    next = new HomeRedirectSection();
                }else{
                    System.out.println(CLIStrings.LOGIN_FAILED);
                    next = new StartSection();
                }
            } catch (IncorrectParametersException e) {
                System.out.println(CLIStrings.EMPTY_CREDENTIALS);
            }
        }while(next == null);
        next.doAction(clContext);
    }
}
