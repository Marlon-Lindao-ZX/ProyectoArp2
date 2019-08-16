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
import com.example.clases.DonationInfo;
import com.example.clases.Listas;

import java.util.ArrayList;

public class RegistroInfoDonacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_info_donacion);

        Listas listas = (Listas) getApplicationContext();

        ArrayList<String> categories = listas.getCategorias();
        Spinner spinner2 = findViewById(R.id.spinnerAIDTC);
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

        ArrayList<String> temp = listas.getTipos();
        Spinner spinner = findViewById(R.id.spinnerAIDT);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item, temp);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value = (String) spinner.getSelectedItem();
                System.out.println(value);
                if (value.equals("Seleccionar")) {
                    listas.getCategorias().clear();
                    listas.getCategorias().add("Seleccionar");
                } else {
                    for (Clasificacion c : listas.getClasificaciones()) {
                        if (c.getTipo().equals(value)) {
                            listas.getCategorias().clear();
                            listas.getCategorias().add("Seleccionar");
                            listas.getCategorias().addAll(c.getCategorias());
                            break;
                        }
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });

        Button btnAdd = (Button) findViewById(R.id.buttonAddID);
        btnAdd.setOnClickListener(e->{
            Spinner sp1 = (Spinner) findViewById(R.id.spinnerAIDT);
            Spinner sp2 = (Spinner) findViewById(R.id.spinnerAIDTC);

            EditText et1 = (EditText) findViewById(R.id.editTextAID1);
            EditText et2 = (EditText) findViewById(R.id.editTextAID2);

            String valor1 = (String) sp1.getSelectedItem();
            String valor2 = (String) sp2.getSelectedItem();
            String valor3 = et1.getText().toString();
            String valor4 = et2.getText().toString();

            if(!valor1.equals("Seleccionar") && !valor2.equals("Seleccionar")){
                if(!valor3.equals("") && !valor4.equals("")){
                    listas.getInfos().add(new DonationInfo(this,valor3,valor4,valor1,valor2));
                    finish();
                }
            }
        });
    }

    public void goBack(View view){
        finish();
    }
}
