package com.gestorclientes.dm2.activityeintends.Ejer1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.gestorclientes.dm2.activityeintends.MainActivity;
import com.gestorclientes.dm2.activityeintends.R;

public class Ejercicio1 extends AppCompatActivity {

    private Button b_menu,b_aceptar;
    private EditText nombre,apellidos;
    private TextView resValidacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);
        iniciaComponentes();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ejercicio1, menu);
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

        b_menu = (Button) findViewById(R.id.ejer1_b_volverMenu);
        b_aceptar = (Button) findViewById(R.id.ejer1_b_acepta);
        nombre = (EditText) findViewById(R.id.ejer1_int_nombre);
        apellidos = (EditText) findViewById(R.id.ejer1_int_apellido);
        resValidacion = (TextView) findViewById(R.id.resp_aceptas);

        accionBotones();

    }

    public void accionBotones() {

        b_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                volverMenu();
            }
        });
        b_aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validarDatos();
            }
        });
    }

    public void validarDatos() {

        Intent i = new Intent(this, Ejercicio1_validar.class);
        i.putExtra("nombre",nombre.getText().toString());
        i.putExtra("apellidos", apellidos.getText().toString());
        startActivityForResult(i, 1111);
    }

    public void volverMenu(){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==1111 && resultCode==RESULT_OK){

            String resultado = data.getExtras().getString("resultado");
            resValidacion.setText(resultado);
        }
    }

}
