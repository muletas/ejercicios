package com.gestorclientes.dm2.activityeintends.Ejer1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.gestorclientes.dm2.activityeintends.R;

import org.w3c.dom.Text;

public class Ejercicio1_validar extends AppCompatActivity {

    private Button b_aceptar,b_rechazar;
    private TextView tituloNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1_validar);
        iniciaComponentes();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ejercicio1_validar, menu);
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

    public void iniciaComponentes() {

        tituloNombre = (TextView) findViewById(R.id.ejer1_tit_validar);
        b_aceptar = (Button) findViewById(R.id.ejer1_b_aceptar);
        b_rechazar = (Button) findViewById(R.id.ejer1_b_rechazar);

        Bundle extras = getIntent().getExtras();
        String nombre = extras.getString("nombre");
        String apellidos = extras.getString("apellidos");

        tituloNombre.setText(nombre+" "+apellidos);

        accionBotones();

    }

    public void accionBotones(){

        b_aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volverEjer1("SI");
            }
        });
        b_rechazar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volverEjer1("NO");
            }
        });

    }

    public void volverEjer1(String result){

        Intent i = new Intent();
        i.putExtra("resultado",result);
        setResult(RESULT_OK,i);
        finish();

    }


}
