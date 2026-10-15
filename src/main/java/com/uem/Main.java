package com.uem;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.uem.model.Article;
import com.uem.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        System.setProperty("org.slf4j.simple.SimpleLogger.defaultLogLevel", "DEBUG");

        
        Gson gson = new Gson();
        List<Order> orders = new ArrayList<>();
        Type tipoLista = new TypeToken<List<Order>>(){}.getType();
        FileReader fr;


        try{
            fr = new FileReader("src/main/resources/orders.json");
            orders = gson.fromJson(fr,tipoLista);
            fr.close();

        }catch(IOException e){
                System.out.println("Error al procesar el fichero: " + e.getMessage());
        }
        
    
        for(int i = 0; i < orders.size() ;i++){
            log.debug("Loaded order: {}",orders.get(i).getId());
        }




    }
    
}