package com.example.guillem.practica_m08_sopadelletres;
//mirar material 4 uf2 android github per veure el ontouch event per fer la seleccio fluïda
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BenvingutsActivity extends AppCompatActivity {

    Button btn = (Button)findViewById(R.id.playButton);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_benvinguts);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BenvingutsActivity.this, SopaLletresActivity.class));
            }
        });

    }
}
