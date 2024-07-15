package com.example.appkio;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class pantalla_registrarselogin_java extends AppCompatActivity {

    private Button btninicio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_registrarse_login);

        btninicio=findViewById(R.id.buttonEntrarInicio);

        btninicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inicio = new Intent(pantalla_registrarselogin_java.this,inicio_java.class);
                startActivity(inicio);
            }
        });



    }
}