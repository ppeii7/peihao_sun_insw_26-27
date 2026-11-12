package com.uem.control;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.uem.model.Order;
import com.uem.model.Searcher;
import com.uem.view.OrderView;
import com.uem.model.ExchangeRateService;


public class OrderController {

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    //Atributo de clase OrderView
    private OrderView view;
    //Lista de orders
    private List<Order> orders;
    //Atributo de clase Searcher
    private Searcher searcher;
    private Order orderEncontrada;
    private String monedaSeleccionada;
    private double euroDolarChange;

    private ExchangeRateService exchangeRateService;

    public OrderController(OrderView view, List<Order> orders) {
        //Initialize attributes
        this.view = view;
        this.orders = orders;
        this.searcher = new Searcher();
        this.exchangeRateService = new ExchangeRateService();
        this.monedaSeleccionada = "EUR (€)";
        //Adding action listener to the search button, call searchOrder on click
        view.getSearchButton().addActionListener(e -> searchOrder());

        view.getComboMonedas().addActionListener(e -> {
        this.monedaSeleccionada = (String) view.getComboMonedas().getSelectedItem();
        actualizarPantalla();

    });

        
    }

    private void searchOrder() {
        String id = view.getSearchId();
        orderEncontrada = searcher.searchOrderById(id, orders);
        euroDolarChange = exchangeRateService.obtenerCambioEuroDolar();
        System.out.print(euroDolarChange);
        actualizarPantalla();
    }

    public void actualizarPantalla(){
        if(monedaSeleccionada.contains("EUR")){
            view.displayOrder(orderEncontrada, 0.21,1.0, monedaSeleccionada);
        }else if(monedaSeleccionada.contains("USD")){
            view.displayOrder(orderEncontrada, 0.21, euroDolarChange,monedaSeleccionada);
        }
    }
}

    
