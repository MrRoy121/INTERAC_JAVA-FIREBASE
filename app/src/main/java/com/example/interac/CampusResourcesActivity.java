package com.example.interac;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.interac.kits.campusResourseAdapter;
import com.example.interac.kits.campusResourseModel;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class CampusResourcesActivity extends AppCompatActivity {

    private ArrayList<campusResourseModel> listdata = new ArrayList<>();
    FirebaseFirestore fs = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_campus_resources);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        campusResourseAdapter adapter = new campusResourseAdapter(listdata, CampusResourcesActivity.this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        fs.collection("Campus Resources").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot q) {
                if(!q.isEmpty()){
                    for(DocumentSnapshot d: q){
                        ArrayList<String> cons  = (ArrayList<String>) d.get("Contact Information");
                        String con = "";

                        if(cons.size()>1){
                            for(String sss: cons){
                                con = con + "\n" + sss;
                            }
                        }else if(cons.size() == 1){
                            con = cons.get(0);
                        }else{
                            con = "";
                        }

                        listdata.add(new campusResourseModel(d.getId(), d.getString("Details"), d.getString("image"), d.getString("Year completed"),con, d.getString("Total square feet"), String.valueOf(d.get("Timings"))));
                        adapter.notifyDataSetChanged();
                    }
                }
            }
        });
    }
}
