package com.example.database2.MVVM_DATABASE;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MyDao {
    @Insert
    public void addStudent(StudentEntity data);
    @Delete
    public void deleteStudent(StudentEntity data);
    @Update
    public void updateStudent(StudentEntity data);

    @Query("SELECT * FROM STUDENT_TBL ORDER BY ID DESC")
    LiveData<List<StudentEntity>> getAllDaoData();

}
