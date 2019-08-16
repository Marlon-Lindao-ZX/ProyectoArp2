package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ScrollView;
import android.widget.Spinner;

import com.example.clases.Donation;
import com.example.clases.Listas;

import java.util.ArrayList;

public class RetiroDanio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retiro_danio);

        Listas listas = (Listas) getApplicationContext();
        ArrayList<String> temp = listas.getLocations();
        Spinner spinner = findViewById(R.id.spinnerRUU);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, temp);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ScrollView scv = (ScrollView) findViewById(R.id.scrollViewRDD);
                scv.removeAllViews();
                String value = (String) adapterView.getSelectedItem();
                if(!value.equals("Seleccionar") && value != null){
                    for(Donation di: listas.getDonaciones()){
                        if(di.getInfo().getCategoria().equals(value)){
                            scv.addView(di.getInfo().getBtn());
                        }
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void goBack(View view){
        finish();
    }
}
