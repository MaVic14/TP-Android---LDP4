package com.avase.tp_android___ldp4;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
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


        Set conjuntoNumeros = new HashSet<Integer>();
        conjuntoNumeros.add(Integer.parseInt(Numeros[0]));

        String numeroFinalUsuario = "";
        String numeroFinalSorteado = "";
        Random random = new Random();
        for(int i = 1; i < 6; i++){
            Integer numeroActual = Integer.parseInt(Numeros[i]);
            if(conjuntoNumeros.contains(numeroActual)){
                //TODO: Quejarse de numeros iguales
                return;
            }
            else{
                conjuntoNumeros.add(numeroActual);
                numeroFinalUsuario += Numeros[i];
                numeroFinalSorteado += String.valueOf(random.nextInt(10));
            }
        }

        if(numeroFinalUsuario.equals(numeroFinalSorteado)){
            //TODO: ganó!
        }
        else{
            //TODO: perdió...
        }

    }
}
