package com.ispwproject.lecremepastel.controller.CLIController;

import com.ispwproject.lecremepastel.other.CLIStrings;

import java.util.Scanner;

public class DirectorHomeSection implements CLSection{
    @Override
    public void doAction(CLContext clContext) {
        clContext.setSection(this);
        Scanner scanner = new Scanner(System.in);
        CLSection next = null;
        int choose;

        System.out.println(CLIStrings.HOME_SECTION_DIRECTOR);
        do{
            System.out.print(CLIStrings.PROMPT);
            try{
                choose = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println(CLIStrings.INVALID_INT);
                choose = -1;
            }
            switch(choose){
                case 1:
                    //Show Customers
                    System.out.println(CLIStrings.FEATURE_NOT_IMPLEMENTED);
                    break;
                case 2:
                    //TODO: Manage Orders
                    System.out.println(CLIStrings.FEATURE_NOT_IMPLEMENTED);
                    break;
                case 3:
                    //Manage Products
                    System.out.println(CLIStrings.FEATURE_NOT_IMPLEMENTED);
                    break;
                case 4:
                    //Administrate Workers
                    System.out.println(CLIStrings.FEATURE_NOT_IMPLEMENTED);
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
