package com.ispwproject.lacremepastel.controller.cli;

import com.ispwproject.lacremepastel.controller.cli.utils.CLIStateMachine;
import com.ispwproject.lacremepastel.controller.cli.utils.StateMachine;

public class CLIControllerFirstPage {

    private StateMachine contextSM;

    public CLIControllerFirstPage() {
        this.contextSM = new CLIStateMachine();
    }

}
