package com.ispwproject.lacremepastel.controller.cli.states;

import com.ispwproject.lacremepastel.controller.cli.machine.AbstractCLIStateMachine;
import com.ispwproject.lacremepastel.controller.cli.other.CLIMessages;
import com.ispwproject.lacremepastel.engineeringclasses.bean.OrderLineBean;

public class ShowCartState extends AbstractState{

    @Override
    public void entry(AbstractCLIStateMachine contextSM) {
        StringBuilder sb = new StringBuilder();
        if(contextSM.cartLength() > 0){
            double total = 0;
            sb.append(CLIMessages.CART);
            for(int i=1; i<=contextSM.cartLength(); i++){
                sb.append(i).append(") ");
                OrderLineBean o = contextSM.getFromCart(i-1);
                total += o.getAmount()*o.getProductBean().getPrice();
                sb.append(o).append("\n");
            }
            sb.append(CLIMessages.TOTAL).append(": ").append(total).append("€\n");
        }else{
            sb.append(CLIMessages.EMPTY_CART);
        }
        contextSM.setMessage(sb.toString());
        contextSM.printMessage();
        contextSM.transition(contextSM.getPrevState());
    }

}
