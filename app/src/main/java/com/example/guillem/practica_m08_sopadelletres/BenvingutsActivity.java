package com.example.guillem.practica_m08_sopadelletres;
//mirar material 4 uf2 android github per veure el ontouch event per fer la seleccio fluïda
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

public class BenvingutsActivity extends ActionBarActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_benvinguts);

        //SopaLletresUtility.generarParaulaVertical();
        Button btn = (Button)findViewById(R.id.playButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BenvingutsActivity.this, SopaLletresActivity.class));
            }
        });

    }


}
