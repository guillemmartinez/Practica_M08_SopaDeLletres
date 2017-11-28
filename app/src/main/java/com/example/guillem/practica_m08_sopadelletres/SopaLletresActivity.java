package com.example.guillem.practica_m08_sopadelletres;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

public class SopaLletresActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sopa_lletres);

        final GridView grid = (GridView) findViewById(R.id.gridPrincipal);
        final ArrayList<String> items = new ArrayList<String>();

        items.add("A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z,A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z");

        grid.setAdapter(new GridAdapter(items));
    }

    // Assume it's known
    private static final int ROW_ITEMS = 49;

    private static final class GridAdapter extends BaseAdapter {

        final ArrayList<String> mItems;
        final int mCount;

        /**
         * Default constructor
         * @param items to fill data to
         */
        private GridAdapter(final ArrayList<String> items) {

            mCount = items.size() * ROW_ITEMS;
            mItems = new ArrayList<String>(mCount);

            // for small size of items it's ok to do it here, sync way
            for (String item : items) {
                // get separate string parts, divided by ,
                final String[] parts = item.split(",");

                // remove spaces from parts
                for (String part : parts) {
                    part.replace(" ", "");
                    mItems.add(part);
                }
            }
        }

        @Override
        public int getCount() {
            return mCount;
        }

        @Override
        public Object getItem(final int position) {
            return mItems.get(position);
        }

        @Override
        public long getItemId(final int position) {
            return position;
        }

        @Override
        public View getView(final int position, final View convertView, final ViewGroup parent) {

            View view = convertView;

            if (view == null) {
                view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
            }

            final TextView text = (TextView) view.findViewById(android.R.id.text1);

            text.setText(mItems.get(position));

            return view;
        }
    }
}
