package com.csgm.validadordomingo;

import static com.csgm.validadordomingo.R.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);


        if (savedInstanceState == null) {
            // Cargar el Fragmento 1 por defecto
            getSupportFragmentManager().beginTransaction()
                    .add(id.fragmentContainer, new FragmentOne())
                    .commit();
        }
    }
}