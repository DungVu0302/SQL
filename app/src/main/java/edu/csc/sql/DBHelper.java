package edu.csc.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;

public class DBHelper {
    Context context;
    String dbName="sql.db";

    public DBHelper(Context context) {
        this.context = context;
    }
    public SQLiteDatabase openDB()
    {
        return context.openOrCreateDatabase(dbName,Context.MODE_PRIVATE,null);
    }
    public void closeDB(SQLiteDatabase db)
    {
        db.close();
    }
    public void createTable()
    {
        SQLiteDatabase db=openDB();
        String sql="create table if not exists tblStudent(id integer PRIMARY KEY autoincrement,name text);";
        db.execSQL(sql);
        Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
        db.close();
    }
    public ArrayList<Student> getData()
    {
        ArrayList<Student> arrayList=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=openDB();
        String sql="select * from tblStudent";
        Cursor cursor=sqLiteDatabase.rawQuery(sql,null);
        while (cursor.moveToNext())
        {
            int i=cursor.getInt(0);
            String name=cursor.getString(1);
            arrayList.add(new Student(i,name));
        }
        sqLiteDatabase.close();
        return arrayList;
    }
    public long insert(Student student)
    {
        ContentValues st=new ContentValues();
        st.put("name",student.getName());
        SQLiteDatabase sqLiteDatabase=openDB();
        long status=sqLiteDatabase.insert("tblStudent",null,st);
        Toast.makeText(context, "Insert Success", Toast.LENGTH_SHORT).show();
        sqLiteDatabase.close();
        return status;
    }
}
