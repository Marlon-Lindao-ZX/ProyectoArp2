package com.example.clases;

import android.content.Context;
import android.widget.Button;

import java.io.Serializable;

public class DonationInfo implements Serializable {

    private Button btn;
    private String name;
    private String descripcion;
    private String tipo;
    private String categoria;
    private static int contador;

    public DonationInfo(Context context , String name, String descripcion, String tipo, String categoria) {
        this.btn = new Button(context);
        btn.setText(categoria+"-"+contador);
        contador++;
        this.name = name;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.categoria = categoria;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}
