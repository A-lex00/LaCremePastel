package com.ispwproject.lacremepastel.engineeringclasses.bean;

import com.ispwproject.lacremepastel.other.SupportedProductCategory;

public class ProductFilterBean {

    SupportedProductCategory category;
    String name;

    public ProductFilterBean(SupportedProductCategory category){
        this(category,"");
    }

    public ProductFilterBean(String name){
        this(null,name);
    }

    public ProductFilterBean(SupportedProductCategory category, String name) {
        this.category = category;
        this.name = name;
    }

    public SupportedProductCategory getCategory() {
        return category;
    }

    public void setCategory(SupportedProductCategory category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
