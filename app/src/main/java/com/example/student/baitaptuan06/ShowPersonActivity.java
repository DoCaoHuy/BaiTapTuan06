package com.example.student.baitaptuan06;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ShowPersonActivity extends AppCompatActivity {

    TextView txtName, txtAge, txtGioiTinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_person);

        txtName = (TextView)findViewById(R.id.lblSName);
        txtAge = (TextView)findViewById(R.id.lblSTuoi);
        txtGioiTinh = (TextView)findViewById(R.id.lblSGioiTinh);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getBundleExtra("data");
        Person p = (Person) bundle.getSerializable("person");

        txtName.setText(p.getName().toString());
        txtAge.setText(p.getAge() + "");
        if(p.getImg() == R.drawable.male){
            txtGioiTinh.setText("Nam");
        }
        else txtGioiTinh.setText("Nu");
    }
}
