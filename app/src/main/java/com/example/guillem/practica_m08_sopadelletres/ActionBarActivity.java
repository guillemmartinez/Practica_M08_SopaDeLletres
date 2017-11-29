package com.example.guillem.practica_m08_sopadelletres;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Classe que hereta d'Activity i que demostra el
 * funcionament d'una barra d'estat
 * @author sergi.grau@fje.edu
 * @version 1.0 28.10.2013
 *
 */
public class ActionBarActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.activity_actionbar, menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_actionbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.ajuda:
                obrirAjuda();
                return true;
            case R.id.sortir:
                obrirSortida();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void obrirAjuda() {
        startActivity(new Intent(ActionBarActivity.this, WebviewActivity.class));
    }

    private void obrirSortida() {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);

    }


}
