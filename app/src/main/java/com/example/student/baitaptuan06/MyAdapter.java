package com.example.student.baitaptuan06;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Student on 9/18/2018.
 */

public class MyAdapter extends BaseAdapter {
    private Context mContext;
    private int mLayout;
    private List<Person> lstPerson;

    public MyAdapter (Context context, int layout, List<Person> objects){
        this.mContext = context;
        this.mLayout = layout;
        this.lstPerson = objects;
    }

    @Override
    public int getCount() {
        return lstPerson.size();
    }

    @Override
    public Object getItem(int position) {
        return lstPerson.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(mContext).inflate(mLayout, parent, false);
        TextView name = (TextView) convertView.findViewById(R.id.lblName);
        TextView age = (TextView) convertView.findViewById(R.id.lblAge);
        ImageView imageView = (ImageView)convertView.findViewById(R.id.imgPerson);

        Person person = lstPerson.get(position);
        name.setText(person.getName());
        age.setText(person.getAge() + "");
        imageView.setImageResource(person.getImg());

        return convertView;
    }
}
