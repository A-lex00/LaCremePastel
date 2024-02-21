package com.ispwproject.lecremepastel.engineeringclasses.bean;

import com.ispwproject.lecremepastel.model.Product;
import com.ispwproject.lecremepastel.model.SimpleOrder;

import java.util.ArrayList;

public class SimpleOrderBean {
    private final ArrayList<SimpleOrder> orderList;

    public SimpleOrderBean(){
        orderList = new ArrayList<>();
    }
    Boolean completed=false;
    public void sortOrder(ArrayList<Product> orderList){
        ArrayList<Product> salatoProductionList = null;
        ArrayList<Product>dolceProductionList=null;
        for(Product product : orderList){
                switch (product.getCategory()){
                    case "Salato":
                        salatoProductionList.add(product);
                        break;
                    case "Dolce":
                        dolceProductionList.add(product);
                        break;
                    // Altre tipologie di prodotto
                    default:
                        // Gestione per tipologia di prodotto non definita
                        System.out.println("Tipologia di prodotto non gestita");
                        break;
                }
        }
    }


    public void addOrder(SimpleOrder so){
        orderList.add(so);
    }

    public SimpleOrder getOrder(int index){
        return orderList.get(index);
    }

    public SimpleOrder delOrder(int id){
        for(int i=0;i<orderList.size();i++){
            SimpleOrder so = orderList.get(i);
            if(so.getId() == id){
                return orderList.remove(i);
            }
        }
        return null;
    }

    public int size(){
        return orderList.size();
    }
}

