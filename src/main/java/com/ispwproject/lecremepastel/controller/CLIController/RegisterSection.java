package com.ispwproject.lecremepastel.controller.CLIController;

import com.ispwproject.lecremepastel.engineeringclasses.bean.RegisterBean;
import com.ispwproject.lecremepastel.other.CLIStrings;

import java.util.Scanner;

public class RegisterSection implements CLSection{
    @Override
    public void doAction(CLContext clContext) {
        clContext.setSection(this);
        Scanner scanner = new Scanner(System.in);
        RegisterBean registerBean;
        boolean confirmed = false;

        do{
            //Select User Type
            System.out.println(CLIStrings.CHOOSE_USER_TYPE);
            int userType = Integer.parseInt(scanner.nextLine());

            //Collecting User information

            String confirm;
//            do {
//                System.out.println(CLIStrings.CONFIRM_DATA);
//                confirm = scanner.nextLine();
//            }while();
        }while(!confirmed);

    }
}
