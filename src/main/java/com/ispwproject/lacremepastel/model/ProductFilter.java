package com.ispwproject.lacremepastel.model;

import com.ispwproject.lacremepastel.other.SupportedProductCategory;

public class ProductFilter {
    SupportedProductCategory category;

    public ProductFilter(SupportedProductCategory category) {
        this.category = category;
    }

    public SupportedProductCategory getCategory() {
        return category;
    }

    public void setCategory(SupportedProductCategory category) {
        this.category = category;
    }
}
