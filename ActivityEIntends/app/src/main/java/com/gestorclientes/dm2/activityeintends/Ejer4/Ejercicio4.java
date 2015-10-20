package com.gestorclientes.dm2.activityeintends.Ejer4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.gestorclientes.dm2.activityeintends.Ejer1.Ejercicio1_validar;
import com.gestorclientes.dm2.activityeintends.R;

public class Ejercicio4 extends AppCompatActivity {

    private String[] aficiones;
    private String sexo;
    private CheckBox musica, lectura, deporte, viajar;
    private EditText nombre, apellidos;
    private TextView mensajeError;
    private Button enviar;
    private RadioButton masculino,femenino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio4);
        iniciarComponentes();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ejercicio4, menu);
        return true;
    }

    public void iniciarComponentes(){

        enviar = (Button) findViewById(R.id.ejer4_b_enviar);
        musica = (CheckBox) findViewById(R.id.ejer4_check_musica);
        lectura = (CheckBox) findViewById(R.id.ejer4_check_lectura);
        deporte = (CheckBox) findViewById(R.id.ejer4_check_deporte);
        viajar = (CheckBox) findViewById(R.id.ejer4_check_viajar);
        mensajeError = (TextView) findViewById(R.id.ejer4_textoError);
        nombre = (EditText) findViewById(R.id.ejer4_int_nombre);
        apellidos = (EditText) findViewById(R.id.ejer4_int_apellidos);
        masculino = (RadioButton) findViewById(R.id.ejer4_masculino);
        femenino = (RadioButton) findViewById(R.id.ejer4_femenino);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (comprobarCamposRellenos()) {
                    lanzarActividad2();
                }

            }
        });

    }

    public boolean comprobarCamposRellenos(){

        if(sexo == null || nombre.getText().toString().equalsIgnoreCase("") || apellidos.getText().toString().equalsIgnoreCase("")){
            mensajeError.setText("¡Rellene todos los campos!");
            return false;
        }

        return true;
    }

    public void lanzarActividad2(){

        aficiones = rellenaAficiones();

        Intent i = new Intent(this, Ejercicio4_validar.class);
        i.putExtra("nombre",nombre.getText().toString());
        i.putExtra("apellidos", apellidos.getText().toString());
        i.putExtra("sexo", sexo);
        i.putExtra("aficiones", aficiones);
        startActivity(i);

    }

    public String[] rellenaAficiones(){

        int tamanio = 0;
        if(musica.isChecked())
            tamanio++;
        if(lectura.isChecked())
            tamanio++;
        if(deporte.isChecked())
            tamanio++;
        if(viajar.isChecked())
            tamanio++;


        String[] afic = new String[tamanio];
        int num = 0;
        if(musica.isChecked()) {
            afic[num] = "musica";
            num++;
        }
        if(lectura.isChecked()) {
            afic[num] = "lectura";
            num++;
        }
        if(deporte.isChecked()) {
            afic[num] = "deporte";
            num++;
        }
        if(viajar.isChecked()){
            afic[num] = "viajar";
            num++;
        }

        return afic;
    }

    public void onRadioButtonClicked(View view) {

        if(view.getId() == R.id.ejer4_masculino){
            masculino.setChecked(true);
            femenino.setChecked(false);
            sexo = "masculino";
        }else{
            femenino.setChecked(true);
            masculino.setChecked(false);
            sexo = "femenino";
        }
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
}
