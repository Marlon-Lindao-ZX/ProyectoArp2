package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.clases.Clasificacion;
import com.example.clases.Listas;

public class RegistroTipoDonacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_tipo_donacion);

        Button btnAgregar = (Button) findViewById(R.id.buttonAgregar);
        btnAgregar.setOnClickListener(e->{
            EditText edit = (EditText) findViewById(R.id.editTextTipoDonacion);
            String value = edit.getText().toString();
            Listas.getClasificaciones().add(new Clasificacion(value));
            Listas.getTipos().add(value);
            finish();
        });
    }


}
