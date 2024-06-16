package com.ispwproject.lacremepastel.engineeringclasses.dao.json;

import com.google.gson.Gson;
import com.ispwproject.lacremepastel.engineeringclasses.dao.ProductDAO;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Configurations;
import com.ispwproject.lacremepastel.model.Product;
import com.ispwproject.lacremepastel.other.SupportedProductCategory;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ProductJsonDAO implements ProductDAO {
    @Override
    public List<Product> getAllProducts() {
        File directory = new File(Configurations.getInstance().getProperty("PATH_USERDATA"));
        File[] files = directory.listFiles();
        if(files == null){
            Logger.getLogger(Configurations.LOGGER_NAME).severe("Can't open JsonData Directory!");
            return new ArrayList<>();
        }
        ArrayList<Product> products = new ArrayList<>();
        for(File file : files) {
            Product product = this.loadFromFile(file);
            if(product != null) {
                products.add(product);
            }
        }
        return products;
    }

    @Override
    public List<Product> getProductsByCategory(SupportedProductCategory category) {
        return List.of();
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return List.of();
    }

    @Override
    public boolean addProduct(Product product) {
        return this.writeToFile(product);
    }

    @Override
    public boolean modifyProduct(Product product) {
        return false;
    }

    @Override
    public boolean deleteProduct(int productId, String username) {
        return false;
    }

    @Override
    public Product getProductById(int productId) {
        return null;
    }

    private Product loadFromFile(File file){
        try {
            String jsonStr = new String(Files.readAllBytes(file.toPath()));
            Gson gson = new Gson();
            return gson.fromJson(jsonStr, Product.class);
        }catch (IOException e){
            Logger.getLogger(Configurations.LOGGER_NAME).warning(e.getMessage());
            return null;
        }
    }

    private boolean writeToFile(Product product){
        Gson gson = new Gson();
        String jsonStr = gson.toJson(product, Product.class);
        String fileName = String.format("%d_%s.json",product.getId(),product.getName());
        File file = new File(fileName);
        if(file.exists()){
            return false;
        }
        try(FileWriter writer = new FileWriter(file)){
            writer.write(jsonStr);
            writer.flush();
            return true;
        } catch (IOException e) {
            Logger.getLogger(Configurations.LOGGER_NAME).warning(e.getMessage());
            return false;
        }
    }

}
