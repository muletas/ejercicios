package com.gestorclientes.dm2.activityeintends.Ejer2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.gestorclientes.dm2.activityeintends.Ejer1.Ejercicio1;
import com.gestorclientes.dm2.activityeintends.R;

public class Ejercicio2_validar extends AppCompatActivity {

    private Button b_volver;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2_validar);
        iniciarComponentes();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ejercicio2_validar, menu);
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

        b_volver = (Button) findViewById(R.id.ejer2validar_b_volver);
        resultado = (TextView) findViewById(R.id.ejer2validar_resultado);

        Bundle extras = getIntent().getExtras();
        String usuario = extras.getString("usuario");
        String password = extras.getString("password");

        if(comprobarUsuario(usuario,password)){
            resultado.setText("Usuario y password CORRECTOS");
        }else{
            resultado.setText("Usuario y password INCORRECTOS");
        }

        b_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volver();
            }
        });

    }

    public void volver(){

        Intent i = new Intent();
        setResult(RESULT_OK,i);
        finish();
    }

    public boolean comprobarUsuario(String usuario, String pass){

        if(usuario.equalsIgnoreCase("yo") && pass.equalsIgnoreCase("1234")){
            return true;
        }else{
            return false;
        }
    }
}
