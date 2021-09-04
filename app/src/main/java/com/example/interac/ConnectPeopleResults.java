package com.example.interac;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.interac.kits.CustomAdapter;
import com.example.interac.kits.DataModel;
import com.example.interac.kits.MyData;
import com.example.interac.kits.campusResourseModel;
import com.example.interac.kits.eventListAdapter;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class ConnectPeopleResults extends AppCompatActivity {

    FirebaseFirestore fs = FirebaseFirestore.getInstance();
    private ArrayList<DataModel> listdata = new ArrayList<>();
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_people_results);


        t1 = findViewById(R.id.t1);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        CustomAdapter adapter = new CustomAdapter(listdata);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


        if(getIntent().getStringExtra("s").equals("alumni")){
            t1.setText("Alumni");
            fs.collection("Connect_Alumni").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                @Override
                public void onSuccess(QuerySnapshot q) {
                    if(!q.isEmpty()){
                        for(DocumentSnapshot d: q){
                            listdata.add(new DataModel(d.getString("Name"), d.getString("Email"), d.getString("Phone"), d.getString("Nickname"), d.getString("Birthday"), d.getString("Gender"), d.getString("Description"), d.getString("About Me") ));
                            adapter.notifyDataSetChanged();
                        }
                    }
                }
            });
        }else if(getIntent().getStringExtra("s").equals("emp")){
            t1.setText("Employees");
            fs.collection("Connect_Employees").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                @Override
                public void onSuccess(QuerySnapshot q) {
                    if(!q.isEmpty()){
                        for(DocumentSnapshot d: q){
                            listdata.add(new DataModel(d.getString("Name"), d.getString("Email"), d.getString("Phone"), d.getString("Nickname"), d.getString("Birthday"), d.getString("Gender"), d.getString("Description"), d.getString("About Me") ));
                            adapter.notifyDataSetChanged();
                        }
                    }
                }
            });
        }else if(getIntent().getStringExtra("s").equals("flt")){
            t1.setText("Faculty");
            fs.collection("Connect_Faculty").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                @Override
                public void onSuccess(QuerySnapshot q) {
                    if(!q.isEmpty()){
                        for(DocumentSnapshot d: q){
                            listdata.add(new DataModel(d.getString("Name"), d.getString("Email"), d.getString("Phone"), d.getString("Nickname"), d.getString("Birthday"), d.getString("Gender"), d.getString("Description"), d.getString("About Me") ));
                            adapter.notifyDataSetChanged();
                        }
                    }
                }
            });
        }else if(getIntent().getStringExtra("s").equals("rlt")){
            t1.setText("Residence");
            fs.collection("Connect_Residence").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                @Override
                public void onSuccess(QuerySnapshot q) {
                    if(!q.isEmpty()){
                        for(DocumentSnapshot d: q){
                            listdata.add(new DataModel(d.getString("Name"), d.getString("Email"), d.getString("Phone"), d.getString("Nickname"), d.getString("Birthday"), d.getString("Gender"), d.getString("Description"), d.getString("About Me") ));
                            adapter.notifyDataSetChanged();
                        }
                    }
                }
            });
        }else if(getIntent().getStringExtra("s").equals("stu")){
            t1.setText("Students");
            fs.collection("Connect_Students").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                @Override
                public void onSuccess(QuerySnapshot q) {
                    if(!q.isEmpty()){
                        for(DocumentSnapshot d: q){
                            listdata.add(new DataModel(d.getString("Name"), d.getString("Email"), d.getString("Phone"), d.getString("Nickname"), d.getString("Birthday"), d.getString("Gender"), d.getString("Description"), d.getString("About Me") ));
                            adapter.notifyDataSetChanged();
                        }
                    }
                }
            });
        }else if(getIntent().getStringExtra("s").equals("upd")){
            t1.setText("UPD");
            fs.collection("Connect_UPD").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                @Override
                public void onSuccess(QuerySnapshot q) {
                    if(!q.isEmpty()){
                        for(DocumentSnapshot d: q){
                            listdata.add(new DataModel(d.getString("Name"), d.getString("Email"), d.getString("Phone"), d.getString("Nickname"), d.getString("Birthday"), d.getString("Gender"), d.getString("Description"), d.getString("About Me") ));
                            adapter.notifyDataSetChanged();
                        }
                    }
                }
            });
        }

    }
}