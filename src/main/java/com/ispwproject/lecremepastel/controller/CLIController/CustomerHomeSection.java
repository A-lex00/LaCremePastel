package com.ispwproject.lecremepastel.controller.CLIController;

import com.ispwproject.lecremepastel.other.CLIStrings;

import java.util.Scanner;

public class CustomerHomeSection implements CLSection{
    @Override
    public void doAction(CLContext clContext) {
        clContext.setSection(this);
        Scanner scanner = new Scanner(System.in);
        CLSection next = null;
        int choose;

        System.out.println(CLIStrings.HOME_SECTION_CUSTOMER);
        do{
            clContext.setSection(this);
            System.out.print(CLIStrings.PROMPT);
            try{
                choose = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println(CLIStrings.INVALID_INT);
                choose = -1;
            }
            switch(choose){
                case 1:
                    //New Order
                    next = new NewOrderSection();
                    break;
                case 2:
                    //Manage Orders
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
                    System.out.println(CLIStrings.INVALID_INT);
            }
        }while(next == null);
        next.doAction(clContext);
    }
}
