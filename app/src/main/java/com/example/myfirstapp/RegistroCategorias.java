package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.clases.Clasificacion;
import com.example.clases.Listas;

import java.util.ArrayList;

public class RegistroCategorias extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_categorias);

        ArrayList<String> temp = Listas.getTipos();
        Spinner spinner = findViewById(R.id.spinnerACT);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, temp);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                parent.setSelection(position);
            }

            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });
    }

    public void toType(View view){
        Intent intent = new Intent(this, RegistroTipoDonacion.class);
        startActivity(intent);
    }

    public void goBack(View view){
        finish();
    }
}
