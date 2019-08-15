package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RetiroDonaciones extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    public void goBack(View view){
        Intent intent = new Intent(this, PantallaPrincipal.class);
        startActivity(intent);
    }

    public void toComunity(View view){
        Intent intent = new Intent(this, RetiroComunidad.class);
        startActivity(intent);
    }

    public void toDanio(View view){
        Intent intent = new Intent(this, RetiroDanio.class);
        startActivity(intent);
    }


}
