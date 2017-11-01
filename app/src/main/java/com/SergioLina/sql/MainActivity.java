package com.SergioLina.sql;

import android.support.design.widget.NavigationView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;



import java.util.HashMap;
import java.util.Map;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    EditText eID, eName, ePhone,eNameL,eNameA;
    Button bPrestar, bListar, bEditar, bDelete;

    int uid = 0;

    User user;

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
        bListar = (Button) findViewById(R.id.bListar);
        bEditar = (Button) findViewById(R.id.bEditar);
        bDelete = (Button) findViewById(R.id.bDelete);

        // Write a message to the database
        //FirebaseDatabase database = FirebaseDatabase.getInstance();
        //DatabaseReference myRef = database.getReference("message");

        //myRef.setValue("Hello, World!");

    }

    public void onClick(View view) {
        int id = view.getId();
        final String name,nameL,nameA, phone, uuid;

        name = eName.getText().toString();
        nameL = eNameL.getText().toString();
        nameA = eNameA.getText().toString();
        phone = ePhone.getText().toString();

        switch (id){
            case R.id.bPrestar:

                user = new User(name, nameL, nameA, phone, "user"+ uid);


                uid++;
                clean();
                break;
            case R.id.bEditar:

                uuid = eID.getText().toString();


                Map<String, Object> newData = new HashMap<>();
                newData.put("name", name);
                newData.put("nameL", nameL);
                newData.put("nameA", nameA);
                newData.put("phone", phone);

                break;
            case R.id.bListar:
                uuid = eID.getText().toString();
                break;
            case R.id.bDelete:
                uuid = eID.getText().toString();


                break;
        }
    }

    private void clean() {
        eName.setText("");
        eNameL.setText("");
        eNameA.setText("");
        ePhone.setText("");
        eID.setText("");
    }
}
