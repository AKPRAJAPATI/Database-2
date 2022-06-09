package com.example.database2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.database2.MVVM_DATABASE.MyDatabase;
import com.example.database2.MVVM_DATABASE.MyRepository;
import com.example.database2.MVVM_DATABASE.StudentEntity;

public class MainActivity extends AppCompatActivity {

    EditText firstname, lastname;
    Button save, show;

    MyRepository myRepository; //bhai database mai se dao le lena new keyword laga kar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Entity
        //Dao
        //Database
        //Repository
        //viewmodel

        myRepository = new MyRepository(MyDatabase.getInstance(getApplicationContext()).myDao());

        firstname = findViewById(R.id.firstname);
        lastname = findViewById(R.id.lastname);
        save = findViewById(R.id.saveBtn);
        show = findViewById(R.id.showbtn);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fname = firstname.getText().toString();
                String lname = lastname.getText().toString();
                if (fname.isEmpty()) {
                    Toast.makeText(MainActivity.this, "first name is empty", Toast.LENGTH_SHORT).show();
                } else if (lname.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Last name is empty", Toast.LENGTH_SHORT).show();
                } else {
                    //tumko data ko add karane ke liye kis kis ki jarurat hai chalo dekhate hai
                    //hamko data add karane ke liye ENTITY or REPOSITORY ki jarurat padegi

                    StudentEntity studentEntity;

                    studentEntity = new StudentEntity(fname, lname);
                    myRepository.addStudent(studentEntity);

                    Toast.makeText(MainActivity.this, "Added", Toast.LENGTH_SHORT).show();

                    firstname.setText("");
                    lastname.setText("");

                }
            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Show_Data_Activity.class));
            }
        });

    }
}