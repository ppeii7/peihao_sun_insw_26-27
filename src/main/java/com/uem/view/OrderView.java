package com.uem.view;

import javax.swing.*;
import com.uem.model.Order;
import java.awt.*;

public class OrderView extends JFrame {
    private JTextField searchField = new JTextField(10);
    private JButton searchButton = new JButton("Search");
    private JTextArea resultArea = new JTextArea(10, 40);
    private JLabel label = new JLabel("Order ID:");
    private String[] monedas = {"EUR (€)", "USD ($)"};
    private JComboBox<String> comboMonedas = new JComboBox<>(monedas);

    public OrderView() {
        setTitle("Order Management");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Icono de la aplicación
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/pedido.png"));
        setIconImage(imageIcon.getImage());

        add(label);
        add(searchField);
        add(searchButton);
        add(comboMonedas);

        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setPreferredSize(new Dimension(450, 200));
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

    public void displayOrder(Order order, double rate, double euroDolarChange, String moneda) {

        if (order == null) {
            resultArea.setText("Pedido no encontrado");
        } else {
            if (moneda.contains("EUR")) {
                resultArea.setText("Order: " + order.getId() +
                    "\n" + order.toString(euroDolarChange) +
                    "\nPrecios(" + moneda + "): " +
                    "\nTotal bruto sin tasa: " + String.format("%.2f", order.getGrossTotal()) +
                    "\nTotal descontado: " + String.format("%.2f", order.getDiscountedTotal()) +
                    "\nTasa aplicada: " + rate +
                    "\nTotal bruto con tasa aplicada: " + String.format("%.2f", order.getGrossTotalRate(rate)) +
                    "\nTotal con tasa: " + String.format("%.2f", order.getDiscountedTotalRate(rate)));

            } else if (moneda.contains("USD")) {
                resultArea.setText("Order: " + order.getId() +
                    "\n" + order.toString(euroDolarChange) +
                    "\nPrecios(" + moneda + "): " +
                    "\nTotal bruto sin tasa: " + String.format("%.2f", order.getGrossTotal() * euroDolarChange) +
                    "\nTotal descontado: " + String.format("%.2f", order.getDiscountedTotal() * euroDolarChange) +
                    "\nTasa aplicada: " + rate +
                    "\nTotal bruto con tasa aplicada: " + String.format("%.2f", order.getGrossTotalRate(rate) * euroDolarChange) +
                    "\nTotal con tasa: " + String.format("%.2f", order.getDiscountedTotalRate(rate) * euroDolarChange));
            }
        }
    }

    public JComboBox<String> getComboMonedas() {
        return comboMonedas;
    }
}