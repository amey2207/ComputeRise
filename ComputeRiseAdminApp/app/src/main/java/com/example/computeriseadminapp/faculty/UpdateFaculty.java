
package com.example.computeriseadminapp.faculty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.computeriseadminapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UpdateFaculty extends AppCompatActivity {

    FloatingActionButton fab;
    private RecyclerView tDepartment,ntDepartment,oDepartment;
    private LinearLayout tNoData,ntNoData,oNoData;
    private List<TeacherData> list1,list2,list3;
    private TeacherAdapter adapter;

    private DatabaseReference reference,dbRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_faculty);

        oDepartment=findViewById(R.id.oDepartment);
        tDepartment=findViewById(R.id.tDepartment);
        ntDepartment=findViewById(R.id.ntDepartment);

        oNoData=findViewById(R.id.oNoData);
        tNoData=findViewById(R.id.tNoData);
        ntNoData=findViewById(R.id.ntNoData);

        reference= FirebaseDatabase.getInstance().getReference().child("teacher");

        tDepartment();
        ntDepartment();
        oDepartment();



        fab=findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UpdateFaculty.this,AddTeacher.class));
            }
        });
    }

    private void tDepartment() {
        dbRef = reference.child("Teaching");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list1 = new ArrayList<>();
                if(! snapshot.exists()){
                    tNoData.setVisibility(View.VISIBLE);
                    tDepartment.setVisibility(View.GONE);

                }else {
                    tNoData.setVisibility(View.GONE);
                    tDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                        TeacherData data= dataSnapshot.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    tDepartment.setHasFixedSize(true);
                    tDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list1,UpdateFaculty.this,"Teaching");
                    tDepartment.setAdapter(adapter);
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this,databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void ntDepartment() {
        dbRef = reference.child("Non Teaching");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list2 = new ArrayList<>();
                if(! snapshot.exists()){
                    ntNoData.setVisibility(View.VISIBLE);
                    ntDepartment.setVisibility(View.GONE);

                }else {
                    ntNoData.setVisibility(View.GONE);
                    ntDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                        TeacherData data= dataSnapshot.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    ntDepartment.setHasFixedSize(true);
                    ntDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list2,UpdateFaculty.this,"Non Teaching");
                    ntDepartment.setAdapter(adapter);
                }

 
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this,databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    } private void oDepartment() {
        dbRef = reference.child("Others");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list3 = new ArrayList<>();
                if(! snapshot.exists()){
                    oNoData.setVisibility(View.VISIBLE);
                    oDepartment.setVisibility(View.GONE);

                }else {
                    oNoData.setVisibility(View.GONE);
                    oDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                        TeacherData data= dataSnapshot.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    oDepartment.setHasFixedSize(true);
                    oDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list3,UpdateFaculty.this,"Others");
                    oDepartment.setAdapter(adapter);
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this,databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}