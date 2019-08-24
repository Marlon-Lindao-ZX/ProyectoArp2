package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.clases.Listas;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.provider.FirebaseInitProvider;

public class PantallaPrincipal extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Listas listas = (Listas) getApplicationContext();

        listas.crearListas();

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
