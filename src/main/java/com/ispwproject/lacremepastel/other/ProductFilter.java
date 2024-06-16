package com.ispwproject.lacremepastel.other;

public class ProductFilter {
    SupportedProductCategory category;
    String name;

    public ProductFilter(SupportedProductCategory category){
        this(category,"");
    }

    public ProductFilter(String name){
        this(null,name);
    }

    public ProductFilter(SupportedProductCategory category, String name) {
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
