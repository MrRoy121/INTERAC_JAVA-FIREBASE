package com.example.interac;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;

import com.example.interac.kits.campusResourseAdapter;
import com.example.interac.kits.campusResourseModel;
import com.example.interac.kits.eventListAdapter;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class EventListActivity extends AppCompatActivity {

    private ArrayList<campusResourseModel> listdata = new ArrayList<>();
    FirebaseFirestore fs = FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_event_list);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        eventListAdapter adapter = new eventListAdapter(listdata, EventListActivity.this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        fs.collection("CAREER EVENTS").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot q) {
                if(!q.isEmpty()){
                    for(DocumentSnapshot d: q){
                        listdata.add(new campusResourseModel(d.getId(), d.getString("details"), d.getString("image")));
                        adapter.notifyDataSetChanged();
                    }
                }
            }
        });
    }
}