package com.example.juanes24.peluchitoscom;

public interface Comunicador {
    void enviarDatos(int id, String nombre, int cantidad, int precio);

    void enviarDatosBuscar(String s);

    void eliminarDatosBuscar(String s);
}
