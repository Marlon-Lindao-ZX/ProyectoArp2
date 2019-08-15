package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toRegister(View view){
        Intent intent = new Intent(this,Main4Activity.class);
        startActivity(intent);

    }

    public void toRetire(View view){
        Intent intent = new Intent(this,Main3Activity.class);
        startActivity(intent);

    }

    public void toAdd(View view){
        Intent intent = new Intent(this,Main2Activity.class);
        startActivity(intent);

    }

    public void terminate(View view){
        finish();
    }

}
