package com.gestorclientes.dm2.activityeintends.Ejer3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.gestorclientes.dm2.activityeintends.R;

public class Ejercicio3_validar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        calcularYvolver();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ejercicio3_validar, menu);
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

    public void calcularYvolver(){

        Bundle extras = getIntent().getExtras();
        int  op1 = extras.getInt("op1");
        int  op2 = extras.getInt("op2");
        int  suma = extras.getInt("suma");

        String valido = "N";

        if((op1+op2)==suma){
            valido = "S";
        }


        Intent i = new Intent();
        i.putExtra("valido",valido);
        setResult(RESULT_OK, i);
        finish();

    }
}
