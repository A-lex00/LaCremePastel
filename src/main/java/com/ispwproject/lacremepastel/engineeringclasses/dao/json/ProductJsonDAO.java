package com.ispwproject.lacremepastel.engineeringclasses.dao.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ispwproject.lacremepastel.engineeringclasses.dao.ProductDAO;
import com.ispwproject.lacremepastel.engineeringclasses.singleton.Configurations;
import com.ispwproject.lacremepastel.model.Product;
import com.ispwproject.lacremepastel.other.SupportedProductCategory;
import org.apache.commons.io.FilenameUtils;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ProductJsonDAO implements ProductDAO {

    private final String pathUserdata = Configurations.getInstance().getProperty("PATH_USERDATA");
    private final String filenamePattern = Configurations.getInstance().getProperty("FILENAME_PATTERN");
    private final String lastIdPath = Configurations.getInstance().getProperty("LAST_ID_PATH");
    private final File lastId = Paths.get(pathUserdata, lastIdPath).toFile();

    @Override
    public List<Product> getAllProducts() {
        File directory = new File(pathUserdata);
        File[] files = directory.listFiles();
        if(files == null){
            Logger.getLogger(Configurations.LOGGER_NAME).severe("Can't open JsonData Directory!");
            return new ArrayList<>();
        }
        ArrayList<Product> products = new ArrayList<>();
        for(File file : files) {
            if(!FilenameUtils.getExtension(file.getName()).equalsIgnoreCase("json")){
                continue;
            }
            Product product = this.loadFromFile(file);
            if(product != null) {
                products.add(product);
            }
        }
        return products;
    }

    @Override
    public List<Product> getProductsByCategory(SupportedProductCategory category) {
        List<Product> products = this.getAllProducts();
        ArrayList<Product> found = new ArrayList<>();
        for(Product p : products){
            if(p.getCategory() == category){
                found.add(p);
            }
        }
        return found;
    }

    @Override
    public List<Product> getProductsByName(String name) {
        List<Product> products = this.getAllProducts();
        ArrayList<Product> found = new ArrayList<>();
        for(Product p : products){
            if(p.getName().toLowerCase().contains(name.toLowerCase())){
                found.add(p);
            }
        }
        return found;
    }

    @Override
    public boolean addProduct(Product product) {
        int id = this.getNextProductId();
        product.setId(id);
        if(this.writeToFile(product)){
            this.saveCurrentProductId(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean modifyProduct(Product product) {
        String filename = String.format(filenamePattern,product.getId());
        if(FilenameUtils.directoryContains(pathUserdata,filename)){
            return this.writeToFile(product);
        }
        return false;
    }

    @Override
    public boolean deleteProduct(int productId) {
        String filename = String.format(filenamePattern,productId);
        if(FilenameUtils.directoryContains(pathUserdata,filename)){
            Product p = loadFromFile(new File(filename));
            assert p != null;
            p.setVisible(false);
            return this.writeToFile(p);
        }
        return false;
    }

    @Override
    public Product getProductById(int productId) {
        String filename = String.format(filenamePattern,productId);
        return loadFromFile(Paths.get(pathUserdata,filename).toFile());
    }

    private Product loadFromFile(File file){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try{
            String jsonStr = Files.readString(file.toPath());
            gson.fromJson(jsonStr, Product.class);
        }catch (IOException e){
            Logger.getLogger(Configurations.LOGGER_NAME).severe(e.getMessage());
        }
        return null;
    }

    private boolean writeToFile(Product product){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try{
            Paths.get(pathUserdata,String.format(filenamePattern,product.getId()));
            String jsonStr = gson.toJson(product, Product.class);
            Files.writeString(
                    Paths.get(pathUserdata,String.format(filenamePattern,product.getId())),
                    jsonStr
            );
            return true;
        }catch (IOException e){
            Logger.getLogger(Configurations.LOGGER_NAME).severe(e.getMessage());
            return false;
        }
    }


    private int getNextProductId(){
        synchronized (lastId){
            try(BufferedReader reader = new BufferedReader(new FileReader(lastId))){
                return Integer.parseInt(reader.readLine())+1;
            }catch (IOException e){
                Logger.getLogger(Configurations.LOGGER_NAME).severe(e.getMessage());
            }
            return -1;
        }
    }

    private void saveCurrentProductId(int id){
        synchronized (lastId) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(lastId))) {
                writer.write(String.valueOf(id));
                writer.flush();
            } catch (IOException e) {
                Logger.getLogger(Configurations.LOGGER_NAME).severe(e.getMessage());
            }
        }
    }
}
