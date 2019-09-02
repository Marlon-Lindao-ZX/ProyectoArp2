package com.example.clases;

import java.io.Serializable;
import java.util.Objects;

public class Ubicacion implements Serializable {

    private String codigo;
    private String tipo;
    private String descripcion;
    private static int contador;

    public Ubicacion(){contador++;}

    public Ubicacion(String codigo, String tipo, String descripcion) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public Ubicacion(String tipo, String descripcion) {
        this.codigo = tipo.charAt(0) + "-" + contador;
        contador++;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return codigo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ubicacion ubicacion = (Ubicacion) o;
        return Objects.equals(codigo, ubicacion.codigo) &&
                Objects.equals(tipo, ubicacion.tipo) &&
                Objects.equals(descripcion, ubicacion.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, tipo, descripcion);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
