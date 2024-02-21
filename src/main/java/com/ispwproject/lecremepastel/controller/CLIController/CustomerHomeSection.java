package com.ispwproject.lecremepastel.controller.CLIController;

import com.ispwproject.lecremepastel.other.CLIMessages;

import java.util.Scanner;

public class CustomerHomeSection implements CLSection{
    @Override
    public void doAction(CLContext clContext) {
        clContext.setSection(this);
        Scanner scanner = new Scanner(System.in);
        CLSection next = null;
        int choose;

        System.out.println(CLIMessages.HOME_SECTION_CUSTOMER);
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
                    //TODO: New Order
                    break;
                case 2:
                    //TODO: Manage Orders
                    break;
                case 3:
                    //New Return request
                    break;
                case 4:
                    //TODO: Show Notifies
                    break;
                case 5:
                    //Assistance
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
