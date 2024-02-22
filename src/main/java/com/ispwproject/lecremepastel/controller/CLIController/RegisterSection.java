package com.ispwproject.lecremepastel.controller.CLIController;

import com.ispwproject.lecremepastel.controller.appcontroller.LoginController;
import com.ispwproject.lecremepastel.engineeringclasses.bean.RegisterBean;
import com.ispwproject.lecremepastel.engineeringclasses.exception.IncorrectParametersException;
import com.ispwproject.lecremepastel.engineeringclasses.exception.IncorrectUserSetupException;
import com.ispwproject.lecremepastel.engineeringclasses.singleton.Configurations;
import com.ispwproject.lecremepastel.other.CLIStrings;
import java.util.Scanner;

public class RegisterSection implements CLSection{

    private static final int CUSTOMER = Integer.parseInt(Configurations.getInstance().getProperty("CUSTOMER"));
    private static final int DIRECTOR = Integer.parseInt(Configurations.getInstance().getProperty("DIRECTOR"));
    private static final int WORKER = Integer.parseInt(Configurations.getInstance().getProperty("WORKER"));

    @Override
    public void doAction(CLContext clContext) {
        clContext.setSection(this);
        Scanner scanner = new Scanner(System.in);
        RegisterBean registerBean;
        boolean worker = false;
        boolean customer = false;
        boolean director = false;
        int userType = readUserType(scanner);

        //Collecting all user data
        String username = this.readUserProperty(scanner,CLIStrings.USERNAME_PROMPT);
        String email = this.readUserProperty(scanner,CLIStrings.EMAIL_PROMPT);
        String passwd = this.readUserProperty(scanner,CLIStrings.PASSWD_PROMPT);
        String firstname = this.readUserProperty(scanner,CLIStrings.FIRSTNAME_PROMPT);
        String lastname = this.readUserProperty(scanner,CLIStrings.LASTNAME_PROMPT);
        String cfPiva = this.readUserProperty(scanner,CLIStrings.CF_PIVA_PROMPT);

        String userSpecialized = null;
        if(userType == DIRECTOR){
            director = true;
        }else if(userType == WORKER){
            worker = true;
            userSpecialized = this.readUserProperty(scanner,CLIStrings.ROLE_PROMPT);
        }else if(userType == CUSTOMER){
            customer = true;
            userSpecialized = this.readUserProperty(scanner,CLIStrings.BILLING_ADDRESS_PROMPT);
        }

        try{
            //Building Registration Bean
            registerBean = new RegisterBean(
                    email,
                    username,
                    passwd,
                    worker,
                    director,
                    customer
            );
            registerBean.setFirstname(firstname);
            registerBean.setSurname(lastname);
            registerBean.setCfPiva(cfPiva);
            if(worker){
                registerBean.setRole(userSpecialized);
            }else if(customer){
                registerBean.setBillingAddress(userSpecialized);
            }

            //Processing Registration
            LoginController loginController = new LoginController();
            loginController.register(registerBean);
        }catch(IncorrectUserSetupException | IncorrectParametersException e){
            e.fillInStackTrace();
            System.out.println(CLIStrings.REGISTRATION_FAILED);
        }
        System.out.println(CLIStrings.REGISTRATION_SUCCESS);
    }

    private String readUserProperty(Scanner scanner, String msg){
        String property;
        do{
            System.out.print(msg);
            property = scanner.nextLine();
        }while(property == null || property.isBlank());
        return property;
    }

    private int readUserType(Scanner scanner){
        //Select User Type
        int choose;
        int userType = 0;
        System.out.println(CLIStrings.CHOOSE_USER_TYPE);
        do{
            System.out.print(CLIStrings.PROMPT);
            try {
                choose = Integer.parseInt(scanner.nextLine());
            }catch(NumberFormatException e){
                System.out.print(CLIStrings.INVALID_INT);
                choose = -1;
            }
            switch(choose){
                case 1:
                    userType = DIRECTOR;
                    break;
                case 2:
                    userType = WORKER;
                    break;
                case 3:
                    userType = CUSTOMER;
                    break;
                default:
                    System.out.println(CLIStrings.INVALID_INT);
            }
        }while(userType == 0);
        return userType;
    }
}
