package com.example.clases;

import android.widget.ImageView;

import java.io.Serializable;

public class DonationInfo implements Serializable {

    private ImageView img;
    private String name;
    private String descripcion;
    private String tipo;
    private String categoria;

    public DonationInfo(ImageView img, String name, String descripcion, String tipo, String categoria) {
        this.img = img;
        this.name = name;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.categoria = categoria;
    }

    public ImageView getImg() {
        return img;
    }

    public void setImg(ImageView img) {
        this.img = img;
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
}
