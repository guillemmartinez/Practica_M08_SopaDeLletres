package com.example.guillem.practica_m08_sopadelletres;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class SopaLletresActivity extends ActionBarActivity {

    GridView gridView;
    String numbers[] = new String[49];
    ArrayList<Integer> lletresSelecio;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sopa_lletres);

        String[] paraulesXml;
        // https://stackoverflow.com/questions/19617301/android-get-items-from-string-array-and-show-it-one-by-one-in-text-view
        SopaLletresUtility.paraules = getResources().getStringArray(R.array.paraules);
        Random r = new Random();

        lletresSelecio = new ArrayList<>();

        SopaLletresUtility.inicialitzarTaula();
        SopaLletresUtility.direccioParaula();

        Button btnComprova = (Button) findViewById(R.id.comprova);
        btnComprova.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(lletresSelecio);
                boolean diferent = false;
                for (int k = 0; k < 5; k++) {
                    System.out.println("paraula numero:" + k);
                    diferent = false;
                    if (SopaLletresUtility.paraules[k].length() == lletresSelecio.size()) {
                        for (int i = 0; i < SopaLletresUtility.paraules[k].length(); i++) {
                            if (SopaLletresUtility.posicions[k][i] != lletresSelecio.get(i)) {
                                System.out.println("posicio:" + SopaLletresUtility.posicions[k][i] + "a");
                                System.out.println("selecio:" + lletresSelecio.get(i) + "b");
                                diferent = true;
                            }
                        }
                    } else {
                        diferent = true;
                        System.out.println("mida diferent");
                    }
                    if (!diferent) {
                        System.out.println("paraula igual");

                        TextView text = (TextView) findViewById(R.id.textView + (k + 1));
                        text.setText(SopaLletresUtility.paraules[k]);

                    } else {
                        System.out.println("paraula diferent");
                    }
                }
                lletresSelecio = new ArrayList<>();
            }
        });

        for (int i = 0; i < SopaLletresUtility.taula.length; i++) {
            char c = (char) (r.nextInt(26) + 'A');

            if (SopaLletresUtility.taula[i].equals(" "))
            SopaLletresUtility.taula[i] = String.valueOf(c);
        }

        gridView = (GridView) findViewById(R.id.gridPrincipal);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, SopaLletresUtility.taula);

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                Toast.makeText(getApplicationContext(), ((TextView) v).getText(), Toast.LENGTH_SHORT).show();
                // Toast.makeText(context, selector, duration); toast.show();

                lletresSelecio.add(position);



            }
        });
    }
}