package com.avase.tp_android___ldp4;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.content.Intent;


public class MainActivity extends Activity{
    private boolean mobileConnected=false;
    private boolean wifiConnected=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.findViewById(R.id.textUser).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView txt_usuario = (TextView) v;
                if (txt_usuario.getText().equals(getString(R.string.usuario))) {
                    txt_usuario.setText("");
                }
            }
        });
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

    public void iniciarJuego(View v){

        Intent intent = new Intent(v.getContext(), juego.class);
        startActivity(intent);
    }

    /*
    private void checkNetworkConnection() {
        // BEGIN_INCLUDE(connect)
        ConnectivityManager connMgr =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeInfo = connMgr.getActiveNetworkInfo();
        if (activeInfo != null && activeInfo.isConnected()) {
            wifiConnected = activeInfo.getType() == ConnectivityManager.TYPE_WIFI;
            mobileConnected = activeInfo.getType() == ConnectivityManager.TYPE_MOBILE;
        }
        TextView txt_tipo_de_conexion = (TextView) findViewById(R.id.tipo_de_conexion);
        if (mobileConnected) {
            txt_tipo_de_conexion.append(getString(R.string.tipo_de_conexion_datos));
        } else if (wifiConnected) {
            txt_tipo_de_conexion.append(getString(R.string.tipo_de_conexion_wifi));
        } else {
            txt_tipo_de_conexion.setText(getString(R.string.tipo_de_conexion_sin_conexion));
        }
    }*/
}
