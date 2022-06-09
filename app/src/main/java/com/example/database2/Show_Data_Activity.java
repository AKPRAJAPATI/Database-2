package com.example.database2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.database2.MVVM_DATABASE.MyDao;
import com.example.database2.MVVM_DATABASE.MyDatabase;
import com.example.database2.MVVM_DATABASE.MyRepository;
import com.example.database2.MVVM_DATABASE.MyViewModle;
import com.example.database2.MVVM_DATABASE.StudentEntity;

import java.util.ArrayList;
import java.util.List;

public class Show_Data_Activity extends AppCompatActivity {
    RecyclerView recyclerView;
    MyAdapter myAdapter;


    MyDao myDao;
    MyViewModle myViewModle;
    MyRepository myRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        myDao = MyDatabase.getInstance(getApplicationContext()).myDao();
        //view model provider viewModelProvider se hi aayega new viewModel Provider
        myViewModle = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())).get(MyViewModle.class);
        myRepository = new MyRepository(myDao);



        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        ArrayList<StudentEntity> arrayList = new ArrayList<>();
        myAdapter = new MyAdapter(getApplicationContext(), arrayList);

        //ab bhai data bas hamare viewmodel mai se aayega


        myViewModle.getmyData.observe(this, new Observer<List<StudentEntity>>() {
            @Override
            public void onChanged(List<StudentEntity> studentEntities) {
                myAdapter.notifyDataSetChanged();
                arrayList.addAll(studentEntities);
                myAdapter.notifyDataSetChanged();
            }
        });

        recyclerView.setAdapter(myAdapter);

    }
}