package com.ispwproject.lecremepastel.controller.CLIController;

import com.ispwproject.lecremepastel.other.CLIMessages;

import java.util.Scanner;

public class WorkerHomeSection implements CLSection{
    @Override
    public void doAction(CLContext clContext) {
        clContext.setSection(this);
        Scanner scanner = new Scanner(System.in);
        CLSection next = null;
        int choose;

        System.out.println(CLIMessages.HOME_SECTION_WORKER);
        do{
            System.out.print(CLIMessages.PROMPT);
            try{
                choose = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println(CLIMessages.INVALID_INT);
                choose = -1;
            }
            switch(choose){
                case 1:
                    //TODO: Show Production
                    break;
                case 0:
                    //Logout
                    next = new LogoutSection();
                    break;
                default:
                    System.out.println(CLIMessages.INVALID_INT);
            }
        }while(next == null);
        next.doAction(clContext);
    }
}
