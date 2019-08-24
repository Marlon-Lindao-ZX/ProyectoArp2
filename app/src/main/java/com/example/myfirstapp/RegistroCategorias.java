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

import java.util.ArrayList;

public class RegistroCategorias extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_categorias);

        Listas listas = (Listas) getApplicationContext();

        ArrayList<String> temp = listas.getTipos();
        Spinner spinner = findViewById(R.id.spinnerACT);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_selectable_list_item, temp);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
        arrayAdapter.notifyDataSetChanged();
        spinner.setAdapter(arrayAdapter);

        Button btnAdd = findViewById(R.id.buttonAddRC);
        btnAdd.setOnClickListener(e->{
            EditText text = findViewById(R.id.editTextRC);
            String value = text.getText().toString();
            String valor = (String) spinner.getSelectedItem();
            if (!value.equals(""))
                if (!valor.equals("Seleccionar") && (valor != null)) {
                    for (Clasificacion c : listas.getClasificaciones()) {
                        if (c.getTipo().equals(valor) && !c.getCategorias().contains(value)) {
                            c.getCategorias().add(value);
                            //listas.getClasifications().setValue(listas.getClasificaciones());
                            finish();
                        }
                    }
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
