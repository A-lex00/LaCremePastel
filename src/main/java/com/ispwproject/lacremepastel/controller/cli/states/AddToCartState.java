package com.ispwproject.lacremepastel.controller.cli.states;

import com.ispwproject.lacremepastel.controller.app.ManageProductController;
import com.ispwproject.lacremepastel.controller.cli.machine.AbstractCLIStateMachine;
import com.ispwproject.lacremepastel.controller.cli.other.CLIMessages;
import com.ispwproject.lacremepastel.engineeringclasses.bean.OrderLineBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.ProductBean;
import com.ispwproject.lacremepastel.engineeringclasses.exception.InvalidParameterException;
import com.ispwproject.lacremepastel.other.ProductFilter;
import com.ispwproject.lacremepastel.other.SupportedProductCategory;
import java.util.HashMap;

public class AddToCartState extends AbstractState{

    @Override
    public boolean doAction(AbstractCLIStateMachine contextSM) {
        SupportedProductCategory category = productTypeGather(contextSM);
        ProductFilter filter = new ProductFilter(category);
        OrderLineBean orderLineBean = chooseProduct(contextSM,filter);
        if(orderLineBean.getAmount() > 0) {
            contextSM.addToCart(orderLineBean);
        }
        contextSM.rewind();
        return true;
    }

    private OrderLineBean chooseProduct(AbstractCLIStateMachine contextSM, ProductFilter filter){
        ManageProductController productController = new ManageProductController();
        HashMap<Integer,ProductBean> productList;
        productList = (HashMap<Integer, ProductBean>) productController.getProductMap(contextSM.getSessionData(),filter);

        StringBuilder sb = new StringBuilder(CLIMessages.PRODUCT_PROMPT);
        for(ProductBean productBean : productList.values()) {
            sb.append(productBean.getId()).append(") ");
            sb.append(productBean.getProductName()).append("\t");
            sb.append(productBean.getPrice()).append("€\n");
        }
        try{
            sb.append(CLIMessages.PROMPT_EXPR);
            contextSM.setMessage(sb.toString());
            contextSM.printMessage();
            int productId = Integer.parseInt(contextSM.readInput());

            contextSM.setMessage(CLIMessages.AMOUNT_PROMPT);
            contextSM.printMessage();
            int amount = Integer.parseInt(contextSM.readInput());

            return new OrderLineBean(
                    productList.get(productId),
                    amount
            );
        }catch(NumberFormatException e){
            throw new InvalidParameterException("Invalid input");
        }
    }

    private String prettifySupportedProductCategory(){
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<= SupportedProductCategory.values().length; i++){
            sb.append(i).append(") ").append(SupportedProductCategory.values()[i-1].toString()).append("\n");
        }
        return sb.toString();
    }

    private SupportedProductCategory productTypeGather(AbstractCLIStateMachine contextSM){
        contextSM.setMessage(
                CLIMessages.PRODUCT_CATEGORY_PROMPT +
                        prettifySupportedProductCategory()
        );
        contextSM.printMessage();
        try{
            String productTypeIndex = contextSM.readInput();
            return SupportedProductCategory.values()[Integer.parseInt(productTypeIndex)-1];
        }catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            throw new InvalidParameterException("Invalid product type");
        }
    }
}
