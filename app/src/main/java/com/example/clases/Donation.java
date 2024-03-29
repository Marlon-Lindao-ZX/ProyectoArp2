package com.example.clases;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Donation implements Serializable {

    private DonationInfo info;
    private Date fechaExpiracion;
    private Ubicacion ubicacion;
    private String codigo;
    private static int contador;

    public Donation(){contador++;}

    public Donation(DonationInfo info, Date fechaExpiracion, Ubicacion ubicacion) {
        this.info = info;
        this.fechaExpiracion = fechaExpiracion;
        this.ubicacion = ubicacion;
        this.codigo = "D-"+contador;
        contador++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Donation donation = (Donation) o;
        return codigo.equals(donation.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    public DonationInfo getInfo() {
        return info;
    }

    public void setInfo(DonationInfo info) {
        this.info = info;
    }

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
