package com.example.guillem.practica_m08_sopadelletres;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
/**
 * Classe que hereta d'Activity i que demostra el
 * funcionament d'una barra d'estat
 * @author sergi.grau@fje.edu
 * @version 1.0 28.10.2013
 *
 */
public class ActionBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actionbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_actionbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.cerca:
                obrirCerca();
                return true;
            case R.id.ajustos:
                obrirAjustos();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void obrirAjustos() {
        // TODO Auto-generated method stub

    }

    private void obrirCerca() {
        // TODO Auto-generated method stub

    }


}
