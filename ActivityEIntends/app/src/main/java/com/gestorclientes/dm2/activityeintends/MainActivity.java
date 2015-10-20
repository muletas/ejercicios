package com.gestorclientes.dm2.activityeintends;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.gestorclientes.dm2.activityeintends.Ejer1.Ejercicio1;
import com.gestorclientes.dm2.activityeintends.Ejer2.Ejercicio2;
import com.gestorclientes.dm2.activityeintends.Ejer3.Ejercicio3;
import com.gestorclientes.dm2.activityeintends.Ejer4.Ejercicio4;
import com.gestorclientes.dm2.activityeintends.Ejer5.Ejercicio5;

public class MainActivity extends AppCompatActivity {

    private Button e_ejer1, e_ejer2, e_ejer3, e_ejer4, e_ejer5, e_salir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciaComponentes();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

        e_ejer1 = (Button) findViewById(R.id.b_ejer1);
        e_ejer2 = (Button) findViewById(R.id.b_ejer2);
        e_ejer3 = (Button) findViewById(R.id.b_ejer3);
        e_ejer4 = (Button) findViewById(R.id.b_ejer4);
        e_ejer5 = (Button) findViewById(R.id.b_ejer5);
        e_salir = (Button) findViewById(R.id.b_salir);

        accionBotones();

    }

    public void accionBotones() {

        e_ejer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ejecutarEjercicio(1);
            }
        });
        e_ejer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ejecutarEjercicio(2);
            }
        });
        e_ejer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ejecutarEjercicio(3);
            }
        });
        e_ejer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ejecutarEjercicio(4);
            }
        });
        e_ejer5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ejecutarEjercicio(5);
            }
        });
        e_salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });

    }

    public void ejecutarEjercicio(int num) {

        Intent intent = null;

        switch (num) {
            case 1:
                intent = new Intent(this, Ejercicio1.class);
                break;
            case 2:
                intent = new Intent(this, Ejercicio2.class);
                break;
            case 3:
                intent = new Intent(this, Ejercicio3.class);
                break;
            case 4:
                intent = new Intent(this, Ejercicio4.class);
                break;
            case 5:
                intent = new Intent(this, Ejercicio5.class);
                break;
        }

        startActivity(intent);
    }

}
