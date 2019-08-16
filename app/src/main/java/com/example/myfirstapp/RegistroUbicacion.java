package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.clases.Clasificacion;
import com.example.clases.Listas;
import com.example.clases.Ubicacion;

import java.util.ArrayList;

public class RegistroUbicacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_ubicacion);

        Listas listas = (Listas) getApplicationContext();
        ArrayList<String> temp = listas.getTipos();
        Spinner spinner = findViewById(R.id.spinnerRUT);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, temp);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        Button btnAdd = findViewById(R.id.buttonRU);
        btnAdd.setOnClickListener(e->{
            EditText text = findViewById(R.id.editTextRU);
            String value = text.getText().toString();
            String valor = (String) spinner.getSelectedItem();
            if (!value.equals(""))
                if (!valor.equals("Seleccionar") && (valor != null)) {
                    listas.getUbicaciones().add(new Ubicacion(valor,value));
                    finish();
                }
        });
    }

    public void goBack(View view){
        finish();
    }
}
