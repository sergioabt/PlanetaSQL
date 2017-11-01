package com.SergioLina.sql;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;



import java.util.ArrayList;

public class ListaActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    private ListView listView;
    private ArrayList<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);



 /*       ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1,nombres);*/


        listView = (ListView) findViewById(R.id.list);
        users = new ArrayList<User>();

        final Adapter adapter = new Adapter(this, users);

        listView.setAdapter(adapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListaActivity.this, String.valueOf(position), Toast.LENGTH_LONG).show();
            }
        });
    }

    class Adapter extends ArrayAdapter<User>{

        public Adapter(ListaActivity context, ArrayList<User> user) {
            super(context, R.layout.list_item, user);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.list_item, null);

            User user = getItem(position);

            TextView tUid = item.findViewById(R.id.tID);
            tUid.setText(user.getUid());

            TextView tName = item.findViewById(R.id.tName);
            tName.setText(user.getName());

            TextView tNameL = item.findViewById(R.id.tNameL);
            tNameL.setText(user.getNameL());

            TextView tNameA = item.findViewById(R.id.tNameA);
            tNameA.setText(user.getNameA());

            TextView tPhone = item.findViewById(R.id.tPhone);
            tPhone.setText(user.getPhone());

            return item;
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){

            onBackPressed();

        }
        return super.onOptionsItemSelected(item);
    }
}
