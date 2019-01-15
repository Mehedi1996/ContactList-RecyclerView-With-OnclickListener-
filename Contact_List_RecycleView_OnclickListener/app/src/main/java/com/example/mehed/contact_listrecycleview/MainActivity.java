package com.example.mehed.contact_listrecycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ContactAdapter.ClickListener {
EditText name,phone;
   RecyclerView recyclerView;
   Button saveData;
   String Name;
   String PhoneNo;
   ContactAdapter adapter;
   ArrayList<Contact>contractList;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.nameET);
        phone=findViewById(R.id.phoneET);
        recyclerView=findViewById(R.id.recycleviewBt);
        saveData=findViewById(R.id.save_contactBT);

        contractList=new ArrayList<>();
        RecyclerView.LayoutManager manager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
    }

    public void Save(View view) {
        Name=name.getText().toString();
        PhoneNo=phone.getText().toString();
        Contact contact=new Contact(Name,PhoneNo);
        contractList.add(contact);  //Contact arrayList er morde Name PhoneNo rakhce
        adapter=new ContactAdapter(this,contractList,this);
        recyclerView.setAdapter(adapter);


    }

    @Override
    public void onclick(Contact contact) {
        Toast.makeText(MainActivity.this,contact.getName(),Toast.LENGTH_SHORT).show();
        Toast.makeText(MainActivity.this,contact.getPhone(),Toast.LENGTH_SHORT).show();

    }
}
