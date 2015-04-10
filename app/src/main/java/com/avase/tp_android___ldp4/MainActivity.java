package com.avase.tp_android___ldp4;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.view.View.OnClickListener;


public class MainActivity extends ActionBarActivity implements OnClickListener{
    private boolean mobileConnected=false;
    private boolean wifiConnected=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Chequeamos el tipo de conexion
        checkNetworkConnection();
        TextView txt_usuario = (TextView) findViewById(R.id.textUser);
        txt_usuario.setOnClickListener(this);
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
    }

    @Override
    public void onClick(View v) {
        TextView txt_usuario = (TextView) findViewById(R.id.textUser);
        if (txt_usuario.getText()==getString(R.string.usuario)) {
            //TODO: Hacer que borre el campo al clickear
            txt_usuario.setText(" ");

        }
    }
}
