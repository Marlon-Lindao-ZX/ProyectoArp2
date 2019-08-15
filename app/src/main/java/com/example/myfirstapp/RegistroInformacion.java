package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RegistroInformacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void toInfo(View view){
        Intent intent = new Intent(this, RegistroInfoDonacion.class);
        startActivity(intent);
    }

    public void toUbicacion(View view){
        Intent intent = new Intent(this, RegistroUbicacion.class);
        startActivity(intent);
    }

    public void toCategory(View view){
        Intent intent = new Intent(this, RegistroCategorias.class);
        startActivity(intent);
    }

    public void goBack(View view){
        Intent intent = new Intent(this, PantallaPrincipal.class);
        startActivity(intent);
    }

}
