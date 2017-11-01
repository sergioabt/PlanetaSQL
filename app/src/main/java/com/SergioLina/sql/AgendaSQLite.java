package com.SergioLina.sql;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.NavigationView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

public class AgendaSQLite extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    EditText eID, eName,eNameL, eNameA, ePhone;
    Button bPrestar, bEditar, bListar, bDelete;


    ContactosSQLiteHelper contactosSQLiteHelper;
    SQLiteDatabase dbContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.frame);
        getLayoutInflater().inflate(R.layout.activity_main, contentFrameLayout);

        eID = (EditText) findViewById(R.id.eID);
        eName = (EditText) findViewById(R.id.eName);
        eNameL = (EditText) findViewById(R.id.eNameL);
        eNameA = (EditText) findViewById(R.id.eNameA);

        ePhone = (EditText) findViewById(R.id.ePhone);
        bPrestar = (Button) findViewById(R.id.bPrestar);
        bEditar = (Button) findViewById(R.id.bEditar);
        bListar = (Button) findViewById(R.id.bListar);
        bDelete = (Button) findViewById(R.id.bDelete);

        contactosSQLiteHelper = new ContactosSQLiteHelper(this, "AgendaBD", null, 1);
        dbContactos = contactosSQLiteHelper.getWritableDatabase();

    }

    public void onClick(View view) {
        int id = view.getId();
        final String name, nameL, nameA, phone, uuid;

        name = eName.getText().toString();
        nameL = eNameL.getText().toString();
        nameA = eNameA.getText().toString();
        phone = ePhone.getText().toString();

        ContentValues data = new ContentValues();

        switch (id){
            case R.id.bPrestar:

                //ContentValues data = new ContentValues();
                data.put("name",name);
                data.put("nameL",nameL);
                data.put("nameA",nameA);
                data.put("phone",phone);


                dbContactos.insert("contactos", null,data);
                clean();

                break;

            case R.id.bListar:

                Cursor c = dbContactos.rawQuery("SELECT * FROM contactos WHERE nameL='"+nameL+"'",null);
                if (c.moveToFirst()){
                    eName.setText(c.getString(0));
                    eNameL.setText(c.getString(1));
                    eNameA.setText(c.getString(2));
                    ePhone.setText(c.getString(3));


                } else {
                    Toast.makeText(this, "No Existe", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.bEditar:

                //ContentValues data = new ContentValues();
                data.put("nameL",nameL);
                data.put("nameA",nameA);
                data.put("phone",phone);


                dbContactos.update("contactos", data, "nameL = '"+nameL+"'",null);
                clean();

                break;

            case R.id.bDelete:

                dbContactos.delete("contactos", "nameL = '"+nameL+"'",null);
                clean();

                break;
        }
    }

    private void clean() {
        eName.setText("");
        eNameL.setText("");
        eNameA.setText("");
        ePhone.setText("");

    }

}
