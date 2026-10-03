package com.uem.model;

import java.util.List;

public class Order {

    private Calculator c1 = new Calculator();
    private String Id;
    private List <Article> articulos;

    public Order(String Id, List<Article> listaArticulos){
        this.Id = Id;
        articulos =  listaArticulos;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public List<Article> getArticulos() {
        return articulos;
    }

    public void setArticulos(List<Article> articulos) {
        this.articulos = articulos;
    }


    public double getGrossTotal(){

        double total = 0.0;

        for(int i = 0; i < articulos.size(); i++){
            double a;
            a = c1.multiply(articulos.get(i).getCant(),articulos.get(i).getPrecio());
            total+= a;
        }
        return total;
    }
    
    public double getDiscountedTotal(){

        double total = 0.0;

        for(int i = 0; i < articulos.size(); i++){
            double a;
            
            a = c1.discount((c1.multiply(articulos.get(i).getCant(),articulos.get(i).getPrecio())), articulos.get(i).getDescuento());
            total+= a;
        }

        return total;
    }

    @Override 
    public String toString(){

        String texto = "LISTA DE ARTÍCULOS \n\n";

        for(int i = 0; i < articulos.size(); i++){
            texto += articulos.get(i).toString()+ "\n";
        }

        return texto;
    }
    
}    


    

