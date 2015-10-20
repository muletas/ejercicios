package com.gestorclientes.dm2.activityeintends.Ejer5;

import android.content.Intent;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.gestorclientes.dm2.activityeintends.Ejer1.Ejercicio1_validar;
import com.gestorclientes.dm2.activityeintends.R;

import java.util.Date;

public class Ejercicio5 extends AppCompatActivity {

    private TableRow col1, col2, col3;
    private int nivel, totalClicks, innecesarios;
    private TextView textoNivel,textoObjetivo;
    private Date tiempoInit;
    private Button comenzar;
    private int[] semaforos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio5);
        iniciarComponentes();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ejercicio5, menu);
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

        //guardamos los IDs de los semaforos en un array para poder jugar despues con ellos de forma automatizada.
        int[] aux = {R.id.semaforo1,R.id.semaforo2,R.id.semaforo3,R.id.semaforo4,R.id.semaforo5,R.id.semaforo6,R.id.semaforo7,R.id.semaforo8,R.id.semaforo9,R.id.semaforo10,R.id.semaforo11,R.id.semaforo12};
        semaforos = aux;

        for(int i = 0;i<semaforos.length;i++){
            ImageView elSemaforo = (ImageView)findViewById(semaforos[i]);
            elSemaforo.setImageResource(R.drawable.led_rojo);
            elSemaforo.setClickable(false);
        }



        col1= (TableRow) findViewById(R.id.columna1);
        col2= (TableRow) findViewById(R.id.columna2);
        col3= (TableRow) findViewById(R.id.columna3);

        comenzar = (Button) findViewById(R.id.boton_comenzar);

        textoNivel = (TextView) findViewById(R.id.nivel);
        textoObjetivo = (TextView) findViewById(R.id.textoObjetivo);


        //cambiarmos los textos de abajo
        textoObjetivo.setVisibility(View.VISIBLE);
        textoNivel.setVisibility(View.INVISIBLE);
        comenzar.setVisibility(View.VISIBLE);


        comenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                empiezaJuego();
            }
        });


    }

    public void empiezaJuego(){

        for(int i = 0;i<semaforos.length;i++){
            ImageView elSemaforo = (ImageView)findViewById(semaforos[i]);
            elSemaforo.setClickable(true);
        }

        //cambiarmos los textos de abajo
        textoObjetivo.setVisibility(View.INVISIBLE);
        textoNivel.setVisibility(View.VISIBLE);

        //iniciamos el nivel a 1
        nivel = 1;
        tiempoInit = new Date();
        totalClicks = 0;
        innecesarios = 0;

        //quitamos el botón de comenzar a jugar y guardamos la fecha actual para coger los tiempos de juego
        comenzar.setVisibility(View.INVISIBLE);


        actualizaJuego();

    }

    public void actualizaJuego(){

        //ponemos el nivel actual en el que nos encontramos
        textoNivel.setText("Nivel "+nivel);

        //iniciamos la función para mostrar los semaforos
        iniciarSemaforos();
    }

    public void iniciarSemaforos(){

        if(nivel == 1){
            nivel1();
        }else if(nivel == 2){
            nivel2();
        }else if(nivel == 3){
            nivel3();
        }

    }

    public void nivel1(){
        //en este nivel solo tendremos la primera fila de semáforos
        col1.setVisibility(View.VISIBLE);
        col2.setVisibility(View.INVISIBLE);
        col3.setVisibility(View.INVISIBLE);

        //generaremos de forma aleatoria la cantidad de luces encendidas;
        generarLuces(1);
    }

    public void nivel2(){
        //en este nivel solo tendremos la primera fila de semáforos
        col1.setVisibility(View.VISIBLE);
        col2.setVisibility(View.VISIBLE);
        col3.setVisibility(View.INVISIBLE);

        //generaremos de forma aleatoria la cantidad de luces encendidas;
        generarLuces(2);
    }

    public void nivel3(){
        //en este nivel solo tendremos la primera fila de semáforos
        col1.setVisibility(View.VISIBLE);
        col2.setVisibility(View.VISIBLE);
        col3.setVisibility(View.VISIBLE);

        //generaremos de forma aleatoria la cantidad de luces encendidas;
        generarLuces(3);
    }

    public void generarLuces(int numNivel){

        int numTotal = 0;

        if(numNivel == 1){//del array las posiciones: 0,1,2,3
            numTotal = 4;
        }else if(numNivel == 2){//del array las posiciones: 0,1,2,3,4,5,6,7
            numTotal = 8;
        }else if(numNivel == 3){//del array las posiciones: 0,1,2,3,4,5,6,7
            numTotal = 12;
        }

        for(int i =0;i<numTotal;i++){

            ImageView aux = (ImageView)findViewById(semaforos[i]);


            double rand = Math.random() * 1;
            if(Math.round(rand) == 1){
                aux.setImageResource(R.drawable.led_verde);
                aux.setTag(R.drawable.led_verde);
            }else{
                aux.setImageResource(R.drawable.led_rojo);
                aux.setTag(R.drawable.led_rojo);
            }
        }

    }

    public void contarSemaforos(){

        int numTotal = 0;

        if(nivel == 1){//del array las posiciones: 0,1,2,3
            numTotal = 4;
        }else if(nivel == 2){//del array las posiciones: 0,1,2,3,4,5,6,7
            numTotal = 8;
        }else if(nivel == 3){//del array las posiciones: 0,1,2,3,4,5,6,7
            numTotal = 12;
        }
        int verdes = 0;

        for(int i =0;i<numTotal;i++){

            ImageView aux = (ImageView)findViewById(semaforos[i]);
            int drawableId = (Integer)aux.getTag();

            if(drawableId == R.drawable.led_verde){
                verdes++;
            }
        }

        //si la cantidad de verdes es la misma que la cantidad de luces termina el nivel.
        if(verdes == numTotal){
            finDelNivel();
        }
    }

    public void clickSemaforo(View view) {

        ImageView aux = (ImageView) view;
        int drawableId = (Integer)aux.getTag();

        if(drawableId == R.drawable.led_rojo){
            aux.setImageResource(R.drawable.led_verde);
            aux.setTag(R.drawable.led_verde);
            totalClicks++;
        }else{
            aux.setImageResource(R.drawable.led_rojo);
            aux.setTag(R.drawable.led_rojo);
            innecesarios++;
        }

        contarSemaforos();

    }

    public void finDelNivel(){

        Toast.makeText(this,"fin del nivel "+nivel,Toast.LENGTH_SHORT).show();

        Intent i = new Intent(this, Ejercicio5_validar.class);
        i.putExtra("nivel", nivel);

        if(nivel == 3){
            int ahora = (int)new Date().getTime();
            int duracionTotal = (ahora - (int)tiempoInit.getTime())/1000;
            i.putExtra("duracionTotal",duracionTotal);
            i.putExtra("totalLuces",totalClicks);
            i.putExtra("innecesarios",innecesarios);
        }

        startActivityForResult(i, 5555);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==5555 && resultCode==RESULT_OK){

            String estado = data.getExtras().getString("estado");
            //si nos devuelve que hemos terminado el juego, lo volveremos a inicializar desde 0.
            if(estado.equalsIgnoreCase("terminado")){
                iniciarComponentes();
            }else{//sino subiremos un nivel y actualizaremos el juego
                nivel++;
                actualizaJuego();
            }

        }
    }

}
