package com.example.dell.hero;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private OnItemClickListener mListener;
    private RecyclerView mRecyclerView;
    private StudentAdapter mStudentAdapter;
    private ArrayList<Student> studentArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        itemClick();
    }

    private void itemClick() {
        mStudentAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getApplicationContext(), DetailStudent.class);
                intent.putExtra("student", studentArrayList.get(position));
                startActivity(intent);
            }
        });
    }

    public void initView() {
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);

        studentArrayList.add(new Student(R.drawable.boy, "Nguyen Van Lo","1","K21-CMUTPM6"));
        studentArrayList.add(new Student(R.drawable.girl, "Nguyen Thi La","2", "K21-CMUTPM6"));
        studentArrayList.add(new Student(R.drawable.boy, "Lo Van Su", "3", "The World"));
        studentArrayList.add(new Student(R.drawable.girl, "Nong Van Can", "4242", "PSU"));
        studentArrayList.add(new Student(R.drawable.boy, "Ly Van To", "3455", "LTDD"));
        studentArrayList.add(new Student(R.drawable.girl, "Cam Tu", "144345", "CDIO"));
        studentArrayList.add(new Student(R.drawable.boy, "Trang Duong", "57", "Android"));

        mStudentAdapter = new StudentAdapter(studentArrayList, getApplicationContext());
        mRecyclerView.setAdapter(mStudentAdapter);
    }
}
