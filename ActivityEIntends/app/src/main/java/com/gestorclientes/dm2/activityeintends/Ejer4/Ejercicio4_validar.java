package com.gestorclientes.dm2.activityeintends.Ejer4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.gestorclientes.dm2.activityeintends.MainActivity;
import com.gestorclientes.dm2.activityeintends.R;

public class Ejercicio4_validar extends AppCompatActivity {

    TextView resultado;
    Button volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio4_validar);
        iniciarComponentes();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ejercicio4_validar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void iniciarComponentes(){

        volver = (Button) findViewById(R.id.ejer4_b_volverMenu);
        resultado = (TextView) findViewById(R.id.ejer4_validar_resultado);

        Bundle extras = getIntent().getExtras();
        String nombre = extras.getString("nombre");
        String apellido = extras.getString("apellidos");
        String sexo = extras.getString("sexo");
        String[] aficiones= extras.getStringArray("aficiones");

        if(sexo.equalsIgnoreCase("mujer")){
            sexo = "una mujer a la que";
        }else{
            sexo = "un hombre al que";
        }

        if(aficiones.length==0){
            resultado.setText("Hola "+nombre+" "+apellido+".\n\n Eres "+sexo+" no le gusta ninguna de las actividades propuestas. \n\n Gracias por usar nuestro programa.");
        }else{
            String actividades="";
            for(int i = 0;i<aficiones.length;i++){

                if(i!=aficiones.length-1){
                    actividades = aficiones[i]+", ";
                }else{
                    actividades = aficiones[i]+".";
                }

            }
            resultado.setText("Hola "+nombre+" "+apellido+".\n\n Eres "+sexo+" le gustan las siguientes actividades: "+actividades+"\n\n Gracias por usar nuestro programa.");
        }


        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volverMenu();
            }
        });

    }

    public void volverMenu(){

        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);

    }

}
