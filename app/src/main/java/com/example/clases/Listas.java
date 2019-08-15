package com.example.clases;

import org.jetbrains.annotations.Contract;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Listas {

    private static LinkedList<Donation> donaciones;
    private static LinkedList<DonationInfo> infos;
    private static HashSet<Ubicacion> ubicaciones;
    private static ArrayList<String> categorias;
    private static ArrayList<String> tipos;

    private Listas(){}

    public static void crearListas(){
        donaciones = new LinkedList<>();
        infos = new LinkedList<>();
        ubicaciones = new HashSet<>();
        categorias = new ArrayList<>();
        tipos = new ArrayList<>();
    }

    @org.jetbrains.annotations.Contract(pure = true)
    public static LinkedList<Donation> getDonaciones() {
        return donaciones;
    }

    public static void setDonaciones(LinkedList<Donation> donaciones) {
        Listas.donaciones = donaciones;
    }

    @Contract(pure = true)
    public static LinkedList<DonationInfo> getInfos() {
        return infos;
    }

    public static void setInfos(LinkedList<DonationInfo> infos) {
        Listas.infos = infos;
    }

    @Contract(pure = true)
    public static HashSet<Ubicacion> getUbicaciones() {
        return ubicaciones;
    }

    public static void setUbicaciones(HashSet<Ubicacion> ubicaciones) {
        Listas.ubicaciones = ubicaciones;
    }

    @Contract(pure = true)
    public static ArrayList<String> getCategorias() {
        return categorias;
    }

    public static void setCategorias(ArrayList<String> categorias) {
        Listas.categorias = categorias;
    }

    @Contract(pure = true)
    public static ArrayList<String> getTipos() {
        return tipos;
    }

    public static void setTipos(ArrayList<String> tipos) {
        Listas.tipos = tipos;
    }
}
