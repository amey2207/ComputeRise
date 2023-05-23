package com.example.computeriseadminapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.computeriseadminapp.faculty.UpdateFaculty;
import com.example.computeriseadminapp.notice.DeleteNoticeActivity;
import com.example.computeriseadminapp.notice.UploadNotice;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    CardView uploadNotice,uploadimage,uploadebook,updatefaculty,deletenotice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uploadNotice=findViewById(R.id.uploadnotice);

        uploadimage=findViewById(R.id.uploadimage);
        uploadebook=findViewById(R.id.uploadebook);
        updatefaculty=findViewById(R.id.updatefaculty);
        deletenotice=findViewById(R.id.deletenotice);

        uploadNotice.setOnClickListener(this);
        uploadimage.setOnClickListener(this);
        uploadebook.setOnClickListener(this);
        updatefaculty.setOnClickListener(this);
        deletenotice.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch(view.getId()){
            case R.id.uploadnotice:
                 intent=new Intent(MainActivity.this, UploadNotice.class);
                    startActivity(intent);
                    break;
            case R.id.uploadimage:
                 intent=new Intent(MainActivity.this,UploadImage.class);
                startActivity(intent);
                break;
                case R.id.uploadebook:
                 intent=new Intent(MainActivity.this,UploadPdfActivity.class);
                startActivity(intent);
                break;
            case R.id.updatefaculty:
                 intent=new Intent(MainActivity.this,UpdateFaculty.class);
                startActivity(intent);
                break;
          

        }

    }
}