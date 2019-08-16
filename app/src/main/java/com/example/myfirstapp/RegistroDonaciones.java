package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Spinner;

import com.example.clases.Clasificacion;
import com.example.clases.Donation;
import com.example.clases.DonationInfo;
import com.example.clases.Listas;
import com.example.clases.Ubicacion;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;


public class RegistroDonaciones extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Listas listas = (Listas) getApplicationContext();

        DonationInfo dif = null;

        ArrayList<String> ubicaciones = listas.getLocations();
        Spinner spinner3 = findViewById(R.id.spinnerRDU);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,ubicaciones);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);

        ArrayList<String> categories = listas.getCategorias();
        Spinner spinner2 = findViewById(R.id.spinner_cat);
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item, categories);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(arrayAdapter2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ScrollView scv = (ScrollView) findViewById(R.id.scrollViewRD);
                scv.removeAllViews();
                String value = (String) parent.getSelectedItem();

                if(!value.equals("Seleccionar") && value != null){
                    for(DonationInfo di: listas.getInfos()){
                        if(di.getCategoria().equals(value)){
                            Button tmp = di.getBtn();
                            tmp.setOnClickListener(e->{

                            });
                            scv.addView(tmp);
                        }
                    }
                }


            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });

        ArrayList<String> temp = listas.getTipos();
        Spinner spinner = findViewById(R.id.spinner_tipo);
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
                    listas.getLocations().clear();
                    listas.getLocations().add("Seleccionar");
                } else {
                    for (Clasificacion c : listas.getClasificaciones()) {
                        if (c.getTipo().equals(value)) {
                            listas.getCategorias().clear();
                            listas.getCategorias().add("Seleccionar");
                            listas.getCategorias().addAll(c.getCategorias());
                            break;
                        }
                    }
                    listas.getLocations().clear();
                    listas.getLocations().add("Seleccionar");
                    for(Ubicacion u: listas.getUbicaciones()){
                        if(u.getTipo().equals(value))
                            listas.getLocations().add(u.toString());
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });

        Button btnAdd = (Button) findViewById(R.id.buttonAddRD);
        btnAdd.setOnClickListener(e->{
            String value = (String) spinner3.getSelectedItem();
            if(dif != null || !value.equals("Seleccionar")){
                Ubicacion temp2 = null;
                for(Ubicacion u: listas.getUbicaciones()){
                    if(u.getCodigo().equals(value)) {
                        temp2 = u;
                        break;
                    }
                }
                listas.getDonaciones().add(new Donation(dif,null,temp2));
                finish();
            }
        });
    }

    public void goBack(View view){
        finish();
    }

}
