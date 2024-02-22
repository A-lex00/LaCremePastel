package com.ispwproject.lecremepastel.controller.CLIController;

import com.ispwproject.lecremepastel.engineeringclasses.singleton.SessionManager;
import com.ispwproject.lecremepastel.other.CLIStrings;

public class LogoutSection implements CLSection{
    @Override
    public void doAction(CLContext clContext) {
        clContext.setSection(this);

        //Logout
        SessionManager.getInstance().delSession(clContext.getSessionID());
        clContext.clearSessionID();
        System.out.println(CLIStrings.LOGOUT);

        //No next state: Call stack reset
    }
}
