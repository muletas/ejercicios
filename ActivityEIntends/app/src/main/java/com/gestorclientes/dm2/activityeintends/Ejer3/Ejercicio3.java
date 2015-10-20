package com.gestorclientes.dm2.activityeintends.Ejer3;

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

import org.w3c.dom.Text;

public class Ejercicio3 extends AppCompatActivity {

    private TextView op1,op2,resultado,mensaje;
    private EditText suma;
    private int correctas,incorrectas;
    private Button b_calcular, b_volverMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio3);
        iniciarComponentes();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ejercicio3, menu);
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

        op1 = (TextView) findViewById(R.id.ejer3_op1);
        op2 = (TextView) findViewById(R.id.ejer3_op2);
        suma = (EditText) findViewById(R.id.ejer3_int_resultado);
        b_calcular = (Button) findViewById(R.id.ejer3_b_calcular);
        b_volverMenu = (Button) findViewById(R.id.ejer3_b_volverMenu);
        resultado = (TextView) findViewById(R.id.ejer3_resultado);
        mensaje = (TextView) findViewById(R.id.ejer3_mensaje);

        correctas = 0;
        incorrectas = 0;

        generarNumeros();
        actualizaTextos();

        accionBotones();

    }

    public void accionBotones(){

        b_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularResultado();
            }
        });

        b_volverMenu.setOnClickListener(new View.OnClickListener() {
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

    public void calcularResultado(){

        int res = Integer.parseInt(suma.getText().toString());

        Intent i = new Intent(this, Ejercicio3_validar.class);
        i.putExtra("suma", res);
        i.putExtra("op1", Integer.parseInt(op1.getText().toString()));
        i.putExtra("op2", Integer.parseInt(op2.getText().toString()));

        startActivityForResult(i, 3333);
    }

    public void generarNumeros(){

        op1.setText(( (int) (Math.random()*100))+"");
        op2.setText(( (int) (Math.random()*100))+"");

    }
    public void actualizaTextos(){

        suma.setText("");
        resultado.setText("Preguntas correctas: "+ correctas+" | Incorrectas: "+incorrectas);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==3333 && resultCode==RESULT_OK){

            String valido = data.getExtras().getString("valido");
            if(valido.equalsIgnoreCase("S")){
                correctas++;
                mensaje.setText("¡HAS ACERTADO!");
            }else{
                incorrectas++;
                mensaje.setText("¡HAS FALLADO!");
            }
            generarNumeros();
            actualizaTextos();
        }
    }

}
