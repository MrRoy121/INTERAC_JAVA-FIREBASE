package com.example.interac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class othersActivity extends AppCompatActivity {

    TextView t2, t3, t1, t4,t5,t6, t7, s2, s3, s4,s5,s6, s7, ss1,ss2;
    FirebaseFirestore fs = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_others);

        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        t1 = findViewById(R.id.t1);
        t4 = findViewById(R.id.t4);
        t5 = findViewById(R.id.t5);
        t6 = findViewById(R.id.t6);
        t7 = findViewById(R.id.t7);
        s2 = findViewById(R.id.s2);
        s3 = findViewById(R.id.s3);
        s4 = findViewById(R.id.s4);
        s5 = findViewById(R.id.s5);
        s6 = findViewById(R.id.s6);
        s7 = findViewById(R.id.s7);
        ss1= findViewById(R.id.ss1);
        ss2 = findViewById(R.id.ss2);

        if(getIntent().getStringExtra("s").equals("OFF")){
            t1.setText("OFF-CAMPUS EVENTS");
            fs.collection("Others").document("OFF-CAMPUS EVENTS").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot d) {
                    if(d.exists()){
                        String ss = d.getString("details").replace("_b", "\n");
                        t2.setText(ss);
                    }
                }
            });
        }else if(getIntent().getStringExtra("s").equals("SAC")){
            t1.setText("SAC EVENTS");
            fs.collection("Others").document("SAC EVENTS").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot d) {
                    if(d.exists()){
                        t2.setText(d.getString("details"));
                    }
                }
            });
        }else if(getIntent().getStringExtra("s").equals("aa")){
            t1.setText("Academic Organization");
            fs.collection("Organizations").document("Academic").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot d) {
                    if(d.exists()){
                        ArrayList<String > arr = (ArrayList<String>) d.get("array");
                        t2.setText(arr.get(0));
                        t3.setText(arr.get(1));
                        t4.setText(arr.get(2));
                        t5.setText(arr.get(3));
                        t6.setText(arr.get(4));
                        s2.setText(d.getString("t1"));
                        s3.setText(d.getString("t2"));
                        s4.setText(d.getString("t3"));
                        s5.setText(d.getString("t4"));
                        s6.setText(d.getString("t5"));
                    }
                }
            });
        }else if(getIntent().getStringExtra("s").equals("st")){
            t1.setText("Student Organization");
            fs.collection("Organizations").document("Student").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot d) {
                    if(d.exists()){
                        ArrayList<String > arr = (ArrayList<String>) d.get("array");
                        t2.setText(arr.get(0));
                        t3.setText(arr.get(1));
                        t4.setText(arr.get(2));
                        t5.setText(arr.get(3));
                        t6.setText(arr.get(4));
                        s2.setText(d.getString("t1"));
                        s3.setText(d.getString("t2"));
                        s4.setText(d.getString("t3"));
                        s5.setText(d.getString("t4"));
                        s6.setText(d.getString("t5"));

                    }
                }
            });
        }else if(getIntent().getStringExtra("s").equals("sp")){
            t1.setText("Sports club Organization");
            fs.collection("Organizations").document("Sports club").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot d) {
                    if(d.exists()){
                        ArrayList<String > arr = (ArrayList<String>) d.get("array");
                        t2.setText(arr.get(0));
                        t3.setText(arr.get(1));
                        t4.setText(arr.get(2));
                        t5.setText(arr.get(3));
                        s2.setText(d.getString("t1"));
                        s3.setText(d.getString("t2"));
                        s4.setText(d.getString("t3"));
                        s5.setText(d.getString("t4"));
                    }
                }
            });
        }else if(getIntent().getStringExtra("s").equals("mlt")){
            t1.setText("Multicultural Organization");
            fs.collection("Organizations").document("Multicultural").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot d) {
                    if(d.exists()){
                        ArrayList<String > arr = (ArrayList<String>) d.get("array");
                        t2.setText(arr.get(0));
                        t3.setText(arr.get(1));
                        t4.setText(arr.get(2));
                        t5.setText(arr.get(3));
                        t6.setText(arr.get(4));
                        t7.setText(arr.get(5));
                        s2.setText(d.getString("t1"));
                        s3.setText(d.getString("t2"));
                        s4.setText(d.getString("t3"));
                        s5.setText(d.getString("t4"));
                    }
                }
            });
        }else if(getIntent().getStringExtra("s").equals("pf")){
            t1.setText("Performing Organization");
            fs.collection("Organizations").document("Performing").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot d) {
                    if(d.exists()){
                        ArrayList<String > arr = (ArrayList<String>) d.get("array");
                        t2.setText(arr.get(0));
                        t3.setText(arr.get(1));
                        s2.setText(d.getString("t1"));
                        s3.setText(d.getString("t2"));
                    }
                }
            });
        }else if(getIntent().getStringExtra("s").equals("go")){
            t1.setText("Governing");
            fs.collection("Organizations").document("Governing").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot d) {
                    if(d.exists()){
                        t2.setText(d.getString("Christian Campus House"));
                        t3.setText(d.getString("Lutheran Campus Center"));
                        t4.setText(d.getString("The Bridge YA"));
                        t5.setText(d.getString("The Lighthouse at Northwest"));
                        t6.setText(d.getString("The Navigators"));
                        t7.setText(d.getString("Wesley Student Center"));
                        s2.setText("Christian Campus House");
                        s3.setText("Lutheran Campus Center");
                        s4.setText("The Bridge YA");
                        s5.setText("The Lighthouse at Northwest");
                        s6.setText("The Navigators");
                        s7.setText("Wesley Student Center");
                    }
                }
            });
        }else{
            t1.setText("SPORTS");
            fs.collection("Others").document("SPORTS").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot d) {
                    if(d.exists()){
                        ss1.setVisibility(View.VISIBLE);
                        ss2.setVisibility(View.VISIBLE);
                        ss1.setText(d.getString("details"));
                        ArrayList<String >arr = (ArrayList<String>) d.get("array");
                        String ss = "";
                        for(String s: arr){
                            ss = ss + "\n" + s;
                        }
                        ss2.setText(ss);
                    }
                }
            });
        }

        ss1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://bearcatsports.com/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }
}