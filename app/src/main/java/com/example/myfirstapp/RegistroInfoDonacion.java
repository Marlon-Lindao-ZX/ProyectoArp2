package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RegistroInfoDonacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_info_donacion);
    }

    public void goBack(View view){
        Intent intent = new Intent(this, RegistroInformacion.class);
        startActivity(intent);
    }
}