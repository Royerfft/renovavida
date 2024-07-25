package com.example.appkio;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;


public class siembra_registro_java extends AppCompatActivity {



    private ImageView VolverRegistro;
    private Spinner spinnerTipoArbol;
    private TextView TextDescripcion;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantallaregistro_siembrayterreno);



        VolverRegistro=findViewById(R.id.img_volver);
        TextDescripcion=findViewById(R.id.TextDescripcion);
        spinnerTipoArbol=findViewById(R.id.spinnerTipoArbol);

        VolverRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent siguiente= new Intent(siembra_registro_java.this, inicio_java.class);
                startActivity(siguiente);


            }
        });








    }
}