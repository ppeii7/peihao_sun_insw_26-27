package com.uem;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.uem.control.OrderController;
import com.uem.model.Order;
import com.uem.view.OrderView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        log.info("Iniciando la lectura y procesamiento del archivo de pedidos...");

        Gson gson = new Gson();
        List<Order> orders = new ArrayList<>();
        Type tipoLista = new TypeToken<List<Order>>(){}.getType();

        try (InputStream is = Main.class.getResourceAsStream("/orders.json")) {
            if (is == null) {
                log.error("Fallo crítico: No se encontró el recurso '/orders.json' dentro del JAR");
            } else {
                Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8);
                orders = gson.fromJson(reader, tipoLista);
                for (int i = 0; i < orders.size(); i++) {
                    log.debug("Loaded order: {}", orders.get(i).getId());
                }
                log.info("Archivo JSON cargado correctamente. Total de pedidos: {}", orders != null ? orders.size() : 0);
            }
        } catch (IOException e) {
            log.error("Fallo crítico: No se pudo leer el archivo 'orders.json'", e);
        }

        OrderView view = new OrderView();
        OrderController control = new OrderController(view, orders);
    }
}
