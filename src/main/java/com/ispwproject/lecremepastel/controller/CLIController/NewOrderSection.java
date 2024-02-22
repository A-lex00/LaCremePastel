package com.ispwproject.lecremepastel.controller.CLIController;

import com.ispwproject.lecremepastel.controller.appcontroller.MakeOrderController;
import com.ispwproject.lecremepastel.controller.appcontroller.ManageProductController;
import com.ispwproject.lecremepastel.engineeringclasses.bean.OrderLineBean;
import com.ispwproject.lecremepastel.engineeringclasses.bean.ProductBean;
import com.ispwproject.lecremepastel.engineeringclasses.bean.SimpleOrderBean;
import com.ispwproject.lecremepastel.engineeringclasses.exception.InvalidSessionException;
import com.ispwproject.lecremepastel.other.CLIStrings;

import java.util.List;
import java.util.Scanner;

public class NewOrderSection implements CLSection{
    @Override
    public void doAction(CLContext clContext) {
        clContext.setSection(this);
        CLSection next = null;
        Scanner scanner = new Scanner(System.in);
        SimpleOrderBean simpleOrderBean = new SimpleOrderBean();
        ManageProductController manageProductController = new ManageProductController();
        List<ProductBean> productList = manageProductController.loadProducts();
        int choose;
        boolean showProductList = true;
        boolean exit = false;

        do{
            if(showProductList){
                this.showProducts(productList);
                showProductList = false;
            }

            this.showRecap(simpleOrderBean);

            System.out.println(CLIStrings.NEW_ORDER_MENU);
            System.out.print(CLIStrings.PROMPT);
            try {
                choose = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                choose = -1;
            }
            switch(choose){
                case 1:
                    //add product
                    this.addProduct(scanner, simpleOrderBean, productList);
                    break;
                case 2:
                    //rem Product
                    this.remProduct(scanner, simpleOrderBean);
                    break;
                case 3:
                    //Print product list
                    showProductList = true;
                    break;
                case 4:
                    //Confirm order
                    MakeOrderController makeOrderController = new MakeOrderController();
                    try {
                        makeOrderController.createSimpleOrder(clContext.getSessionID(), simpleOrderBean);
                    }catch(InvalidSessionException e){
                        System.out.println(CLIStrings.INVALID_SESSION);
                        next = new LogoutSection();
                        next.doAction(clContext);
                    }catch(Exception e){
                        System.out.println(CLIStrings.MAKE_ORDER_ERROR);
                    }
                    exit = true;
                    break;
                case 5:
                    //Cancel order
                    System.out.println(CLIStrings.ORDER_CANCELED);
                    exit = true;
                    break;
                default:
                    System.out.println(CLIStrings.INVALID_INT);
            }
        }while(!exit);
    }

    private void showProducts(List<ProductBean> productList){
        //Loading all products
        System.out.println(CLIStrings.PRODUCT_LIST);
        for(ProductBean p : productList){
            System.out.println(p);
        }
        System.out.println();
    }

    private void showRecap(SimpleOrderBean simpleOrderBean){
        //Recap order
        double tot = 0;
        if(!simpleOrderBean.getProductList().isEmpty()){
            System.out.println(CLIStrings.RECAP_ORDER);
            for(OrderLineBean o : simpleOrderBean.getProductList()){
                System.out.println(o);
                tot += o.getTotalPrice();
            }
        }
        System.out.println("Totale Ordine: "+tot+" €\n");
    }

    private int selectProduct(Scanner scanner, List<ProductBean> productList){
        int index;
        ProductBean dummy;
        System.out.println(CLIStrings.CHOOSE_PRODUCT);
        try{
            int pid = Integer.parseInt(scanner.nextLine());
            dummy = new ProductBean();
            dummy.setId(pid);
            index = productList.indexOf(dummy);
        }catch(NumberFormatException e){
            index = -1;
        }
        return index;
    }

    private int getAmount(Scanner scanner){
        int amount;
        do{
            System.out.println(CLIStrings.PRODUCT_AMOUNT);
            try {
                amount = Integer.parseInt(scanner.nextLine());
            }catch(NumberFormatException e){
                amount = -1;
            }
        }while(amount < 0);
        return amount;
    }

    private void addProduct(Scanner scanner, SimpleOrderBean simpleOrderBean, List<ProductBean> productList){
        int index = this.selectProduct(scanner, productList);
        if(index == -1){
            System.out.println(CLIStrings.INVALID_PRODUCT_ID);
            return;
        }
        int amount = this.getAmount(scanner);
        if(amount > 0){
            ProductBean selected = productList.get(index);

            OrderLineBean orderLineBean = new OrderLineBean();
            orderLineBean.setProductId(selected.getId());
            orderLineBean.setAmount(amount);
            orderLineBean.setUnitPrice(selected.getPrice());

            simpleOrderBean.addOrderLine(orderLineBean);

            System.out.println(CLIStrings.PRODUCT_AMOUNT);

        }
    }

    private void remProduct(Scanner scanner, SimpleOrderBean simpleOrderBean){
        System.out.println(CLIStrings.CHOOSE_PRODUCT);
        int pid;
        try{
            pid = Integer.parseInt(scanner.nextLine());
        }catch(NumberFormatException e){
            pid = -1;
        }
        if(pid != -1){
            for(OrderLineBean o : simpleOrderBean.getProductList()){
                if(o.getProductId() == pid){
                    simpleOrderBean.getProductList().remove(o);
                    return;
                }
            }
        }else{
            System.out.println(CLIStrings.INVALID_PRODUCT_ID);
        }
    }
}
