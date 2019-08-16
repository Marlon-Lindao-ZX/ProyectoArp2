package com.example.clases;

import android.os.Build;

import androidx.annotation.RequiresApi;

import org.jetbrains.annotations.Contract;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Listas {

    private static LinkedList<Donation> donaciones;
    private static LinkedList<DonationInfo> infos;
    private static HashSet<Ubicacion> ubicaciones;
    private static LinkedList<Clasificacion> clasificaciones;
    private static ArrayList<String> categorias;
    private static ArrayList<String> tipos;
    private static boolean señalador;

    private Listas(){}

    public static void crearListas(){
        donaciones = new LinkedList<>();
        infos = new LinkedList<>();
        ubicaciones = new HashSet<>();
        categorias = new ArrayList<>();
        tipos = new ArrayList<>();
        clasificaciones = new LinkedList<>();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void cargarListas(){
        File file1 = new File(RutaArchivos.getRUTACLASIFICACION());
        File file2 = new File(RutaArchivos.getRUTADONACIONES());
        File file3 = new File(RutaArchivos.getRUTADONACIONESINFO());
        File file4 = new File(RutaArchivos.getRUTAUBICACION());

        if(!file1.exists()){
            try {
                file1.createNewFile();
            } catch(IOException ioe) {}
        }else{
            try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file1)) {
            }){
                clasificaciones = (LinkedList<Clasificacion>) ois.readObject();
            } catch (ClassNotFoundException e){}
            catch(FileNotFoundException e){}
            catch (IOException e){}
        }

        if(!file2.exists()){
            try {
                file2.createNewFile();
            } catch(IOException ioe) {}
        }else{
            try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file2)) {
            }){
                donaciones = (LinkedList<Donation>) ois.readObject();
            } catch (ClassNotFoundException e){}
            catch(FileNotFoundException e){}
            catch (IOException e){}
        }

        if(!file3.exists()){
            try {
                file3.createNewFile();
            } catch(IOException ioe) {}
        }else{
            try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file3)) {
            }){
                infos = (LinkedList<DonationInfo>) ois.readObject();
            } catch (ClassNotFoundException e){}
            catch(FileNotFoundException e){}
            catch (IOException e){}
        }

        if(!file4.exists()){
            try {
                file4.createNewFile();
            } catch(IOException ioe) {}
        }else{
            try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file4)) {
            }){
                ubicaciones = (HashSet<Ubicacion>) ois.readObject();
            } catch (ClassNotFoundException e){}
            catch(FileNotFoundException e){}
            catch (IOException e){}

        }


    }

    public static void guardarListas(){
        File file1 = new File(RutaArchivos.getRUTACLASIFICACION());
        File file2 = new File(RutaArchivos.getRUTADONACIONES());
        File file3 = new File(RutaArchivos.getRUTADONACIONESINFO());
        File file4 = new File(RutaArchivos.getRUTAUBICACION());

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file1)) {
        }){
            oos.writeObject(clasificaciones);
        }
        catch(FileNotFoundException e){}
        catch (IOException e){}

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file2)) {
        }){
            oos.writeObject(donaciones);
        }
        catch(FileNotFoundException e){}
        catch (IOException e){}

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file3)) {
        }){
            oos.writeObject(infos);
        }
        catch(FileNotFoundException e){}
        catch (IOException e){}

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file4)) {
        }){
            oos.writeObject(ubicaciones);
        }
        catch(FileNotFoundException e){}
        catch (IOException e){}

    }

    @Contract(pure = true)
    public static LinkedList<Clasificacion> getClasificaciones() {
        return clasificaciones;
    }

    public static void setClasificaciones(LinkedList<Clasificacion> clasificaciones) {
        Listas.clasificaciones = clasificaciones;
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
