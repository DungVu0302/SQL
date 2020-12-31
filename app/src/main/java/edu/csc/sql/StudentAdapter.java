package edu.csc.sql;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class StudentAdapter extends ArrayAdapter<Student> {
    public StudentAdapter(@NonNull Context context, @NonNull List<Student> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Student student=getItem(position);
        ViewHolder viewHolder;
        if(convertView==null)
        {
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.item_student,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.txt1=convertView.findViewById(R.id.txtId);
            viewHolder.txt2=convertView.findViewById(R.id.txtName);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.txt1.setText(student.id+"");
        viewHolder.txt2.setText(student.name);
        return convertView;
    }

    class ViewHolder
    {
        TextView txt1,txt2;
    }
}
