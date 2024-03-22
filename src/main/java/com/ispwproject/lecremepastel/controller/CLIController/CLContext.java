package com.ispwproject.lecremepastel.controller.CLIController;

public class CLContext {
    private CLSection section;
    private String sessionID;

    public CLContext(){
        section = new StartSection();
        sessionID = null;
    }

    public void setSection(CLSection section){
        this.section = section;
    }

    public CLSection getSection(){
        return this.section;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public void clearSessionID(){
        this.sessionID = null;
    }

    public String getSessionID(){
        return this.sessionID;
    }
}
