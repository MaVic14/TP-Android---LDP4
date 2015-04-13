package com.avase.tp_android___ldp4;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;
import java.util.Random;

public class juego extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        this.findViewById(R.id.btn_jugar).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v){
                ( (juego)v.getParent() ).jugar();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_juego, menu);
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

    public void jugar(){
        String Numeros[] = new String[6];
        Numeros[0] = (String)((TextView)this.findViewById(R.id.txt_primerNumero)).getText();
        Numeros[1] = (String)((TextView)this.findViewById(R.id.txt_segundoNumero)).getText();
        Numeros[2]= (String)((TextView)this.findViewById(R.id.txt_tercerNumero)).getText();
        Numeros[3]= (String)((TextView)this.findViewById(R.id.txt_cuartoNumero)).getText();
        Numeros[4] = (String)((TextView)this.findViewById(R.id.txt_quintoNumero)).getText();
        Numeros[5] = (String)((TextView)this.findViewById(R.id.txt_sextoNumero)).getText();


        Set conjuntoNumerosUsuario = new HashSet<Integer>();
        Set conjuntoNumerosSorteados = new HashSet<Integer>();
        Random random = new Random();
        for(int i = 1; i < 6; i++){
            Integer numeroActual = null;
            try {
                numeroActual = Integer.parseInt(Numeros[i]);
            }
            catch(Exception e){
                Toast.makeText(this.getBaseContext(), R.string.revisarNumeros, Toast.LENGTH_SHORT);
                return;
            }

            if(numeroActual < 0 || numeroActual > 36){
                Toast.makeText(this.getBaseContext(), R.string.revisarRangoNumeros, Toast.LENGTH_SHORT);
                return;
            }

            if(conjuntoNumerosUsuario.contains(numeroActual)){
                Toast.makeText(this.getBaseContext(), R.string.revisarRepeticionNumeros, Toast.LENGTH_SHORT);
                return;
            }

           conjuntoNumerosUsuario.add(numeroActual);
           conjuntoNumerosSorteados.add(random.nextInt(36));
        }

        Integer cantidadNumerosAcertados = 0;
        Iterator it = conjuntoNumerosUsuario.iterator();
        while(it.hasNext()){
            if(conjuntoNumerosSorteados.contains(it.next())){
                cantidadNumerosAcertados++;
            }
        }

        if(cantidadNumerosAcertados > 0){
            //TODO: ganó!
        }
        else{
            //TODO: perdió!
        }

    }
}
