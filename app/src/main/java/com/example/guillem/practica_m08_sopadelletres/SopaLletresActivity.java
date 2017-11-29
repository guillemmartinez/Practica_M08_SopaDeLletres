package com.example.guillem.practica_m08_sopadelletres;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
import java.util.Random;

public class SopaLletresActivity extends AppCompatActivity {

    GridView gridView;
    String numbers[] = new String[49];

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Random r = new Random();

        for(int i = 0; i < numbers.length; i++){
            char c = (char) (r.nextInt(26) + 'A');
            numbers[i] = String.valueOf(c);
        }

        setContentView(R.layout.activity_sopa_lletres);
        gridView = (GridView) findViewById(R.id.gridPrincipal);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, numbers);

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                int pintar;
                pintar = 0;
                ArrayList<String> paraula = new ArrayList<String>();

                //Toast.makeText(getApplicationContext(), ((TextView) v).getText(), Toast.LENGTH_SHORT).show();
                paraula.add(((TextView) v).getText().toString());
                Log.d("lletra premuda",paraula.toString());

                // Toast.makeText(context, selector, duration); toast.show();
                //v.setSelected(true);
                if (pintar != 0)
                    v.setBackgroundColor(Color.TRANSPARENT);
                else {
                    v.setBackgroundColor(Color.YELLOW);
                    pintar = 1;
                }
            }
        });
    }
}