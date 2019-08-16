package com.example.clases;

import android.app.Application;
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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;


public class Listas extends Application {

    private LinkedList<Donation> donaciones;
    private LinkedList<DonationInfo> infos;
    private HashSet<Ubicacion> ubicaciones;
    private LinkedList<Clasificacion> clasificaciones;
    private ArrayList<String> categorias;
    private ArrayList<String> tipos;
    private ArrayList<String> locations;
    private boolean señalador;

    public Listas(){}

    public void crearListas(){
        donaciones = new LinkedList<>();
        infos = new LinkedList<>();
        ubicaciones = new HashSet<>();
        categorias = new ArrayList<>();
        tipos = new ArrayList<>();
        clasificaciones = new LinkedList<>();
        locations = new ArrayList<>();

        tipos.add("Seleccionar");
        categorias.add("Seleccionar");
        locations.add("Seleccionar");
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void cargarListas(){
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

    public void guardarListas(){
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

    public LinkedList<Donation> getDonaciones() {
        return donaciones;
    }

    public void setDonaciones(LinkedList<Donation> donaciones) {
        this.donaciones = donaciones;
    }

    public LinkedList<DonationInfo> getInfos() {
        return infos;
    }

    public void setInfos(LinkedList<DonationInfo> infos) {
        this.infos = infos;
    }

    public HashSet<Ubicacion> getUbicaciones() {
        return ubicaciones;
    }

    public void setUbicaciones(HashSet<Ubicacion> ubicaciones) {
        this.ubicaciones = ubicaciones;
    }

    public LinkedList<Clasificacion> getClasificaciones() {
        return clasificaciones;
    }

    public void setClasificaciones(LinkedList<Clasificacion> clasificaciones) {
        this.clasificaciones = clasificaciones;
    }

    public ArrayList<String> getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList<String> categorias) {
        this.categorias = categorias;
    }

    public ArrayList<String> getTipos() {
        return tipos;
    }

    public void setTipos(ArrayList<String> tipos) {
        this.tipos = tipos;
    }

    public ArrayList<String> getLocations() {
        return locations;
    }

    public void setLocations(ArrayList<String> locations) {
        this.locations = locations;
    }
}
