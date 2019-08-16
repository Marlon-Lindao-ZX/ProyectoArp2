package com.example.clases;

import java.io.Serializable;
import java.util.ArrayList;

public class Clasificacion implements Serializable {

    private String tipo;
    private ArrayList<String> categorias;

    public Clasificacion(String tipo) {
        this.tipo = tipo;
        categorias = new ArrayList<>();
    }

    public Clasificacion(String tipo, ArrayList<String> categorias) {
        this.tipo = tipo;
        this.categorias = categorias;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<String> getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList<String> categorias) {
        this.categorias = categorias;
    }
}
