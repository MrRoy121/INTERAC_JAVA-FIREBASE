package com.example.interac;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.interac.kits.calenderModel;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AcademicCalendar extends AppCompatActivity {

    Button b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b1,b2,b3;
    FirebaseFirestore fs = FirebaseFirestore.getInstance();
    ArrayList<calenderModel> allcallender = new ArrayList<>();
    static ArrayList<calenderModel> senditem = new ArrayList<>();
    String session = "22-23";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_academic_calendar);

        b10 = (Button) findViewById(R.id.button10);
        b11 = (Button)findViewById(R.id.button11);
        b12 = (Button)findViewById(R.id.button12);
        b13 = (Button)findViewById(R.id.button13);
        b14 = (Button)findViewById(R.id.button14);
        b15 = (Button)findViewById(R.id.button15);
        b16 = (Button)findViewById(R.id.button16);
        b17 = (Button)findViewById(R.id.button17);
        b18 = (Button)findViewById(R.id.button18);
        b19 = (Button)findViewById(R.id.button19);
        b20 =(Button) findViewById(R.id.button20);
        b21 =(Button) findViewById(R.id.button21);

        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                session = "22-23";
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                session = "23-24";
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                session = "24-25";
            }
        });
        fs.collection("ACADEMIC CALENDAR").orderBy("Event", Query.Direction.DESCENDING).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot q) {
                if(!q.isEmpty()){
                    for(DocumentSnapshot d: q){
                        if(d.getBoolean("Has")){
                            allcallender.add(new calenderModel((Map<String, String>) d.get("Event"), true));
                        }else{
                            allcallender.add(new calenderModel((Map<String, String>) d.get("Event"), false));
                        }
                    }
                }
            }
        });

        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senditem = new ArrayList<>();
                for(calenderModel c: allcallender){
                    if(c.getHas()){

                    }else{
                        String s = String.valueOf(c.getEvent().get("Date")) + c.getEvent().get("Event");
                        long l = Long.parseLong(s.substring(18,28));
                        Date d = new Date(l * 1000);
                        if(String.valueOf(d.getMonth()).equals("0")){
                            senditem.add(new calenderModel(c.getEvent(), d, false));
                        }
                    }
                }
                seeEvents();
            }
        });
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senditem = new ArrayList<>();
                for(calenderModel c: allcallender){
                    if(c.getHas()){

                    }else{
                        String s = String.valueOf(c.getEvent().get("Date")) + c.getEvent().get("Event");
                        long l = Long.parseLong(s.substring(18,28));
                        Date d = new Date(l * 1000);
                        if(String.valueOf(d.getMonth()).equals("1")){
                            senditem.add(new calenderModel(c.getEvent(), d, false));

                        }
                    }
                }
                seeEvents();
            }
        });
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senditem = new ArrayList<>();
                for(calenderModel c: allcallender){
                    if(c.getHas()){

                    }else{
                        String s = String.valueOf(c.getEvent().get("Date")) + c.getEvent().get("Event");
                        long l = Long.parseLong(s.substring(18,28));
                        Date d = new Date(l * 1000);
                        if(String.valueOf(d.getMonth()).equals("2")){
                            senditem.add(new calenderModel(c.getEvent(), d, false));

                        }
                    }
                }
                seeEvents();
            }
        });
        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senditem = new ArrayList<>();
                for(calenderModel c: allcallender){
                    if(c.getHas()){

                    }else{
                        String s = String.valueOf(c.getEvent().get("Date")) + c.getEvent().get("Event");
                        long l = Long.parseLong(s.substring(18,28));
                        Date d = new Date(l * 1000);
                        if(String.valueOf(d.getMonth()).equals("3")){
                            senditem.add(new calenderModel(c.getEvent(), d, false));

                        }
                    }
                }
                seeEvents();
            }
        });
        b14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senditem = new ArrayList<>();
                for(calenderModel c: allcallender){
                    if(c.getHas()){

                    }else{
                        String s = String.valueOf(c.getEvent().get("Date")) + c.getEvent().get("Event");
                        long l = Long.parseLong(s.substring(18,28));
                        Date d = new Date(l * 1000);
                        if(String.valueOf(d.getMonth()).equals("4")){
                            senditem.add(new calenderModel(c.getEvent(), d, false));

                        }
                    }
                }
                seeEvents();
            }
        });
        b15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senditem = new ArrayList<>();
                for(calenderModel c: allcallender){
                    if(c.getHas()){

                    }else{
                        String s = String.valueOf(c.getEvent().get("Date")) + c.getEvent().get("Event");
                        long l = Long.parseLong(s.substring(18,28));
                        Date d = new Date(l * 1000);
                        if(String.valueOf(d.getMonth()).equals("5")){
                            senditem.add(new calenderModel(c.getEvent(), d, false));

                        }
                    }
                }
                seeEvents();
            }
        });
        b16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senditem = new ArrayList<>();
                for(calenderModel c: allcallender){
                    if(c.getHas()){

                    }else{
                        String s = String.valueOf(c.getEvent().get("Date")) + c.getEvent().get("Event");
                        long l = Long.parseLong(s.substring(18,28));
                        Date d = new Date(l * 1000);
                        if(String.valueOf(d.getMonth()).equals("6")){
                            senditem.add(new calenderModel(c.getEvent(), d, false));

                        }
                    }
                }
                seeEvents();
            }
        });
        b17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senditem = new ArrayList<>();
                for(calenderModel c: allcallender){
                    if(c.getHas()){

                    }else{
                        String s = String.valueOf(c.getEvent().get("Date")) + c.getEvent().get("Event");
                        long l = Long.parseLong(s.substring(18,28));
                        Date d = new Date(l * 1000);
                        if(String.valueOf(d.getMonth()).equals("7")){
                            senditem.add(new calenderModel(c.getEvent(), d, false));

                        }
                    }
                }
                seeEvents();
            }
        });
        b18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senditem = new ArrayList<>();
                for(calenderModel c: allcallender){
                    if(c.getHas()){

                    }else{
                        String s = String.valueOf(c.getEvent().get("Date")) + c.getEvent().get("Event");
                        long l = Long.parseLong(s.substring(18,28));
                        Date d = new Date(l * 1000);
                        if(String.valueOf(d.getMonth()).equals("8")){
                            senditem.add(new calenderModel(c.getEvent(), d, false));

                        }
                    }
                }
                seeEvents();
            }
        });
        b19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senditem = new ArrayList<>();
                for(calenderModel c: allcallender){
                    if(c.getHas()){

                    }else{
                        String s = String.valueOf(c.getEvent().get("Date")) + c.getEvent().get("Event");
                        long l = Long.parseLong(s.substring(18,28));
                        Date d = new Date(l * 1000);
                        if(String.valueOf(d.getMonth()).equals("9")){
                            senditem.add(new calenderModel(c.getEvent(), d, false));

                        }
                    }
                }
                seeEvents();
            }
        });
        b20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senditem = new ArrayList<>();
                for(calenderModel c: allcallender){
                    if(c.getHas()){

                    }else{
                        String s = String.valueOf(c.getEvent().get("Date")) + c.getEvent().get("Event");
                        long l = Long.parseLong(s.substring(18,28));
                        Date d = new Date(l * 1000);
                        if(String.valueOf(d.getMonth()).equals("10")){
                            senditem.add(new calenderModel(c.getEvent(), d, false));

                        }
                    }
                }
                seeEvents();
            }
        });
        b21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senditem = new ArrayList<>();
                for(calenderModel c: allcallender){
                    if(c.getHas()){

                    }else{
                        String s = String.valueOf(c.getEvent().get("Date")) + c.getEvent().get("Event");
                        long l = Long.parseLong(s.substring(18,28));
                        Date d = new Date(l * 1000);
                        if(String.valueOf(d.getMonth()).equals("11")){
                            senditem.add(new calenderModel(c.getEvent(), d, false));
                        }
                    }
                }
                seeEvents();
            }
        });
    }

    public void seeEvents() {
        Intent i = new Intent(AcademicCalendar.this, CalenderView.class);
        i.putExtra("Session", session);
        startActivity(i);

    }
}