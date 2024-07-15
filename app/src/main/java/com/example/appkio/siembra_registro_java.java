package com.example.appkio;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class siembra_registro_java extends AppCompatActivity {


    Button BotonSiembra;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantallaregistro_siembrayterreno);


        BotonSiembra=findViewById(R.id.BotonSiembra);


        BotonSiembra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent siguiente= new Intent(siembra_registro_java.this, registro_java.class);
                startActivity(siguiente);
            }
        });


    }
}