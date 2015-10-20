package com.gestorclientes.dm2.activityeintends.Ejer2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.gestorclientes.dm2.activityeintends.Ejer1.Ejercicio1_validar;
import com.gestorclientes.dm2.activityeintends.MainActivity;
import com.gestorclientes.dm2.activityeintends.R;

public class Ejercicio2 extends AppCompatActivity {

    private Button b_validar,b_volver_menu;
    private EditText int_nombre,int_password;
    private TextView mensajeError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2);
        iniciaComponentes();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ejercicio2, menu);
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

        int_nombre = (EditText) findViewById(R.id.ejer2_int_usuario);
        int_password = (EditText) findViewById(R.id.ejer2_int_password);
        b_validar = (Button) findViewById(R.id.ejer2_b_validar);
        b_volver_menu = (Button) findViewById(R.id.ejer2_b_volverMenu);
        mensajeError = (TextView) findViewById(R.id.ejer2_mensajeError);

        accionBotones();

    }

    public void accionBotones() {

        b_validar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                abrirValidacion();
            }
        });
        b_volver_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                volverMenu();
            }
        });
    }

    public void abrirValidacion(){

        if(!int_nombre.getText().toString().equalsIgnoreCase("") && !int_password.getText().toString().equalsIgnoreCase("")){
            Intent i = new Intent(this, Ejercicio2_validar.class);
            i.putExtra("usuario",int_nombre.getText().toString());
            i.putExtra("password", int_password.getText().toString());
            startActivity(i);
        }else{
            mensajeError.setText("Introduce los dos campos correctamente por favor.");
        }



    }

    public void volverMenu(){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

}
