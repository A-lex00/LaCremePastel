package com.ispwproject.lecremepastel.controller.CLIController;

public class RegisterSection implements CLSection{
    @Override
    public void doAction(CLContext clContext) {
        clContext.setSection(this);

    }
}
