package edu.csc.sql;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnCreate,btnInsert;
    DBHelper dbHelper;
    ListView lst;
    ArrayList<Student> arrayList;
    StudentAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        dbHelper=new DBHelper(MainActivity.this);
        arrayList=dbHelper.getData();
        adapter=new StudentAdapter(MainActivity.this,arrayList);
        lst.setAdapter(adapter);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            dbHelper.createTable();
            }
        });
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student student=new Student("cde");
                if(dbHelper.insert(student)>0)
                {
                    adapter.clear();
                    arrayList.addAll(dbHelper.getData());
                   adapter.notifyDataSetChanged();
                }

            }
        });
    }
    public void addControl()
    {
        btnCreate=findViewById(R.id.btnCreate);
        btnInsert=findViewById(R.id.btnInsert);
        lst=findViewById(R.id.lst);
    }
}