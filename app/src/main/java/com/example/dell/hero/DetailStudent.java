package com.example.dell.hero;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailStudent extends AppCompatActivity {
    private TextView mTextNameDetail , mTextClassDetail, mTextMssvDetail;
    private ImageView mImageView;
    private Button mButtonUpdate, mButtonOK ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_student);
        findID();
        getInformation();
        getDataUpdated();


    }

    private void getDataUpdated() {
//        mButtonOK.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = getIntent();
//                mTextNameDetail.setText(intent.getStringExtra("name"));
//                mTextClassDetail.setText(intent.getStringExtra("class"));
//                mTextMssvDetail.setText(intent.getStringExtra("id"));
//            }
//        });

    }

    private void findID() {
        //mButtonOK = (Button) findViewById(R.id.button_ok);
        mTextNameDetail = (TextView) findViewById(R.id.text_name_detail);
        mImageView = (ImageView) findViewById(R.id.image_detail);
        mTextClassDetail = (TextView) findViewById(R.id.text_class_detail);
        mTextMssvDetail = (TextView) findViewById(R.id.text_mssv_detai);
        mButtonUpdate = (Button) findViewById(R.id.button_cap_nhap_thong_tin);

    }



    private void getInformation() {
        // Nhận dữ liệu từ Seriablize
        Student student = (Student) getIntent().getSerializableExtra("student");
        int imageDetail = student.getImage();
        String nameStudent = student.getName();
        String classNameDetail = student.getClassName();
        String mssvDetail = student.getID();
        // Cập nhập dữ liệu
        mTextNameDetail.setText(nameStudent);
        mTextClassDetail.setText(classNameDetail);
        mTextMssvDetail.setText(mssvDetail);
        mImageView.setImageResource(imageDetail);

        //Xử lý button
        mButtonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Update.class);
                startActivity(intent);
            }
        });


    }
}
