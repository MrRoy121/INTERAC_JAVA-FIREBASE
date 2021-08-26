package com.example.interac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Map;

public class AlumniActivity extends AppCompatActivity {

    TextView t1, t2, t3, t4, t5, t6, t7, t8;
    FirebaseFirestore fs = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumni);
        getSupportActionBar().hide();

        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        t4 = findViewById(R.id.t4);
        t5 = findViewById(R.id.t5);
        t6 = findViewById(R.id.t6);
        t7 = findViewById(R.id.t7);
        t8 = findViewById(R.id.t8);

        fs.collection("ALUMNI").document("50TH-YEAR REUNION").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot d) {
                if(d.exists()){
                   t8.setText(d.getString("ALUMNI AWARDS"));
                   t2.setText(d.getString("details"));
                   t4.setText(d.getString("Friday, October 21"));
                   t6.setText(d.getString("Saturday, October 22"));
                }
            }
        });
    }
}