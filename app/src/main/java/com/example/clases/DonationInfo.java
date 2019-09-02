package com.example.clases;

import android.content.Context;
import android.graphics.Color;
import android.widget.Button;

import com.example.myfirstapp.R;

import java.io.Serializable;

public class DonationInfo implements Serializable {

    private Button btn;
    private String name;
    private String descripcion;
    private String tipo;
    private String categoria;
    private String cod;
    private static int contador;

    public DonationInfo(){contador++;}

    public DonationInfo(Context context , String name, String descripcion, String tipo, String categoria) {
        cod = "DI-"+contador;
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

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }
}
