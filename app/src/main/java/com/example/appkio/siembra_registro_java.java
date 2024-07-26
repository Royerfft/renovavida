package com.example.appkio;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;


public class siembra_registro_java extends AppCompatActivity {



    private ImageView VolverRegistro;
    private Spinner spinnerTipoArbol;
    private TextView TextDescripcion;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_regconsulta);



        VolverRegistro=findViewById(R.id.img_volver);
        TextDescripcion=findViewById(R.id.TextDescripcion);
        spinnerTipoArbol=findViewById(R.id.spinnerTipoArbol);

        VolverRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(siembra_registro_java.this, inicio_java.class);
                startActivity(intent);
            }
        });

        String[] descripSpinner =new String[TipodeArbol.values().length+1];
        descripSpinner[0]="Selecione Tipo de Abol";
        for (int i=0; i<TipodeArbol.values().length;i++){
            descripSpinner[i+1]=TipodeArbol.values()[i].getNombre();
        }
        ArrayAdapter<String>adapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,descripSpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerTipoArbol.setAdapter(adapter);
        spinnerTipoArbol.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                if (position==0){
                TextDescripcion.setText("seleccione el tipo de arbol");
                }else {
                    TipodeArbol Arbolseleccionado = TipodeArbol.values()[position - 1];
                    DescripcionArbol seleccionDescripcion = ObtenerDescripcionArbol(Arbolseleccionado);
                    TextDescripcion.setText(seleccionDescripcion.toString());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                TextDescripcion.setText("Seleccione el Arbol");

            }
        });
    }
    private DescripcionArbol ObtenerDescripcionArbol(TipodeArbol problReforestar){
        switch (problReforestar){
            case ENCINA:
                return new DescripcionArbol(problReforestar, ": El Arbol ENCINA se caracteriza por tener una copa ancha que proyecta una gran sombra ademas presenta un tronco fuerte y ancho con corteza lisa y de color grisaceo cuandop es joven", "10 a 12 metros de altura");
            case TAMARIZ:
                return new DescripcionArbol(problReforestar, ": Arbusto con la corteza pardusca, agrietada y las ramas erectas pero flexible de color pardo rojizas o purpureas", "Arbusto de hasta 6 metros de altura");
            case ALAMO_BLANCO:
                return new DescripcionArbol(problReforestar, ": Se trata de un arbol caducifolio de corteza blanco verdos o grisesacea y se agrieta longitudinalmente con la edad ", "Puede llegar a medir hasta 25 metros");
            case ENERBO:
                return new DescripcionArbol(problReforestar, ": Arbusto muy ramificado con tendencia a echarse a veces erecto, corteza marron, fibrosa, exfoliandose en tiras delgadas ramillas de 5 a 10 milimetros", "Arvol de 4 a 10 metros de altura");
            case PINO_RESINERO:
                return new DescripcionArbol(problReforestar, ": Arboles de tamaño medio su corteza es rojo anaranjada muy agrietada y sciculas en pares gruesas y largas de tono de verde azulado ", "Altura de 20 a 35 metros");
            default:
                return null;
        }
    }
}