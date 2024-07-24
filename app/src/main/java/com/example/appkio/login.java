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
    private EditText contraseña;
    private Button logear;
    private TextView registrarse;
    private UserManager userManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_login);

        user=findViewById(R.id.editTUsuario);
        contraseña=findViewById(R.id.editTPassword);
        logear=findViewById(R.id.buttonEntrar);
        registrarse=findViewById(R.id.textRegistrarse);
        userManager = new UserManager(this);


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

                String email = user.getText().toString();
                String password = contraseña.getText().toString();


                if (userManager.loginUser(email,password)) {
                    Intent clik = new Intent(login.this, inicio_java.class);
                    startActivity(clik);
                    finish();
                }else {
                    Toast.makeText(login.this,"email o password invalido",Toast.LENGTH_SHORT).show();


                }
            }
        });



    }
}