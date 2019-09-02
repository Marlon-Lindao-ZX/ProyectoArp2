package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;

import com.example.clases.Clasificacion;
import com.example.clases.Donation;
import com.example.clases.DonationInfo;
import com.example.clases.Listas;
import com.example.clases.Ubicacion;


import android.widget.Button;

import java.util.ArrayList;


public class RegistroDonaciones extends AppCompatActivity {

    private ArrayList<View> views = new ArrayList<>();
    private Context contex;
    private ArrayList<DonationInfo> dif2 = new ArrayList<>();
    private DonationInfo dif;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        contex = this;

        Listas listas = (Listas) getApplicationContext();


        ScrollView scv = (ScrollView) findViewById(R.id.gdRD);


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
                views.clear();
                String value1 = (String) parent.getSelectedItem();
                Spinner tse = findViewById(R.id.spinner_tipo);
                String value = (String) tse.getSelectedItem();
                if(!value.equals("Seleccionar") && value != null){
                    for(DonationInfo di: listas.getInfos()){
                        if(di.getTipo().equals(value)){
                            ImageButton tmp = new ImageButton(contex);
                            tmp.setBackgroundColor(Color.TRANSPARENT);

                            switch(di.getTipo()){
                                case "Alimento":
                                    tmp.setImageResource(R.drawable.comida);

                                    break;
                                case "Medicina":
                                    tmp.setImageResource(R.drawable.medicina);
                                    break;
                                case "Ropa":
                                    tmp.setImageResource(R.drawable.ropa);
                                    break;
                                default:
                                    tmp.setImageResource(R.drawable.todos);
                                    break;
                            }


                            tmp.setOnClickListener(e->{
                                dif = di;
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
            if(dif != null && !value.equals("Seleccionar")){
                Ubicacion temp2 = null;
                for(Ubicacion u: listas.getUbicaciones()){
                    if(u.getCodigo().equals(value)) {
                        temp2 = u;
                        break;
                    }
                }
                Donation d = new Donation(dif,null,temp2);
                listas.getDonations().child(d.getCodigo()).setValue(d);
                finish();
            }
        });
    }

    public void goBack(View view){
        finish();
    }

}
