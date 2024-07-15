package com.example.appkio;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {

    private EditText user;
    private EditText password;
    private Button logear;
    private TextView registrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_login);

        user=findViewById(R.id.editTUsuario);
        password=findViewById(R.id.editTPassword);
        logear=findViewById(R.id.buttonEntrar);
        registrarse=findViewById(R.id.textRegistrarse);


        registrarse.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                    Intent next = new Intent(login.this, pantalla_registrarselogin_java.class);
                    startActivity(next);
            }
        });

        logear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (user.getText().toString().equals("")) {
                    Toast.makeText(login.this, "es necesario tus credenciales para continuar", Toast.LENGTH_SHORT).show();
                }else if (password.getText().toString().equals("")) {
                    Toast.makeText(login.this, "Ingresa alguna contraseña", Toast.LENGTH_SHORT).show();
                }else if (password.getText().toString().length()<6) {
                    Toast.makeText(login.this, "La contrasela debe ser mayor a 6 caracteres", Toast.LENGTH_SHORT).show();
                }else {
                    Intent clik = new Intent(login.this, inicio_java.class);
                    startActivity(clik);

                }
            }
        });



    }
}