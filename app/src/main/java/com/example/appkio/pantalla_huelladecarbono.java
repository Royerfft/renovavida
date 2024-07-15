package com.example.appkio;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class pantalla_huelladecarbono extends AppCompatActivity {
    private Spinner spinnerHuella;
    private TextView textestado;

    private Button buttonHuella;
    private Button buttonHuellaTran;
    private SeekBar seekBarTransp;
    private TextView textSeebarTransp;
    private SeekBar seekBarCasa;
    private TextView textSeebarCasa;
    private SeekBar seekBarCarne;
    private TextView textSeebarCarne;
    private SeekBar seekBarEnergia;
    private TextView textSeebarEnergia;
    private SeekBar seekBarGas;
    private TextView textSeebarGas;
    private Button buttonHuellaGas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_huelladecarbono);

        textestado=findViewById(R.id.textEstado);
        spinnerHuella=findViewById(R.id.SpinnerHuella);

        textSeebarTransp=findViewById(R.id.textSeebarTransp);
        seekBarTransp=findViewById(R.id.seekBarTransp);

        seekBarCasa=findViewById(R.id.seekBarCasa);
        textSeebarCasa=findViewById(R.id.textSeebarCasa);

        buttonHuella=findViewById(R.id.buttonHuella);
        buttonHuellaTran=findViewById(R.id.buttonHuellaTran);

        seekBarCarne=findViewById(R.id.seekBarCarne);
        textSeebarCarne=findViewById(R.id.textSeebarCarne);

        seekBarEnergia=findViewById(R.id.seekBarEnergia);
        textSeebarEnergia=findViewById(R.id.textSeebarEnergia);

        seekBarGas=findViewById(R.id.seekBarGas);
        textSeebarGas=findViewById(R.id.textSeebarGas);
        buttonHuellaGas=findViewById(R.id.buttonHuellaGas);


        buttonHuellaGas.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               Intent ok = new Intent(pantalla_huelladecarbono.this, Resultado_Huella.class);
               startActivity(ok);

           }
       });

        seekBarGas.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                textSeebarGas.setVisibility(View.VISIBLE);
                textSeebarGas.setText(progress+"/50");
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarEnergia.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                textSeebarEnergia.setVisibility(View.VISIBLE);
                textSeebarEnergia.setText(progress+"/1000");
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        seekBarCarne.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                textSeebarCarne.setVisibility(View.VISIBLE);
                textSeebarCarne.setText(progress+"/3000");
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        seekBarCasa.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                textSeebarCasa.setVisibility(View.VISIBLE);
                textSeebarCasa.setText(progress+"/7");
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarTransp.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                textSeebarTransp.setVisibility(View.VISIBLE);
                textSeebarTransp.setText(progress+"/7");
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.spinner_Transporte,android.R.layout.simple_spinner_item);
        spinnerHuella.setAdapter(adapter);
        spinnerHuella.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                textestado.setText("A Elegido: "+parent.getItemAtPosition(position).toString());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });




    }


}