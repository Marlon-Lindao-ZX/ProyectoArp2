package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.clases.Clasificacion;
import com.example.clases.Listas;

import java.util.ArrayList;


public class RegistroDonaciones extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        ArrayList<String> categories = new ArrayList<>();
        Spinner spinner2 = findViewById(R.id.spinner_cat);
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, categories);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(arrayAdapter2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });

        ArrayList<String> temp = Listas.getTipos();
        Spinner spinner = findViewById(R.id.spinner_tipo);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, temp);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ArrayList<String> cat = new ArrayList<>();
                for(Clasificacion c: Listas.getClasificaciones()){
                    if(c.getTipo().equals(parent.getItemAtPosition(position))){
                        cat.addAll(c.getCategorias());
                        break;
                    }
                }
                Spinner tempSpinner = findViewById(R.id.spinner_cat);
                ArrayAdapter<String> tempAA = new ArrayAdapter<>(getParent(),android.R.layout.simple_spinner_item, cat);
                tempAA.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                tempSpinner.setAdapter(tempAA);
            }

            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });

    }

    public void goBack(View view){
        finish();
    }
}
