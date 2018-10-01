package com.example.juanes24.peluchitoscom;

public class Peluches {
    private int id,precio, cantidad;
    private String nombre;

    public Peluches(int id, int precio, int cantidad, String nombre) {
        this.id = id;
        this.precio = precio;
        this.cantidad = cantidad;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
