package com.ispwproject.lacremepastel.engineeringclasses.bean;

import com.ispwproject.lacremepastel.other.SupportedProductCategory;

public class ProductFilterBean {

    SupportedProductCategory category;

    public ProductFilterBean(SupportedProductCategory category) {
        this.category = category;
    }

    public SupportedProductCategory getCategory() {
        return category;
    }

    public void setCategory(SupportedProductCategory category) {
        this.category = category;
    }
}
