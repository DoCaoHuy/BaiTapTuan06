package com.example.student.baitaptuan06;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class AddPersonActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtMa, txtTen, txtAge;
    private RadioGroup rdg;
    private Button btnAdd;
    private Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);

        txtMa = (EditText) findViewById(R.id.txtID);
        txtTen = (EditText) findViewById(R.id.txtName);
        txtAge = (EditText)findViewById(R.id.txtAge);
        rdg = (RadioGroup) findViewById(R.id.rdGroup);
        btnAdd = (Button) findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAdd:
                if(rdg.getCheckedRadioButtonId() == R.id.rdNam){
                    person = new Person(txtMa.getText().toString(), txtTen.getText().toString(), Integer.parseInt(txtAge.getText().toString()),R.drawable.male);
                }else {
                    person = new Person(txtMa.getText().toString(), txtTen.getText().toString(), Integer.parseInt(txtAge.getText().toString()),R.drawable.female);
                }
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("person", person);
                intent.putExtra("data", bundle);
                setResult(RESULT_OK, intent);
                finish();
                break;
        }
    }
}
