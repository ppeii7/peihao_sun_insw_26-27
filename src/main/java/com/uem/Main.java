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

        log.info("Iniciando la lectura y procesamiento del archivo de pedidos...");



        Gson gson = new Gson();
        List<Order> orders = new ArrayList<>();
        Type tipoLista = new TypeToken<List<Order>>(){}.getType();
        FileReader fr;


        try{
            fr = new FileReader("src/main/resources/orders.json");
            orders = gson.fromJson(fr,tipoLista);
            for(int i = 0; i < orders.size() ;i++){
            log.debug("Loaded order: {}",orders.get(i).getId());
        }
            fr.close();

            log.info("Archivo JSON cargado correctamente. Total de pedidos: {}", orders != null ? orders.size() : 0);
        } catch (IOException e) {
            log.error("Fallo crítico: No se pudo leer el archivo 'orders.json'", e);
        }
    

        
    }
    
}