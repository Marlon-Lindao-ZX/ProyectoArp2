package com.example.clases;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;
import com.google.firebase.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

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

import static androidx.constraintlayout.widget.Constraints.TAG;


public class Listas extends Application {

    private LinkedList<Donation> donaciones;
    private LinkedList<DonationInfo> infos;
    private LinkedList<Ubicacion> ubicaciones;
    private LinkedList<Clasificacion> clasificaciones;
    private ArrayList<String> categorias;
    private ArrayList<String> tipos;
    private ArrayList<String> locations;
    private boolean señalador;
    private static FirebaseApp fbp;
    private static FirebaseDatabase mDataBase1;
    private DatabaseReference mDataBase;
    private DatabaseReference donations;
    private DatabaseReference info;
    private DatabaseReference ubications;
    private DatabaseReference clasifications;
    private static Context context;

    public Listas(){



        categorias = new ArrayList<>();
        tipos = new ArrayList<>();
        locations = new ArrayList<>();
        /*
        mDataBase1 = FirebaseDatabase.getInstance();
        donations = mDataBase1.getReference("donaciones");
        ValueEventListener dontListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                try {
                    donaciones = dataSnapshot.getValue(LinkedList.class);
                } catch (ClassCastException e) {
                    e.printStackTrace();
                }
                // ...
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        };
        donations.addValueEventListener(dontListener);
        info = mDataBase1.getReference("informaciones");
        ValueEventListener infoListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                try {
                    infos =  dataSnapshot.getValue(LinkedList.class);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // ...
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        };
        info.addValueEventListener(infoListener);
        ubications = mDataBase1.getReference("ubicaciones");
        ValueEventListener ubiListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                try {
                    ubicaciones =  dataSnapshot.getValue(LinkedList.class);
                } catch (ClassCastException e) {
                    e.printStackTrace();
                }
                // ...
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        };
        ubications.addValueEventListener(ubiListener);
        clasifications = mDataBase1.getReference("clasificaciones");
        ValueEventListener claListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                try {
                    clasificaciones = dataSnapshot.getValue(LinkedList.class);
                    if(clasificaciones != null){
                        categorias.clear();
                        categorias.add("Seleccionar");
                        for(Clasificacion c: clasificaciones)
                            categorias.add(c.getTipo());
                    }

                } catch (ClassCastException e) {
                    e.printStackTrace();
                }
                // ...
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        };
        clasifications.addValueEventListener(claListener);

         */
    }

    public void crearListas(){

        if(donaciones == null && infos == null && ubicaciones == null && clasificaciones == null ){
            donaciones = new LinkedList<>();
            infos = new LinkedList<>();
            ubicaciones = new LinkedList<>();
            clasificaciones = new LinkedList<>();
            /*
            donations.setValue(donaciones);
            info.setValue(infos);
            ubications.setValue(ubicaciones);
            clasifications.setValue(clasificaciones);

             */

        }
        tipos.add("Seleccionar");
        categorias.add("Seleccionar");
        locations.add("Seleccionar");
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

    public LinkedList<Ubicacion> getUbicaciones() {
        return ubicaciones;
    }

    public void setUbicaciones(LinkedList<Ubicacion> ubicaciones) {
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

    public DatabaseReference getmDataBase() {
        return mDataBase;
    }

    public void setmDataBase(DatabaseReference mDataBase) {
        this.mDataBase = mDataBase;
    }

    public DatabaseReference getDonations() {
        return donations;
    }

    public void setDonations(DatabaseReference donations) {
        this.donations = donations;
    }

    public DatabaseReference getInfo() {
        return info;
    }

    public void setInfo(DatabaseReference info) {
        this.info = info;
    }

    public DatabaseReference getUbications() {
        return ubications;
    }

    public void setUbications(DatabaseReference ubications) {
        this.ubications = ubications;
    }

    public DatabaseReference getClasifications() {
        return clasifications;
    }

    public void setClasifications(DatabaseReference clasifications) {
        this.clasifications = clasifications;
    }

    public static FirebaseDatabase getmDataBase1() {
        return mDataBase1;
    }

    public void setmDataBase1(FirebaseDatabase mDataBase1) {
        Listas.mDataBase1 = mDataBase1;
    }

    public static FirebaseApp getFbp() {
        return fbp;
    }

    public static void setFbp(FirebaseApp fbp) {
        Listas.fbp = fbp;
    }

    public static Context getContext() {
        return context;
    }

    public static void setContext(Context context) {
        Listas.context = context;
    }
}
