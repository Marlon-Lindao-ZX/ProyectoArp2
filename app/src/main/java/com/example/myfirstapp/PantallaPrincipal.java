package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.clases.Listas;

public class PantallaPrincipal extends AppCompatActivity {

    @Override
    protected void onStart(){
        super.onStart();
        Listas.crearListas();
        Listas.cargarListas();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        Listas.guardarListas();
        finish();

    }

}
