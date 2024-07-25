package com.example.appkio;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;


public class siembra_registro_java extends AppCompatActivity {



    private ImageView VolverRegistro;
    //private Spinner spinnerTipoArbol;
    //private TextView TextDescripcion;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_regconsulta);



        VolverRegistro=findViewById(R.id.img_volver);
        //TextDescripcion=findViewById(R.id.TextDescripcion);
        //spinnerTipoArbol=findViewById(R.id.spinnerTipoArbol);

        VolverRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(siembra_registro_java.this, inicio_java.class);
                startActivity(intent);
                recreate();



            }
        });








    }
}