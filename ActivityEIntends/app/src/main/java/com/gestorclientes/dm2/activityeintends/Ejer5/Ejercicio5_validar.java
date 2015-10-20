package com.gestorclientes.dm2.activityeintends.Ejer5;

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

import java.util.Date;

public class Ejercicio5_validar extends AppCompatActivity {

    private Button b_jugar,b_volver;
    TextView duracionTotal,totalLuces, movInnecesarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        comprobarNivel();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ejercicio5_validar, menu);
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

    public void comprobarNivel(){

        Bundle extras = getIntent().getExtras();
        int nivel= extras.getInt("nivel");

        if(nivel == 3){
            int tiempoInit= extras.getInt("duracionTotal");
            int totalLucesCamb= extras.getInt("totalLuces");
            int innecesarios= extras.getInt("innecesarios");
            finDelJuego(tiempoInit,totalLucesCamb,innecesarios);
        }else{
            volverEjer1("enCurso");
        }

    }

    public void volverEjer1(String estado){

        Intent i = new Intent();
        i.putExtra("estado",estado);
        setResult(RESULT_OK,i);
        finish();

    }

    public void finDelJuego(int total, int totalLucesCambiadas, int innecesarios){

        setContentView(R.layout.activity_ejercicio5_validar);

        b_jugar = (Button) findViewById(R.id.ejer5_b_volverJugar);
        b_volver = (Button) findViewById(R.id.ejer5_b_volverMenu);
        duracionTotal = (TextView) findViewById(R.id.duracionTotal);
        totalLuces = (TextView) findViewById(R.id.totalLuces);
        movInnecesarios = (TextView) findViewById(R.id.movInnecesarios);


        duracionTotal.setText("Duración total: "+total+" segundos.");
        totalLuces.setText("Luces rojas cambiadas: "+totalLucesCambiadas);
        movInnecesarios.setText("Movimientos innecesarios: "+innecesarios);
        b_jugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volverEjer1("terminado");
            }
        });
        b_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volverMenu();
            }
        });


    }

    public void volverMenu(){

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);

    }

}
