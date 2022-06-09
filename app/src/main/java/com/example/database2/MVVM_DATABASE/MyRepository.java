package com.example.database2.MVVM_DATABASE;

import androidx.lifecycle.LiveData;

import java.util.List;

public class MyRepository {

    private MyDao dao;

    public MyRepository(MyDao dao) {
        this.dao = dao;
    }

    public void addStudent(StudentEntity add){
        new Thread(new Runnable() {
            @Override
            public void run() {
            //yaha par dao mai data ko add karenge
                dao.addStudent(add);
            }
        }).start();
    }
    public void updateStudent(StudentEntity update){
        new Thread(new Runnable() {
            @Override
            public void run() {
                dao.updateStudent(update);
            }
        }).start();
    }
    public void deleteStudent(StudentEntity delete){
        new Thread(new Runnable() {
            @Override
            public void run() {
                dao.deleteStudent(delete);
            }
        }).start();
    }



    //yaha live data ko u ki tyu hi rakh lo or return kar do dao mai se data

    LiveData<List<StudentEntity>> getmyRepositoryData(){
        return dao.getAllDaoData();
    }

}
