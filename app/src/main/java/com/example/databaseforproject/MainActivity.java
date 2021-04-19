package com.example.databaseforproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {


    EditText edtName;
    Button button;
    Spinner spnr;

    DatabaseReference dbr;


    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbr= FirebaseDatabase.getInstance().getReference("Complaints");


        button=(Button) findViewById(R.id.btn_val);
        edtName=(EditText) findViewById(R.id.txt_val);
        spnr=(Spinner) findViewById(R.id.spinner_val);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AddNames();

            }
        });
    }

    private void AddNames()
    {

        String name=edtName.getText().toString().trim();
        String type= spnr.getSelectedItem().toString();

        if(!TextUtils.isEmpty(name))
        {
            String id= dbr.push().getKey();
            Names names=new Names(id,name,type);

            dbr.child(id).setValue(names);

            Toast.makeText(this, "Complaint Sent !", Toast.LENGTH_LONG).show();





        }
        else
        {

            Toast.makeText(this, "Enter Your email ! ", Toast.LENGTH_LONG).show();
        }


    }









}