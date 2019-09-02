package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.clases.Clasificacion;
import com.example.clases.Donation;
import com.example.clases.DonationInfo;
import com.example.clases.Listas;
import com.example.clases.Ubicacion;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.provider.FirebaseInitProvider;

import java.util.LinkedList;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class PantallaPrincipal extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Listas listas = (Listas) getApplicationContext();

        listas.crearListas();


        DatabaseReference mDataBase1 = FirebaseDatabase.getInstance().getReference();
        DatabaseReference donations = mDataBase1.child("donaciones");
        donations.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                Donation donation = dataSnapshot.getValue(Donation.class);
                if(donation != null)
                    listas.getDonaciones().add(donation);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String prevChildKey) {}

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Donation donation = dataSnapshot.getValue(Donation.class);
                if(donation != null)
                    listas.getDonaciones().remove(donation);
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String prevChildKey) {}

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });


        DatabaseReference info = mDataBase1.child("informaciones");
        info.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                DonationInfo di =  dataSnapshot.getValue(DonationInfo.class);
                if(di != null) {
                    listas.getInfos().add(di);
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String prevChildKey) {}

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {}

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String prevChildKey) {}

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });


        DatabaseReference ubications = mDataBase1.child("ubicaciones");
        ubications.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                Ubicacion u =  dataSnapshot.getValue(Ubicacion.class);
                if(u != null){
                    listas.getUbicaciones().add(u);
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String prevChildKey) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {}

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String prevChildKey) {}

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });


        DatabaseReference clasifications = mDataBase1.child("clasificaciones");
        clasifications.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                Clasificacion c = dataSnapshot.getValue(Clasificacion.class);
                if(c != null){
                    listas.getClasificaciones().add(c);
                    listas.getTipos().add(c.getTipo());

                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String prevChildKey) {
                Clasificacion c = dataSnapshot.getValue(Clasificacion.class);
                if(c != null) {
                    listas.getClasificaciones().remove(c);
                    listas.getClasificaciones().add(c);
                }
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {}

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String prevChildKey) {}

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });


        listas.setDonations(donations);
        listas.setInfo(info);
        listas.setUbications(ubications);
        listas.setClasifications(clasifications);



    }

    public void toRegister(View view){
        Intent intent = new Intent(this, RegistroDonaciones.class);
        startActivity(intent);

    }

    public void toRetire(View view){
        Intent intent = new Intent(this, RetiroDonaciones.class);
        startActivity(intent);

    }

    public void toAdd(View view){
        Intent intent = new Intent(this, RegistroInformacion.class);
        startActivity(intent);

    }

    public void terminate(View view){
        Listas listas = (Listas) getApplicationContext();
        finish();

    }

}
