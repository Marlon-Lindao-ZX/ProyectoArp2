package com.example.clases;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Clasificacion implements Serializable {

    private String cod;
    private String tipo;
    private ArrayList<String> categorias;
    private static int cont = 0;

    public Clasificacion(){
        cont++;
        if(categorias == null)
            categorias = new ArrayList<>();
    }

    public Clasificacion(String tipo) {
        this.tipo = tipo;
        categorias = new ArrayList<>();
        cod = "cat"+"-"+cont;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clasificacion that = (Clasificacion) o;
        return cod.equals(that.cod) &&
                tipo.equals(that.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cod, tipo);
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

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }
}
