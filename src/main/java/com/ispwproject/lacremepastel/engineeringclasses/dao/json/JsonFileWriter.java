package com.ispwproject.lacremepastel.engineeringclasses.dao.json;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;

public class JsonFileWriter {

    //Odio fare il guastafeste, ma la stringa dovrebbe chiamarsi "user".
    //Non la cambio per farti ragionare sul concetto di polimorfismo dei nostri modelli
    public static void writeJSONToFile(Object object, String customer) throws IOException{
        Gson gson=new Gson();
        String json= gson.toJson(object);
        try(FileWriter writer=new FileWriter(customer+ "OrderJson")){
            writer.write(json);
        }
    }
}
