package com.example.guillem.practica_m08_sopadelletres;

import android.app.ActionBar;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class SopaLletresActivity extends ActionBarActivity {

    GridView gridView;
    String numbers[] = new String[49];

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sopa_lletres);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Random r = new Random();

        for(int i = 0; i < numbers.length; i++){
            char c = (char) (r.nextInt(26) + 'A');
            numbers[i] = String.valueOf(c);
        }
        gridView = (GridView) findViewById(R.id.gridPrincipal);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, numbers);

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(getApplicationContext(),
                        ((TextView) v).getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
