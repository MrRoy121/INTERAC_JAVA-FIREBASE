package com.example.interac;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class AboutUsActivity extends AppCompatActivity {

    TextView aboutus, quality, laptop;
    FirebaseFirestore fs = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_about_us);

        aboutus = findViewById(R.id.aboutus);
        quality = findViewById(R.id.quality);
        laptop = findViewById(R.id.laptop);
        fs.collection("About Us").document("aboutus").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot d) {
                if(d.exists()){
                    aboutus.setText(d.getString("About Us"));
                    quality.setText(d.getString("Quality Academics"));
                    laptop.setText(d.getString("Laptop"));
                }
            }
        });

    }
}
