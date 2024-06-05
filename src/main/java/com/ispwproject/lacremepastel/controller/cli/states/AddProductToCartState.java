package com.ispwproject.lacremepastel.controller.cli.states;

import com.ispwproject.lacremepastel.controller.app.ManageProductController;
import com.ispwproject.lacremepastel.controller.cli.machine.AbstractCLIStateMachine;
import com.ispwproject.lacremepastel.controller.cli.other.CLIMessages;
import com.ispwproject.lacremepastel.engineeringclasses.bean.ProductBean;
import com.ispwproject.lacremepastel.engineeringclasses.bean.ProductFilterBean;
import com.ispwproject.lacremepastel.engineeringclasses.exception.InvalidParameterException;
import com.ispwproject.lacremepastel.other.SupportedProductCategory;

import java.util.ArrayList;

public class AddProductToCartState extends AbstractState{

    @Override
    public boolean doAction(AbstractCLIStateMachine contextSM) {
        chooseProduct(contextSM);
        //contextSM.addProductToCart(productBean);
        return true;
    }

    //Deve tornare un OrderLineBean
    private void chooseProduct(AbstractCLIStateMachine contextSM){
        SupportedProductCategory category = productTypeGather(contextSM);
        ManageProductController productController = new ManageProductController();

        ProductFilterBean filter = new ProductFilterBean(category);
        ArrayList<ProductBean> productList;
        productList = (ArrayList<ProductBean>) productController.loadProducts(contextSM.getSessionData(),filter);

        StringBuilder sb = new StringBuilder(CLIMessages.PRODUCT_PROMPT);
        for(int i=1; i<=productList.size(); i++) {
            sb.append(i).append(") ").append(productList.get(i-1)).append("\n");
        }
        sb.append(CLIMessages.PROMPT_EXPR);
        contextSM.setMessage(sb.toString());
        contextSM.printMessage();
        String productIndex = contextSM.readInput();

        contextSM.setMessage(CLIMessages.AMOUNT_PROMPT);
        contextSM.printMessage();
        String amount = contextSM.readInput();

        try{
            //Creare qui l'orderLineBean
        }catch(ArrayIndexOutOfBoundsException | NumberFormatException e){}
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
