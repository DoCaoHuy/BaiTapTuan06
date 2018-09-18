package com.example.student.baitaptuan06;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener{

    private ListView lvPerson;
    private List<Person> lstPerson;
    private MyAdapter adapter;
    private Button btnThem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvPerson = (ListView) findViewById(R.id.lvPerson);
        lstPerson = new ArrayList<>();

        btnThem = (Button)findViewById(R.id.btnThem);
        loadListView();
        btnThem.setOnClickListener(this);
        lvPerson.setOnItemClickListener(this);
    }

    private void loadListView(){
        adapter = new MyAdapter(this, R.layout.person_layout, lstPerson);
        lvPerson.setAdapter(adapter);
    }

    private void openAddPerson(Context context){
        Intent intent = new Intent(context, AddPersonActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnThem:
                openAddPerson(this);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                Person p = (Person) data.getBundleExtra("data").getSerializable("person");
                lstPerson.add(p);
                loadListView();
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Person p = lstPerson.get(position);
       // Toast.makeText(this, p.getName(), Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, ShowPersonActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("person", p);
        i.putExtra("data", bundle);
        startActivity(i);
    }
}
