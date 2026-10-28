package com.uem.model;
public class Article {
    
    private String nombre;
    private int cant;
    private double precio;
    private double descuento;
    private Calculator c1 = new Calculator();

    
    public Article(){

    }


    public Article(String nombre, int cant, double precio, double descuento){

        this.nombre = nombre;
        this.cant = cant;
        this.precio = precio;
        this.descuento = descuento;
    }

    public String getNombre(){
        return nombre;
    }


    public int getCant() {
        return cant;
    }


    public double getPrecio() {
        return precio;
    }


    public double getDescuento() {
        return descuento;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void setCant(int cant) {
        this.cant = cant;
    }


    public void setPrecio(double precio) {
        this.precio = precio;
    }


    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }




    public  double getGrossAmount(){
        return c1.multiply(this.cant, this.precio);
    }


    public double getDiscountedAmount(){
        double gross = this.getGrossAmount();
        return gross - c1.discount(gross, this.descuento);
    }

    @Override 
    public String toString(){

        return getNombre()+" x "+getCant()+" @ "+getPrecio()+"$ (descuento "+ getDescuento()+"%) = "+ String.format("%.2f",getDiscountedAmount())+"$";
    }
}
    






