package com.uem.model;

import java.util.List;

public class Order {

    private Calculator c1 = new Calculator();
    private String id;
    private List <Article> articles;

    public Order() {
    }

    public Order(String Id, List<Article> listaArticulos){
        this.id = Id;
        articles =  listaArticulos;
    }

    public String getId() {
        return id;
    }

    public void setId(String _id) {
        id = _id;
    }

    public List<Article> getArticulos() {
        return articles;
    }

    public void setArticulos(List<Article> articulos) {
        this.articles = articulos;
    }


    public double getGrossTotal(){

        double total = 0.0;

        for(int i = 0; i < articles.size(); i++){
            double a;
            a = c1.multiply(articles.get(i).getCant(),articles.get(i).getPrecio());
            total+= a;
        }
        return total;
    }
    
    public double getDiscountedTotal(){

        double total = 0.0;

        for(int i = 0; i < articles.size(); i++){
            double a;
            
            a = c1.discount((c1.multiply(articles.get(i).getCant(),articles.get(i).getPrecio())), articles.get(i).getDescuento());
            total+= a;
        }

        return total;
    }

    @Override 
    public String toString(){

        String texto = "LISTA DE ARTÍCULOS \n\n";

        for(int i = 0; i < articles.size(); i++){
            texto += articles.get(i).toString()+ "\n";
        }

        return texto;
    }
    
}    


    

