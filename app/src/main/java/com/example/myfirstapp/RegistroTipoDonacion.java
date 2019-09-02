package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.clases.Clasificacion;
import com.example.clases.Listas;

public class RegistroTipoDonacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_tipo_donacion);

        Listas listas = (Listas) getApplicationContext();
        Button btnAgregar = (Button) findViewById(R.id.buttonAgregar);
        btnAgregar.setOnClickListener(e->{
            //Spinner spinner = findViewById(R.id.spinnerACT);
            EditText edit = (EditText) findViewById(R.id.editTextTipoDonacion);
            String value = edit.getText().toString();
            Clasificacion c = new Clasificacion(value);
            //listas.getClasificaciones().add(c);
            listas.getClasifications().child(c.getCod()).setValue(c);
            listas.getTipos().add(value);
            finish();
        });
    }


}
