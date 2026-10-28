package com.uem.view;

import javax.swing.*;
import com.uem.model.Order;
import java.awt.*;

public class OrderView extends JFrame {
    private JTextField searchField = new JTextField(10);
    private JButton searchButton = new JButton("Search");
    private JTextArea resultArea = new JTextArea(10, 40);
    private JLabel label = new JLabel("Order ID:");

    public OrderView() {
        setTitle("Order Management");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        //add new JLabel("Order ID:");
        //add to view the search field
        add(label);
        add(searchField);
        // add to view the search button
        add(searchButton);
        // add to view the result area inside a JScrollPane
        JScrollPane scrollPane = new JScrollPane(resultArea);
        add(scrollPane);
        pack();
        setVisible(true);
    }

    public String getSearchId() {
        return searchField.getText();
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public void displayOrder(Order order, double rate) {

        if(order == null){
            resultArea.setText("Pedido no encontrado");
        }else{

            resultArea.setText("Order: "+order.getId()+
                               "\n"+order.toString()+
                               "\nPrecios: "+
                               "\nTotal bruto sin tasa: "+ String.format("%.2f",order.getGrossTotal())+
                               "$\nTotal descontado: "+ String.format("%.2f",order.getDiscountedTotal())+
                               "$\nTasa aplicada: "+rate+
                               "\nTotal bruto con tasa aplicada: "+ String.format("%.2f",order.getGrossTotalRate(rate))+
                               "$\nTotal con tasa: "+ String.format("%.2f",order.getDiscountedTotalRate(rate)));
        }
    }
}