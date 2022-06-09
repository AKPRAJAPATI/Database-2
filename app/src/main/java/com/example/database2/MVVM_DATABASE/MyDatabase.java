package com.example.database2.MVVM_DATABASE;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {StudentEntity.class}, version = 1)
public abstract class MyDatabase extends RoomDatabase {

    public static MyDatabase myDatabase;
    public abstract MyDao myDao();

    public static synchronized MyDatabase getInstance(Context context) {
        //if you check database null or not if database is equal to null to make new database
        if (myDatabase == null) {
            myDatabase = Room.databaseBuilder(context, MyDatabase.class, "student_db").build();
        }
        return myDatabase;
    }
}
