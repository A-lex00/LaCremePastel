package com.ispwproject.lacremepastel.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Production {
    private ArrayList<Product> productionLine;
    private int quantity;
    public void setProductionLine(Product product, int quantity){
        Map<Integer,Product> productionLine= new HashMap<>();
        productionLine.put(quantity,product);
    }
}
