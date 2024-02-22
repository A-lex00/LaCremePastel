package com.ispwproject.lecremepastel.controller.CLIController;

import com.ispwproject.lecremepastel.engineeringclasses.bean.SessionBean;
import com.ispwproject.lecremepastel.engineeringclasses.singleton.Configurations;
import com.ispwproject.lecremepastel.engineeringclasses.singleton.SessionManager;

public class HomeRedirectSection implements CLSection{

    private static final int CUSTOMER = Integer.parseInt(Configurations.getInstance().getProperty("CUSTOMER"));
    private static final int DIRECTOR = Integer.parseInt(Configurations.getInstance().getProperty("DIRECTOR"));
    private static final int WORKER = Integer.parseInt(Configurations.getInstance().getProperty("WORKER"));

    @Override
    public void doAction(CLContext clContext) {
        clContext.setSection(this);
        SessionBean sessionBean = SessionManager.getInstance().getSession(clContext.getSessionID());
        int userType = sessionBean.getUserType();
        CLSection next;

        if(sessionBean != null){
            if(userType == CUSTOMER){
                next = new CustomerHomeSection();
            } else if (userType == DIRECTOR) {
                next = new DirectorHomeSection();
            } else if (userType == WORKER){
                next = new WorkerHomeSection();
            } else{
                System.out.println("Invalid Session! Redirecting to Login!");
                next = new StartSection();
            }
            next.doAction(clContext);
        }
    }
}
