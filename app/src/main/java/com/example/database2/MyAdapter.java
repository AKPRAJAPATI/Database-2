package com.example.database2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.database2.MVVM_DATABASE.StudentEntity;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.myviewHolder> {

    Context context;
    ArrayList<StudentEntity> arrayList;

    public MyAdapter(Context context, ArrayList<StudentEntity> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public myviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new myviewHolder(LayoutInflater.from(context).inflate(R.layout.items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull myviewHolder holder, int position) {
        StudentEntity entity = arrayList.get(position);

        if (entity == null){
            return;
        }

        holder.textView.setText(entity.getFirstname());
        holder.textVieww.setText(entity.getLastname());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class myviewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        TextView textVieww;

        public myviewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            textVieww = itemView.findViewById(R.id.textVieww);


        }
    }
}
