package com.ispwproject.lacremepastel.controller;

import com.ispwproject.lacremepastel.controller.app.LoginController;
import com.ispwproject.lacremepastel.engineeringclasses.bean.LoginBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.SessionBean;

public class Main {

    public static void main(String[] argv){

        LoginBean loginBean = new LoginBean("paolo","");
        LoginController loginController = new LoginController();
        SessionBean sessionBean = loginController.login(loginBean);
        if(sessionBean != null){
            System.out.println("Login Riuscito");
        }else{
            System.out.println("Login Fallito");
        }

    }

}
