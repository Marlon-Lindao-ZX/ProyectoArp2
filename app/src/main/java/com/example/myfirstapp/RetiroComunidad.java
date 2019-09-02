package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.Spinner;

import com.example.clases.Donation;
import com.example.clases.DonationInfo;
import com.example.clases.Listas;
import com.example.clases.Ubicacion;

import java.util.ArrayList;

public class RetiroComunidad extends AppCompatActivity {

    private Context contex;
    private Donation dif;
    private ArrayList<View> views = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retiro_comunidad);

        Listas listas = (Listas) getApplicationContext();

        contex = this;

        ScrollView scv = (ScrollView) findViewById(R.id.gdRC1);


        listas.getLocations().clear();
        listas.getLocations().add("Seleccionar");
        for(Ubicacion u: listas.getUbicaciones()){
            listas.getLocations().add(u.toString());
        }
        ArrayList<String> temp = listas.getLocations();
        Spinner spinner = findViewById(R.id.spinnerRCU);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, temp);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                scv.removeAllViews();
                String value = (String) adapterView.getSelectedItem();
                if(!value.equals("Seleccionar") && value != null){
                    for(Donation di: listas.getDonaciones()){
                        if(di.getUbicacion().getCodigo().equals(value)){
                            ImageButton tmp = new ImageButton(contex);
                            tmp.setBackgroundColor(Color.TRANSPARENT);

                            switch(di.getInfo().getTipo()){
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
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Button btnDelete = findViewById(R.id.button14);
        btnDelete.setOnClickListener(e->{
            if(dif != null){
                listas.getDonations().child(dif.getCodigo()).removeValue();
                finish();
            }
        });
    }

    public void goBack(View view){
        finish();
    }
}
