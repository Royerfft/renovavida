package com.example.appkio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.HashMap;

public class registro_java extends AppCompatActivity implements View.OnClickListener {

    private DrawerLayout drawerLayout;
    private ImageView menu;
    private LinearLayout inicio, ajuste, compartir, informacion, salir;
    private Button BotonFecha, BotonHora,RegistrarBoton,BotonTerreno,BotonCrearArboles;
    private EditText EditFecha, EditHora, Fecha, Hora, ingresaNombre, editCantArea;
    private int dia,mes,año,hora,minutos;
    private Spinner spinner1;
    private TextView  mostrarElementos;
    private HashMap<String,String> Registro;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_registro);

        drawerLayout=findViewById(R.id.drawercontenedor);
        menu =findViewById(R.id.img_menu);
        inicio=findViewById(R.id.home);
        ajuste=findViewById(R.id.ajuste);
        compartir=findViewById(R.id.compartir);
        informacion=findViewById(R.id.informacion);
        salir=findViewById(R.id.salir);

        ingresaNombre=findViewById(R.id.IngresaNombre);
        editCantArea=findViewById(R.id.editCantArea);

        mostrarElementos=findViewById(R.id.MostrarTodo);

        BotonFecha=findViewById(R.id.buttonFecha);
        BotonHora=findViewById(R.id.botonHora);
        EditFecha=findViewById(R.id.editTextFecha);
        EditHora=findViewById(R.id.editTextHora);

        spinner1=findViewById(R.id.spinner);
        RegistrarBoton=findViewById(R.id.buttonEntrar);
        Registro = new HashMap<>();



        BotonFecha.setOnClickListener(this);
        BotonHora.setOnClickListener(this);

        Fecha=findViewById(R.id.editTextFecha);
        Hora=findViewById(R.id.editTextHora);

        BotonTerreno=findViewById(R.id.BotonTerreno);
        BotonCrearArboles=findViewById(R.id.buttonAgregarArboles);



        BotonTerreno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(registro_java.this, siembra_registro_java.class);
                startActivity(intent);

            }
        });
        BotonCrearArboles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(registro_java.this, siembra_registro_java.class);
                startActivity(intent);

            }
        });



        menu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openDrawer(drawerLayout);
            }
        });
        inicio.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                redirectActivity(registro_java.this, inicio_java.class);
            }

        });
        ajuste.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                recreate();
            }

        });
        compartir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                redirectActivity(registro_java.this, estadisticas_java.class);
            }

        });
        informacion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                redirectActivity(registro_java.this, consejos_java.class);
            }

        });
        salir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                redirectActivity(registro_java.this, login.class);            }

        });

        ArrayAdapter<CharSequence> adapter =ArrayAdapter.createFromResource(this, R.array.spinner_cuidad, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        //boton para registrar la seleccion

        /*RegistrarBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String seleccion = spinner1.getSelectedItem().toString();
                registrarSeleccion(seleccion);


            }

        });
        */
         RegistrarBoton.setOnClickListener(view -> GuardarPlantacion());



    }
    private void GuardarPlantacion(){
        String nombrePlantacion = ingresaNombre.getText().toString();
        String AreaPlantacion=editCantArea.getText().toString();
        String seleccion = spinner1.getSelectedItem().toString();
        String fecha = EditFecha.getText().toString();
        String hora = EditHora.getText().toString();
        // el if es para validar que los campos no queden vacios

        if (nombrePlantacion.isEmpty() || AreaPlantacion.isEmpty() || seleccion.isEmpty()){
            Toast.makeText(this,"complete los campos",Toast.LENGTH_SHORT).show();
            return;
        }
        // linea solo para guardar plntacion.. lo que se va hacer es buscar datos en sharepreferent
        SharedPreferences preferences=getSharedPreferences("CrearPlantacion",MODE_PRIVATE);

        //habilitar el editor para modificar las preferent
        SharedPreferences.Editor editor = preferences.edit();
        // que lo que se ingrese se posiciones y se incremente es decir se vaya validando y genrendo otra plantacion
        int index = preferences.getInt("index",0);
        editor.putString("nombre de la siembra o plantacion"+index,nombrePlantacion);
        editor.putString("Area total de cultivo"+index,AreaPlantacion);
        editor.putString("seleccion departamento"+index,seleccion);
        editor.putString("fecha de plantacion"+index,fecha);
        editor.putString("hora de plantacion"+index,hora);

        //para registrar los datos tenemos que crear un contador
        editor.putInt("index",index+1);
        //aplicar los cambios
        editor.apply();
        registrarSeleccion(seleccion);
        Toast.makeText(this, "Datos guardados", Toast.LENGTH_LONG).show();
        //finish();
    }


    public static void openDrawer(DrawerLayout drawerLayout){
        drawerLayout.openDrawer(GravityCompat.START);

    }
    public static void closeDrawer(DrawerLayout drawerLayout){
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);

        }

    }
    public static void redirectActivity(Activity activity, Class secondActivity){
        Intent i = new Intent(activity, secondActivity);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(i);
        activity.finish();
    }
    @Override
    protected void onPause(){
        super.onPause();
        closeDrawer(drawerLayout);
    }

    @Override
    public void onClick(View i) {
        if(i ==BotonFecha){
            final Calendar c=Calendar.getInstance();
            dia= c.get(Calendar.DAY_OF_MONTH);
            mes= c.get(Calendar.MONTH);
            año= c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int Semanas, int Meses, int Años) {

                    EditFecha.setText(Semanas +"/"+(Meses +1)+"/"+ Años);
                }
            }
            ,dia,mes,año);
            datePickerDialog.show();


        }
        if(i ==BotonHora){
            final Calendar c=Calendar.getInstance();
            hora= c.get(Calendar.HOUR_OF_DAY);
            minutos= c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int Horas, int Minut) {
                    EditHora.setText(Horas+":"+Minut);
                }
            },hora,minutos,false);
            timePickerDialog.show();


        }

    }

    private void registrarSeleccion(String seleccion){
        Registro.put(seleccion," ");
        StringBuilder AgruparOpcion=new StringBuilder("Datos iniciales:\n");

        for(String key:Registro.keySet()){
            AgruparOpcion.append("\n").append(ingresaNombre.getText()).append("\n").append(editCantArea.getText().toString()).append("\n").append(key).append(Registro.get(key)).append("\n").append(EditFecha.getText().toString()).append("\n").append(EditHora.getText().toString());



        }
        mostrarElementos.setText(AgruparOpcion.toString());


    }

}