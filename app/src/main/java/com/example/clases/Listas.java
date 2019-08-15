package com.example.clases;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Listas {

    private static LinkedList<Donation> donaciones;
    private static LinkedList<DonationInfo> infos;
    private static HashSet<Ubicacion> ubicaciones;
    private static ArrayList<String> categorias;

    private Listas(){}

    public static void crearListas(){
        donaciones = new LinkedList<>();
        infos = new LinkedList<>();
        ubicaciones = new HashSet<>();
        categorias = new ArrayList<>();
    }

    public static LinkedList<Donation> getDonaciones() {
        return donaciones;
    }

    public static void setDonaciones(LinkedList<Donation> donaciones) {
        Listas.donaciones = donaciones;
    }

    public static LinkedList<DonationInfo> getInfos() {
        return infos;
    }

    public static void setInfos(LinkedList<DonationInfo> infos) {
        Listas.infos = infos;
    }

    public static HashSet<Ubicacion> getUbicaciones() {
        return ubicaciones;
    }

    public static void setUbicaciones(HashSet<Ubicacion> ubicaciones) {
        Listas.ubicaciones = ubicaciones;
    }

    public static ArrayList<String> getCategorias() {
        return categorias;
    }

    public static void setCategorias(ArrayList<String> categorias) {
        Listas.categorias = categorias;
    }
}
