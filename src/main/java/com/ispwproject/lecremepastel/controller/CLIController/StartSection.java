package com.ispwproject.lecremepastel.controller.CLIController;

import com.ispwproject.lecremepastel.engineeringclasses.singleton.SessionManager;
import com.ispwproject.lecremepastel.other.CLIStrings;

import java.util.Scanner;

public class StartSection implements CLSection{

    @Override
    public void doAction(CLContext clContext) {
        Scanner scanner = new Scanner(System.in);
        CLSection next = null;
        int choose;
        boolean printMessage = true;

        while(true){
            clContext.setSection(this);

            //Check session and redirect eventually
            String sid = clContext.getSessionID();
            if(SessionManager.getInstance().getSession(sid) != null){
                printMessage = true;
                next = new HomeRedirectSection();
                next.doAction(clContext);
                continue;
            }

            if(printMessage){
                System.out.println(CLIStrings.START_SECTION);
                printMessage = false;
            }
            System.out.print(CLIStrings.PROMPT);
            String line = scanner.nextLine();
            try {
                choose = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                choose = -1;
            }
            switch (choose) {
                case 1:
                    //Login
                    next = new LoginSection();
                    next.doAction(clContext);
                    break;
                case 2:
                    //Register
                    next = new RegisterSection();
                    next.doAction(clContext);
                    break;
                case 0:
                    return;
                default:
                    System.out.println(CLIStrings.INVALID_INT);
            }
        }
    }
}
