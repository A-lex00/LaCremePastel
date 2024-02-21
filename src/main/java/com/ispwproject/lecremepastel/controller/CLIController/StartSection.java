package com.ispwproject.lecremepastel.controller.CLIController;

import com.ispwproject.lecremepastel.other.CLIMessages;

import java.util.Scanner;

public class StartSection implements CLSection{

    @Override
    public void doAction(CLContext clContext) {
        Scanner scanner = new Scanner(System.in);
        CLSection next;
        int choose;
        boolean printMessage = true;

        while(true){
            clContext.setSection(this);
            if(printMessage){
                System.out.println(CLIMessages.START_SECTION);
                printMessage = false;
            }
            System.out.print(CLIMessages.PROMPT);
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
                    break;
                case 2:
                    //Register
                    next = new RegisterSection();
                    break;
                case 0:
                    return;
                default:
                    System.out.println(CLIMessages.INVALID_INT);
                    next = null;
            }
            if(next != null){
                printMessage = true;
                next.doAction(clContext);
            }
        }
    }
}
