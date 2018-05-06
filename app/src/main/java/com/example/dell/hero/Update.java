package com.example.dell.hero;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Update extends AppCompatActivity {
    private EditText mEditName, mEditClass, mEditId;
    private TextView mTextNameDetail , mTextClassDetail, mTextMssvDetail;
    private Button mButtonOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        findID();



    }

    private void setDataUpdated() {
        mTextNameDetail.setText(mEditName.getText().toString());
        mTextClassDetail.setText(mEditClass.getText().toString());
        mTextMssvDetail.setText(mEditId.getText().toString());
    }

    private void findID() {
        mTextNameDetail = (TextView) findViewById(R.id.text_name_detail);
        mTextClassDetail = (TextView) findViewById(R.id.text_class_detail);
        mTextMssvDetail = (TextView) findViewById(R.id.text_mssv_detai);
        mEditName = (EditText) findViewById(R.id.edit_student_name);
        mEditClass = (EditText) findViewById(R.id.edit_student_class);
        mEditId = (EditText) findViewById(R.id.edit_student_id);
        mButtonOK = (Button) findViewById(R.id.button_ok);


        mButtonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Update.this, DetailStudent.class);
                intent.putExtra("name", mEditName.getText().toString());
                intent.putExtra("class",mEditClass.getText().toString());
                intent.putExtra("id",mEditId.getText().toString());
                startActivity(intent);
            }
        });

    }
}
