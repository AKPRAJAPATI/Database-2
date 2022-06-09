package com.example.database2.MVVM_DATABASE;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MyViewModle extends AndroidViewModel {
  public   LiveData<List<StudentEntity>> getmyData;

    public MyViewModle(@NonNull Application application) {
        super(application);
        //yaha database mai se dao ko nikalo
        MyDao myDao = MyDatabase.getInstance(application).myDao();
        getmyData = myDao.getAllDaoData();

    }
}
