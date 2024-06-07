package com.ispwproject.lacremepastel.controller.cli.states;

import com.ispwproject.lacremepastel.controller.app.MakeOrderController;
import com.ispwproject.lacremepastel.controller.cli.machine.AbstractCLIStateMachine;
import com.ispwproject.lacremepastel.controller.cli.other.CLIMessages;
import com.ispwproject.lacremepastel.engineeringclasses.bean.OrderBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.SessionBean;

public class SaveOrderState extends AbstractState {

    @Override
    public void entry(AbstractCLIStateMachine contextSM) {
        MakeOrderController makeOrderController = new MakeOrderController();
        SessionBean sessionData = contextSM.getSessionData();
        try {
            OrderBean orderBean = new OrderBean(sessionData.getUsername(), contextSM.getCart());
            makeOrderController.createOrder(sessionData, orderBean);
            contextSM.setMessage(CLIMessages.ORDER_SAVED);
            contextSM.printMessage();
            contextSM.clearCart();
        }finally {
            contextSM.rewind();
        }
    }
}
