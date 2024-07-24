package com.example.appkio;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class pantalla_registrarselogin_java extends AppCompatActivity {
    private EditText editEmail, editPassword;
    private UserManager usermanager;
    private Button btninicio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_registrarse_login);

        btninicio=findViewById(R.id.buttonEntrarInicio);
        editEmail=findViewById(R.id.editCorreo);
        editPassword=findViewById(R.id.editPassword);
        usermanager=new UserManager(this);


        btninicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editEmail.getText().toString();
                String password = editPassword.getText().toString();

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(pantalla_registrarselogin_java.this,"Ingrese un correo electronico",Toast.LENGTH_SHORT).show();
                }else if(!isValidEmail(email)){
                    Toast.makeText(pantalla_registrarselogin_java.this,"Ingrese un correo Valido",Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(password)) {
                    Toast.makeText(pantalla_registrarselogin_java.this,"Ingrese una contraseña",Toast.LENGTH_SHORT).show();
                }else{
                    RegistrarUsuario(email,password);
                }

                Intent inicio = new Intent(pantalla_registrarselogin_java.this,login.class);
                startActivity(inicio);
            }
        });


    }
    private boolean isValidEmail(CharSequence target){
        return(!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());

    }
    private void RegistrarUsuario(String email, String password){
        usermanager.registerUser(email,password);
        Toast.makeText(pantalla_registrarselogin_java.this,"REGISTRO EXITOSO",Toast.LENGTH_SHORT).show();
        finish();


    }
}