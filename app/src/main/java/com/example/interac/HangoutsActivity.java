package com.example.interac;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.interac.kits.campusResourseAdapter;
import com.example.interac.kits.campusResourseModel;
import com.example.interac.kits.hangoutAdapter;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class HangoutsActivity extends AppCompatActivity {

    private ArrayList<campusResourseModel> listdata = new ArrayList<>();
    FirebaseFirestore fs = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);



        setContentView(R.layout.activity_hangouts);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        hangoutAdapter adapter = new hangoutAdapter(listdata, HangoutsActivity.this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        fs.collection("Hangouts").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot q) {
                if(!q.isEmpty()){
                    for(DocumentSnapshot d: q){
                        listdata.add(new campusResourseModel(d.getId(), d.getString("details"), d.getString("image"), d.getString("hours")));
                        adapter.notifyDataSetChanged();
                    }
                }
            }
        });
    }
}
